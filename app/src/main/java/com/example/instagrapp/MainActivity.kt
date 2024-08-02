package com.example.instagrapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.instagrapp.login.ui.LoginScreen
import com.example.instagrapp.login.ui.LoginViewModel
import com.example.instagrapp.model.Routes
import com.example.instagrapp.ui.theme.InstagrAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            InstagrAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
                ) {
                    val navigationController = rememberNavController()
                    NavHost(
                        navController = navigationController,
                        startDestination = Routes.Login.route
                    ) {
                        composable(Routes.Login.route) { LoginScreen(LoginViewModel()) }
                        composable(Routes.Pantalla1.route) { ScreenOne(navigationController) }
                        composable(Routes.Pantalla2.route) { ScreenTwo(navigationController) }
                        composable(Routes.Pantalla3.route) { ScreenThree(navigationController) }
                        composable(
                            Routes.Pantalla4.route,
                            arguments = listOf(navArgument("age") { type = NavType.IntType })
                        ) { backStackEntry ->
                            ScreenFour(
                                navigationController, backStackEntry.arguments?.getInt("age") ?: 0
                            )
                        }
                        composable(
                            Routes.Pantalla5.route,
                            arguments = listOf(navArgument("name") { defaultValue = "NAO" })
                        ) { backStackEntry ->
                            ScreenFive(
                                navigationController, backStackEntry.arguments?.getString("name")
                            )
                        }
                    }
                }
            }
        }
    }
}