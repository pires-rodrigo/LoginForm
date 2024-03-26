package com.example.loginform

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.loginform.ui.theme.LoginFormTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LoginFormTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Forms(this)
                }
            }
        }
    }
}

@Composable
fun Forms(context: Context) {
    var usuario = remember {
        mutableStateOf(value = "")
    }
    var senha = remember {
        mutableStateOf(value = "")
    }
    var stringPassword = remember {
        mutableStateOf(false)
    }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(32.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.azedou),
            contentDescription = "Azedou",
            modifier = Modifier
                .size(360.dp)
                .fillMaxWidth()
        )
        Text(
            text = "Usuário",
            textAlign = TextAlign.Center,
            fontSize = 24.sp,
            modifier = Modifier
                .padding(bottom = 8.dp)
        )
        OutlinedTextField(
            value = usuario.value,
            onValueChange = { usuario.value = it },
            label = {
                Text(
                    text = "Usuário", fontSize = 24.sp, modifier = Modifier.padding(bottom = 12.dp)
                )
            }, modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp),
        )

        Text(
            text = "Senha",
            textAlign = TextAlign.Center,
            fontSize = 24.sp,
            modifier = Modifier
                .padding(bottom = 8.dp)
        )

        OutlinedTextField(
            value = senha.value,
            onValueChange = { senha.value = it },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp),
            label = {
                Text(text = "Senha", fontSize = 24.sp, modifier = Modifier.padding(bottom = 12.dp))
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Password
            ),
            visualTransformation =
            if (stringPassword.value)
                VisualTransformation.None
            else
                PasswordVisualTransformation(),
            trailingIcon = {
                IconButton(
                    onClick = {
                        stringPassword.value = !stringPassword.value
                    }
                ) {
                    if (stringPassword.value)
                        Icon(
                            painterResource(id = R.drawable.visibility), ""
                        )
                    else
                        Icon(
                            painterResource(id = R.drawable.visibility_off), ""
                        )
                }
            }
        )

        Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
            Button(
                onClick = {
                    if (usuario.value == "admin" && senha.value == "admin123") {
                        val intent = Intent(context, HomePage::class.java)
                        intent.putExtra("username", usuario.value)
                        context.startActivity(intent)
                    } else {
                        context.toast("Usuário ou senha incorreto")
                    }
                }, colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.secondary, contentColor = Color.White
                ), modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 20.dp)
            ) {
                Text(
                    text = "Entrar",
                    fontSize = 18.sp
                )
            }
        }

        Text(
            text = "Novo usuário | Esqueci minha senha",
            textAlign = TextAlign.Center,
            fontSize = 16.sp,
            modifier = Modifier
                .background(Color.White)
                .fillMaxWidth()
        )
    }
}

fun Context.toast(message: CharSequence) =
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    LoginFormTheme {
        Greeting("Android")
    }
}