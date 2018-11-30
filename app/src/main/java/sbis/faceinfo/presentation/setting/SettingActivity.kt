package sbis.faceinfo.presentation.setting

import android.content.Context
import android.content.Intent
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import sbis.faceinfo.R
import sbis.faceinfo.databinding.ActivitySettingBinding

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

        //todo:
    }

    //todo: fun saveInputInfo(serverUrl: String, userSid: String)
    //todo: fun showSearchScreen()
}