package sbis.faceinfo.presentation.setting

import android.content.Context
import android.content.Intent
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.EditText
import sbis.App
import sbis.domain.repository.storage.StorageService
import sbis.faceinfo.R
import sbis.faceinfo.databinding.ActivitySettingBinding
import sbis.faceinfo.presentation.search.view.activity.SearchActivity

//TODO: ЗАДАНИЕ #2
/**
 * Задание №2.
 *
 * Создание экрана настроек.
 *
 * Экран предназначен для ввода SID'a пользователя
 * и URL удаленного хоста для подключения.
 *
 * 1. При старте экрана в поля ввода, выводим уже сохраненныю
 *    в SharedPreferences информацию.
 * 2. После нажатия кнопки "ОК", необходимо сохранить введенную информацию
 *    в SharedPreferences и открыть экран с поиском сотрудников.
 * */
class SettingActivity : AppCompatActivity() {

    private lateinit var storageService: StorageService
    private lateinit var sidInput: EditText
    private lateinit var serverUrlInput: EditText

    companion object {
        fun createIntent(context: Context): Intent =
            Intent(context, SettingActivity::class.java).apply {
                /* put your args */
            }
    }

    private lateinit var binding: ActivitySettingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this@SettingActivity, R.layout.activity_setting)
        storageService = App.get().getStorageService()

        serverUrlInput = binding.serverUrlId
        sidInput = binding.sidInput

        binding.settingsOkButt.setOnClickListener {
            saveInputInfo(serverUrlInput.text.toString(), sidInput.text.toString())
        }

        binding.sid = storageService.getUserSid()
        binding.url = storageService.getServerUrl()
    }

    private fun saveInputInfo(serverUrl: String, userSid: String) {
        if (storageService.getServerUrl() != serverUrl) {
            storageService.saveServerUrl(serverUrl)
        }

        if (storageService.getUserSid() != userSid) {
            storageService.saveUserSid(userSid)
        }

        showSearchScreen()
    }


    private fun showSearchScreen() {
        startActivity(SearchActivity.createIntent(this))
    }
}