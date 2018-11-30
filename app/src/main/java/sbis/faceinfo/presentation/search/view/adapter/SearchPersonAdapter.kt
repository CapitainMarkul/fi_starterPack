package sbis.faceinfo.presentation.search.view.adapter

import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import sbis.data.model.presentation.PersonSearch
import sbis.faceinfo.R
import sbis.faceinfo.databinding.ItemSearchPersonBinding
import sbis.helpers.view.BaseAdapter

class SearchPersonAdapter(val listener: OnPersonClickListener) :
    BaseAdapter<SearchPersonAdapter.ViewHolder, PersonSearch>() {

    interface OnPersonClickListener {
        fun onClick(person: PersonSearch)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(
            DataBindingUtil.bind(
                LayoutInflater.from(parent.context).inflate(R.layout.item_search_person, parent, false)
            )!!
        )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val person = itemList[position]
        holder.bindView.root.setOnClickListener { listener.onClick(person) }
        holder.bind(person)
    }

    class ViewHolder(var bindView: ItemSearchPersonBinding) : RecyclerView.ViewHolder(bindView.root) {

        fun bind(viewModel: PersonSearch) {
            with(bindView) {
                this.viewModel = viewModel
                executePendingBindings()
            }
        }
    }
}