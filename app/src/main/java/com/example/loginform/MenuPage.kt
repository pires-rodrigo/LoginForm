package com.example.loginform

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBarDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun Usuario(navController: NavController) {
    NavigationBarExample()
}

@Composable
fun NavigationBarExample() {
    val navController = rememberNavController()
    Scaffold(
        bottomBar = { BottomNavigationBar(navController) }
    ) { innerPadding ->
        NavHost(
            navController,
            startDestination = "home",
            modifier = Modifier.padding(innerPadding)
        ) {
            composable("home") { HomePage(navController = navController) }
            composable("travel") { TravelPage(navController = navController) }
            composable("about") { AboutPage(navController = navController) }
        }
    }
}

@Composable
fun BottomNavigationBar(navController: NavController) {
    BottomAppBar(
        modifier = Modifier,
        containerColor = MaterialTheme.colorScheme.primary,
        contentColor = MaterialTheme.colorScheme.onPrimary,
        tonalElevation = 8.dp,
        windowInsets = NavigationBarDefaults.windowInsets,
    ) {
        var selectedItem by remember { mutableStateOf(0) }

        BottomNavigationItem(
            selected = selectedItem == 0,
            onClick = {
                selectedItem = 0
                navController.navigate("home")
            },
            icon = { Icon(Icons.Filled.Home, contentDescription = "Home") },
            label = { Text("Home") }
        )

        BottomNavigationItem(
            selected = selectedItem == 1,
            onClick = {
                selectedItem = 1
                navController.navigate("travel")
            },
            icon = { Icon(Icons.Filled.LocationOn, contentDescription = "Viagem") },
            label = { Text("Viagem") }
        )

        BottomNavigationItem(
            selected = selectedItem == 2,
            onClick = {
                selectedItem = 2
                navController.navigate("about")
            },
            icon = { Icon(Icons.Filled.Info, contentDescription = "Sobre") },
            label = { Text("Sobre") }
        )
    }
}
