package com.example.bar

import android.content.Context
import android.content.SharedPreferences

object SharedPreferences {

    private const val PREFS_NAME = "MyPrefs"
    private const val DB_EXISTS = "db_exist"

    private lateinit var sharedPreferences: SharedPreferences

    fun init(context: Context) {
        sharedPreferences = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
    }

    fun containsData(): Boolean {
        return sharedPreferences.contains(DB_EXISTS)
    }

    fun setDB(){
        sharedPreferences.edit().putString(DB_EXISTS, "true").apply()
    }


    fun setData(keyword: String, data: String) {
        sharedPreferences.edit().putString(keyword, data).apply()
    }

    fun getData(keyword: String): String? {
        return sharedPreferences.getString(keyword, "")
    }

    fun clearData() {
        val editor = sharedPreferences.edit()
        editor.clear().apply()
    }
}
