package com.example.loginform

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import com.example.loginform.ui.theme.LoginFormTheme
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.ui.*
import androidx.compose.ui.unit.*

class HomePage : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LoginFormTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Usuario()
                }
            }
        }
    }
}

@Composable
fun Usuario() {
    Column(modifier = Modifier.padding(16.dp)) {
        Text(
            text = "Bem vindo!",
            fontSize = 32.sp,
        )
        Text(
            text = "Usuário: Guilherme Miranda",
            fontSize = 22.sp,
        )
    }
}