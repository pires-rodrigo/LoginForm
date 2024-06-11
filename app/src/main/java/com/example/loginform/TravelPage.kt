package com.example.loginform

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.OutlinedTextField

import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun TravelPage(navController: NavController) {
    var selectedTravelType by remember { mutableStateOf("Lazer") }
    val travelTypes = listOf("Lazer", "Trabalho")
    val imageResource = when (selectedTravelType) {
        "Lazer" -> R.drawable.lazer
        "Trabalho" -> R.drawable.trabalho
        else -> R.drawable.lazer
    }
    var expanded by remember { mutableStateOf(false) }

    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            Image(
                painter = painterResource(id = imageResource),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .padding(top = 16.dp, start = 16.dp)
                    .size(100.dp)
                    .clip(CircleShape)
            )
            Spacer(modifier = Modifier.height(10.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text("Selecione o tipo:", fontSize = 18.sp)
                Box {
                    TextButton(onClick = { expanded = true }) {
                        Text(selectedTravelType)
                    }
                    DropdownMenu(
                        expanded = expanded,
                        onDismissRequest = { expanded = false }
                    ) {
                        travelTypes.forEach { travelType ->
                            DropdownMenuItem(
                                text = { Text(travelType) },
                                onClick = {
                                    selectedTravelType = travelType
                                    expanded = false
                                }
                            )
                        }
                    }
                }
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text("Selecione o destino:", fontSize = 18.sp)
                OutlinedTextField(
                    value = "",
                    onValueChange = {},
                    label = { Text("Destino", fontSize = 12.sp) },
                    modifier = Modifier.padding(start = 24.dp, end = 12.dp)
                )
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text("Selecione o orçamento:", fontSize = 18.sp)
                OutlinedTextField(
                    value = "",
                    onValueChange = {},
                    label = { Text("Orçamento", fontSize = 12.sp) },
                    modifier = Modifier.padding(start = 24.dp, end = 12.dp)
                )
            }
        }
    }
}
