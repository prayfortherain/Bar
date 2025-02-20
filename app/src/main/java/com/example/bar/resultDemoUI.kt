package com.example.bar

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import io.realm.kotlin.Realm

@Composable
fun CocktailResult(viewModel: BarViewModel, realm: Realm, argumentValue: String) {

    val cocktail = viewModel.getCocktailByName(argumentValue, realm)


    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        shape = RoundedCornerShape(8.dp)
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
        ) {
            Text(
                text = cocktail!!.name
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(text = "Instructions:")
            Text(text = cocktail!!.instructions)

            Spacer(modifier = Modifier.height(8.dp))

            BottomOfScreen(cocktail)

        }
    }
}

@Composable
fun BottomOfScreen(cocktail: Cocktail){
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        CocktailProperty("Taste:", cocktail.taste)
        CocktailProperty("Base:", cocktail.base)
        CocktailProperty("Group:", cocktail.group)
        CocktailProperty("Color:", cocktail.color)
    }
}


@Composable
fun CocktailProperty(label: String, value: String) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = label)
        Text(text = value)
    }
}
