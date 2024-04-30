package com.example.loginform

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "login") {
        composable("login") { Forms(context = LocalContext.current, navController = navController) }
        composable("register") { Register(navController = navController) }
        composable("menu") { Usuario(navController = navController) }
    }
}