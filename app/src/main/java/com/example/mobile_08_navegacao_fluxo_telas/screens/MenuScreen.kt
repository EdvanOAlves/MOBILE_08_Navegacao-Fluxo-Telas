package com.example.mobile_08_navegacao_fluxo_telas.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun MenuScreen(modifier: Modifier = Modifier, navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF2C4EC7))
            .padding(32.dp),

        ) {
        Text(
            text = "Menu",
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp,
            color = Color.White
        )

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.Center)
                .padding(32.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Button(
                // o Maria vai ser o campo nome especificado na rota pelo main activity
                onClick = {navController.navigate("profile/Maria/23")},
                colors = ButtonDefaults.buttonColors(
                    Color.White
                ),
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = "PERFIL",
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                    color = Color.Blue
                )
            }

            Button(
                onClick = {navController.navigate("orders?orderCount=1234")},
                colors = ButtonDefaults.buttonColors(
                    Color.White
                ),
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = "PEDIDOS",
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                    color = Color.Blue
                )
            }
            Button(
                onClick = {navController.popBackStack()},
                colors = ButtonDefaults.buttonColors(
                    Color.White
                ),
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = "SAIR",
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                    color = Color.Blue
                )
            }

        }
    }
}