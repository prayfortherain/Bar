package com.example.bar

import android.annotation.SuppressLint
import androidx.compose.foundation.clickable
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
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import io.realm.kotlin.Realm


@Composable
fun CocktailCard(cocktail: Cocktail, navController: NavController) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .clickable(
                onClick = {
                    var name = cocktail.name
                    navController.navigate("result/$name")
                }
            )
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




@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CocktailListScreen(viewModel: BarViewModel, navController: NavController) {

    val cocktails by viewModel.cocktails.collectAsState()

    /*
    Scaffold(
        topBar = {
            TopAppBar(title = { Text(text = "Рецепты Коктейлей", fontSize = 13.sp) })
        },
        content = {
            if (cocktails.isNotEmpty()) {
                LazyColumn(
                    modifier = Modifier.padding()
                ){
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

     */
    LazyColumn(
        modifier = Modifier.padding()
    ){
        items(cocktails) { cocktail ->
            CocktailCard(cocktail = cocktail, navController)
        }
    }
}
