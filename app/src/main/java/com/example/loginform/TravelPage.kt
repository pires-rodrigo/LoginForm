package com.example.loginform

import android.os.Build
import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.loginform.modelo.TipoViagem
import com.example.loginform.modelo.Viagem
import java.time.LocalDate

@Composable
fun TravelPage(navController: NavController) {
    ViagemList()
}

@Composable
fun Dest(){

}

@Composable
fun ViagemList(){
    val list = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
        listOf(
            Viagem(1, "França", TipoViagem.Lazer, 8000f, LocalDate.of(2024, 8, 1), LocalDate.of(2024, 8, 31)),
            Viagem(2, "Portugal", TipoViagem.Negocio, 5000f, LocalDate.of(2024, 9, 21), LocalDate.of(2024, 10, 21)),
            Viagem(3, "Gramado", TipoViagem.Negocio, 10000f, LocalDate.of(2024, 6, 10), LocalDate.of(2024, 6, 20))
        )
    }
    else {
        TODO("TESTE VERSION")
    }

    val navController = rememberNavController()
    val ctx = LocalContext.current
    Scaffold(
        floatingActionButton = {
            FloatingActionButton(onClick = { navController.navigate("CadViagens") }){
                Icon(imageVector = Icons.Default.Add, contentDescription = "")

            }
        }
    ) {
        Column(modifier = Modifier.padding(it)) {
            NavHost(navController = navController,
                    startDestination = "dest")
            {
                composable("cadViagens") {
                    //CadViagens(onBack = {navController.navigateUp()})
                }
                composable("Dest") {
                    Dest()
                }
            }
            LazyColumn(){
                items(items = list){
                    ViagemCard(it)
                }
            }
        }
    }

}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ViagemCard(v: Viagem){
    Card(elevation = CardDefaults.cardElevation(hoveredElevation = 18.dp),
         border = BorderStroke(1.dp, Color.Gray),
         modifier = Modifier
             .padding(2.dp)
             .fillMaxSize()
             .combinedClickable(
                 onClick = {}
             )
    ) {
        Row(modifier = Modifier.padding(4.dp)) {
            if  (v.tipo == TipoViagem.Lazer) {
                Image(imageVector = Icons.Default.AccountBox, contentDescription = "")
            }
            else{
                Image(imageVector = Icons.Default.Star, contentDescription = "")
            }

            Column(modifier = Modifier.padding(4.dp)) {
                Text(text = "Destino: ${v.destino}", fontSize = 20.sp)

                Row() {
                    Text(text = "Data Início : ${v.dtInicio}")
                    Text(text = "Data Fim : ${v.dtFim}")
                }

                Text(text = "Orçamento: R$${v.orcamento}")
            }
        }
    }
}

