package sbis.faceinfo.presentation.search.view.activity

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.Context
import android.content.Intent
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.support.v7.widget.LinearLayoutManager
import com.jakewharton.rxbinding2.widget.RxTextView
import io.reactivex.android.schedulers.AndroidSchedulers
import sbis.App
import sbis.data.model.presentation.PersonSearch
import sbis.faceinfo.R
import sbis.faceinfo.databinding.ActivitySearchBinding
import sbis.faceinfo.presentation.search.contracts.SearchVmContract
import sbis.faceinfo.presentation.search.interactor.SearchInteractor
import sbis.faceinfo.presentation.search.presenter.SearchPresenter
import sbis.faceinfo.presentation.search.router.SearchRouter
import sbis.faceinfo.presentation.search.view.adapter.SearchPersonAdapter
import sbis.faceinfo.presentation.search.viewModel.SearchViewModel
import sbis.helpers.arch.base.BaseActivity
import sbis.helpers.view.ItemListDecorator
import java.util.concurrent.TimeUnit

//TODO: ЗАДАНИЕ #3
/**
 * Задание №3.
 *
 * Создание экрана с отображением списка сотрудников.
 *
 * Задачи:
 *
 * 1. Выводить список сотрудников на экране.
 * 2. Долгое нажатие на "крестик" должно приводить
 *    к открытию экрана с настройками.
 * 3. Осуществление запросов к серверу.
 * 4. Обработка полученного сообщения от сервера.
 * */
class SearchActivity : BaseActivity<SearchVmContract.Presenter, SearchVmContract.ViewModel>() {

    companion object {
        fun createIntent(context: Context): Intent =
            Intent(context, SearchActivity::class.java).apply {
                /* put your args */
            }
    }

    private lateinit var binding: ActivitySearchBinding
    private lateinit var searchPersonAdapter: SearchPersonAdapter

    override fun createPresenter(): SearchVmContract.Presenter =
        SearchPresenter(
            SearchInteractor(App.get().getNetworkService()),
            SearchRouter()
        )

    override fun createViewModel(): SearchVmContract.ViewModel =
        ViewModelProviders.of(this).get(SearchViewModel::class.java)

    private val searchPersonListener = object : SearchPersonAdapter.OnPersonClickListener {
        override fun onClick(person: PersonSearch) {
            presenter.onPersonSelected(person)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_search)
        binding.setLifecycleOwner(this@SearchActivity)
        binding.viewModel = viewModel

        searchPersonAdapter = SearchPersonAdapter(searchPersonListener).apply {
            setItems(viewModel.searchPersons.value ?: emptyList())
        }

        val linLayoutManager = LinearLayoutManager(this)

        binding.rvSearchResult.apply {
            //TODO: настройка виджета RecyclerView
            adapter = searchPersonAdapter
            layoutManager = linLayoutManager
            setHasFixedSize(true)
            addItemDecoration(ItemListDecorator(
                ContextCompat.getDrawable(context, R.drawable.list_divider)!!, true))

            // adapter
            // layoutManager
            // fixSize
            // itemDecorator - ItemListDecorator(ContextCompat.getDrawable(context, R.drawable.list_divider)!!, true)
        }

        val searchStartCount = 3
        binding.textSearchRequest.let { it ->
            RxTextView.afterTextChangeEvents(it).debounce(500, TimeUnit.MILLISECONDS)
                .map<String> { _ -> it.text.toString() }
                .filter { searchText -> searchText.length > searchStartCount }
                .filter { searchText -> searchText != viewModel.searchRequest.value }
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe { searchRequest -> presenter.updateSearchRequest(searchRequest) }
        }

        binding.clearButton.setOnClickListener {
            binding.textSearchRequest.text.clear()
        }

        binding.clearButton.setOnLongClickListener {
            presenter.onSecretLongClick()
            return@setOnLongClickListener true
        }
    }

    override fun createSubscribers() {
        viewModel.searchPersons.observe(this@SearchActivity, Observer { items ->
            items?.let { searchPersonAdapter.setItems(it) }
        })

        viewModel.errorMessage.observe(this@SearchActivity, Observer { errorMessage ->
            errorMessage?.let { showErrorMessage(it) }
        })
    }
}