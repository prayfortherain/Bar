package com.example.bar

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.bar.ui.theme.BarTheme
import io.realm.kotlin.Realm
import io.realm.kotlin.RealmConfiguration


class MainActivity : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        var realm = Realm.open(
            RealmConfiguration.create(
                schema = setOf(
                    Ingredient::class,
                    Cocktail::class,
                    Notes::class
                )
            )
        )
        val viewModel = BarViewModel(realm)



        setContent {
            BarTheme {

                val controller = rememberNavController();
                NavHost(navController = controller, startDestination = "main") {
                    composable("main"){
                        CocktailListScreen(viewModel, controller)
                    }

                    composable(
                        "result/{name}",
                        arguments = listOf(navArgument("name") { type = NavType.StringType })
                    ) { backStackEntry ->
                        val argumentValue = backStackEntry.arguments?.getString("name")?: ""
                        CocktailResult(
                            viewModel,
                            realm,
                            argumentValue
                        )
                    }
                }

            }
        }
    }
}
