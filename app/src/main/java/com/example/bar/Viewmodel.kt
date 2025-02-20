package com.example.bar

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import io.realm.kotlin.Realm
import io.realm.kotlin.ext.query
import io.realm.kotlin.query.RealmResults
import io.realm.kotlin.types.RealmList
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class BarViewModel(realm: Realm) : ViewModel() {

    val cocktails = realm
        .query<Cocktail>()
        .asFlow()
        .map { results ->
            results.list.toList()
        }
        .stateIn( //специальный вид потока, который хранит последнее значение и "проигрывает" его новым подписчикам
            viewModelScope, // StateFlow будет отменен, когда viewModelScope будет закрыта (например, при уничтожении ViewModel)
            SharingStarted.WhileSubscribed(), //поток будет активен, пока на него подписан хотя бы один слушатель, и будет автоматически приостановлен, когда подписчиков не останется
            emptyList() //начальное значение
        )

    fun getCocktailByName(cocktailName: String, realm: Realm): Cocktail? {
        return realm.query<Cocktail>("name = $cocktailName", cocktailName).first().find()
    }

    init {
        /*
        if (!SharedPreferences.containsData()) {
            setDefaultData(realm)
            //SharedPreferences.setDB()
        }*/
        setDefaultData(realm)

    }


    private fun setDefaultData(realm: Realm) {
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

                copyToRealm(
                    Cocktail().apply {
                        name = "Screwdriver"
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
                        instructions = "Mix Vodka with ginger beer and lime juice."
                        taste = "Spicy"
                        base = "Alcohol"
                        group = "Short drink"
                        color = "Golden"
                    }
                )

                copyToRealm(
                    Cocktail().apply {
                        name = "Margarita"
                        instructions = "Combine tequila, lime juice, and orange liqueur."
                        taste = "Tangy"
                        base = "Alcohol"
                        group = "Short drink"
                        color = "Greenish-yellow"
                    }
                )

                copyToRealm(
                    Cocktail().apply {
                        name = "Mojito"
                        instructions =
                            "Muddle mint leaves with sugar and lime juice. Add rum, club soda, and ice."
                        taste = "Minty and Refreshing"
                        base = "Alcohol"
                        group = "Long drink"
                        color = "Clear/Light Green"
                    }
                )

                copyToRealm(
                    Cocktail().apply {
                        name = "Pina Colada"
                        instructions = "Blend rum, pineapple juice, and coconut cream."
                        taste = "Sweet and Tropical"
                        base = "Alcohol"
                        group = "Long drink"
                        color = "Creamy White"
                    }
                )

                copyToRealm(
                    Cocktail().apply {
                        name = "Daiquiri"
                        instructions = "Mix rum, lime juice, and simple syrup."
                        taste = "Tart and Sweet"
                        base = "Alcohol"
                        group = "Short drink"
                        color = "Clear/Light Yellow"
                    }
                )

                copyToRealm(
                    Cocktail().apply {
                        name = "Cosmopolitan"
                        instructions = "Combine vodka, cranberry juice, lime juice, and triple sec."
                        taste = "Sweet and Tart"
                        base = "Alcohol"
                        group = "Short drink"
                        color = "Pink"
                    }
                )

                copyToRealm(
                    Cocktail().apply {
                        name = "Old Fashioned"
                        instructions =
                            "Muddle sugar with bitters, add whiskey, and garnish with an orange peel."
                        taste = "Strong and Smooth"
                        base = "Alcohol"
                        group = "Short drink"
                        color = "Amber"
                    }
                )

                copyToRealm(
                    Cocktail().apply {
                        name = "Negroni"
                        instructions = "Mix gin, Campari, and sweet vermouth."
                        taste = "Bitter and Herbal"
                        base = "Alcohol"
                        group = "Short drink"
                        color = "Red"
                    }
                )

                copyToRealm(
                    Cocktail().apply {
                        name = "Bloody Mary"
                        instructions =
                            "Combine vodka, tomato juice, Worcestershire sauce, Tabasco, and spices."
                        taste = "Savory and Spicy"
                        base = "Alcohol"
                        group = "Long drink"
                        color = "Red"
                    }
                )

            }
        }
    }
}


//изменение