package com.example.bar

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

/*
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun BarPreview() {
    CocktailListScreen()
}

@Composable
fun CocktailCard(cocktail: Cocktail) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Column {
            Text(
                text = cocktail.name,
                modifier = Modifier.padding(16.dp)
            )
            Text(
                text = cocktail.instructions,
                modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
            )
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun CocktailListScreen() {
    val cocktails = listOf(
        Cocktail(1, "Маргарита", listOf("Текила", "Лайм", "Апельсиновый ликёр"), "Смешать ингредиенты и украсить солью.", "https://example.com/margarita.jpg"),
        Cocktail(2, "Мохито", listOf("Ром", "Лайм", "Мята", "Сахар", "Газированная вода"), "Размять лайм и мяту, добавить ром, сахар и газированную воду.", "https://example.com/mojito.jpg")
    )

    Scaffold(
        topBar = {
            TopAppBar(title = { Text(text = "Рецепты Коктейлей") })
        },
        content = {
            if (cocktails.isNotEmpty()) {
                LazyColumn {
                    items(cocktails) { cocktail ->
                        CocktailCard(cocktail = cocktail)
                    }
                }
            } else {
                Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                    CircularProgressIndicator()
                }
            }
        }
    )
}


data class Cocktail(
    val id: Int,
    val name: String,
    val ingredients: List<String>,
    val instructions: String,
    val imageUrl: String? = null
)

 */
