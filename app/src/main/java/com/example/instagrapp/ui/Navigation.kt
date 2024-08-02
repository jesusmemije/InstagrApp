package com.example.instagrapp.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.instagrapp.model.Routes

@Composable
fun ScreenOne(navigationController: NavHostController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Red)
    ) {
        Text(
            text = "Screen One",
            modifier = Modifier
                .align(Alignment.Center)
                .clickable {
                    navigationController.navigate(
                        Routes.Pantalla2.route
                    )
                },
            fontWeight = FontWeight.Bold,
            color = Color.White,
            fontSize = 16.sp,
        )
    }
}

@Composable
fun ScreenTwo(navigationController: NavHostController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
    ) {
        Text(
            text = "Screen Two",
            modifier = Modifier
                .align(Alignment.Center)
                .clickable { navigationController.navigate(Routes.Pantalla3.route) },
            fontWeight = FontWeight.Bold,
            color = Color.White,
            fontSize = 16.sp
        )
    }
}

@Composable
fun ScreenThree(navigationController: NavHostController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Magenta)
    ) {
        Text(
            text = "Screen Three",
            modifier = Modifier
                .align(Alignment.Center)
                .clickable { navigationController.navigate(Routes.Pantalla4.createRoute(40)) },
            fontWeight = FontWeight.Bold,
            color = Color.White,
            fontSize = 16.sp
        )
    }
}

@Composable
fun ScreenFour(navigationController: NavHostController, age: Int) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Green)
    ) {
        Text(
            text = "¡Tengo $age años!",
            modifier = Modifier
                .align(Alignment.Center)
                .clickable { navigationController.navigate(Routes.Pantalla5.createRoute("SAM")) },
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp
        )
    }
}

@Composable
fun ScreenFive(navigationController: NavHostController, name: String?) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Blue)
    ) {
        Text(
            text = "¡Me llamo $name!",
            modifier = Modifier
                .align(Alignment.Center)
                .clickable { navigationController.navigate(Routes.Pantalla1.route) },
            fontWeight = FontWeight.Bold,
            color = Color.White,
            fontSize = 16.sp
        )
    }
}