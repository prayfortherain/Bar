package com.example.bar

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import io.realm.kotlin.ext.query
import io.realm.kotlin.types.RealmList
import kotlinx.coroutines.launch

class BarViewModel : ViewModel() {
    private val realm = Bar.realm

    init {
        if (!SharedPreferences.containsData()) {
            //setDefaultData()
            SharedPreferences.setDB()
        }
    }


    private fun setDefaultData() {
        viewModelScope.launch {
            // Заполняем таблицу Notes
            realm.write {
                copyToRealm(
                    Notes().apply {
                        name = "Note 1"
                        description = "Description for Note 1"
                    }
                )

                copyToRealm(
                    Notes().apply {
                        name = "Note 2"
                        description = "Description for Note 2"
                    }
                )
            }

            // Заполняем таблицу Ingredient
            realm.write {
                copyToRealm(
                    Ingredient().apply {
                        name = "Vodka"
                        taste = "Strong"
                        degree = "40%"
                        base = "Alcohol"
                    }
                )

                copyToRealm(
                    Ingredient().apply {
                        name = "Orange Juice"
                        taste = "Sweet"
                        degree = "0%"
                        base = "Juice"
                    }
                )
            }

            // Заполняем таблицу Cocktail
            realm.write {
                val vodka = query<Ingredient>("name == 'Vodka'").first()
                val orangeJuice = query<Ingredient>("name == 'Orange Juice'").first()

                copyToRealm(
                    Cocktail().apply {
                        name = "Screwdriver"
                        ingredients = listOf(vodka, orangeJuice) /*TODO*/
                        instructions = "Mix Vodka with Orange Juice."
                        taste = "Refreshing"
                        base = "Alcohol"
                        group = "Long drink"
                        color = "Orange"
                    }
                )

                copyToRealm(
                    Cocktail().apply {
                        name = "Moscow Mule"
                        ingredients = listOf(vodka) /*TODO*/
                        instructions = "Mix Vodka with ginger beer and lime juice."
                        taste = "Spicy"
                        base = "Alcohol"
                        group = "Short drink"
                        color = "Golden"
                    }
                )
            }
        }
    }
}
