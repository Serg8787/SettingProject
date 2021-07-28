package com.example.settingproject

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.preference.PreferenceManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mySettings()


    }

    @SuppressLint("ResourceAsColor")
    private fun mySettings() {
        val prefs = PreferenceManager.getDefaultSharedPreferences(this)

        // Имя геймера
        val name = prefs.getString("signature","")
        tvName.text = name

            // Любимый жанр геймера
        val favoruiteJenre = prefs.getString("favoruite_jenre_list","")
        tvFavoruiteGameGenre.text = favoruiteJenre

            // Переключатель автосохранения
        val switchAutoSave = prefs.getBoolean("autosave", false)
        if(switchAutoSave){
            tvAutoSave.text = "On"
        } else {
            tvAutoSave.text = "Off"
        }
        // Переключатель графики
        val switchGrafics = prefs.getBoolean("graphics", false)
        if(switchGrafics){
            tvGraphics.text = "High"
        } else {
            tvGraphics.text = "Low"
        }

                // Переключатель языка
        val switchLanguage = prefs.getBoolean("language", false)
        if(switchLanguage){
            tvLanguage.text = "RU"
        } else {
            tvLanguage.text = "EN"
        }


    }

    // Вверхнее меню
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.setting_menu, menu)
        return super.onCreateOptionsMenu(menu)

    }

    // Выбор item в верхнем меню
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_settings -> {
                val intent = Intent(this, SettingsActivity::class.java)
                startActivity(intent)
            }
        }
        return super.onOptionsItemSelected(item)
    }
}