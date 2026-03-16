package com.example.mobile_08_navegacao_fluxo_telas

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.mobile_08_navegacao_fluxo_telas.screens.LoginScreen
import com.example.mobile_08_navegacao_fluxo_telas.screens.MenuScreen
import com.example.mobile_08_navegacao_fluxo_telas.screens.OrdersScreen
import com.example.mobile_08_navegacao_fluxo_telas.screens.ProfileScreen
import com.example.mobile_08_navegacao_fluxo_telas.ui.theme.MOBILE_08_Navegacao_FluxotelasTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MOBILE_08_Navegacao_FluxotelasTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    val navController = rememberNavController()

                    NavHost(
                        navController = navController,
                        startDestination = "login"
                    ){
                        composable(route =  "login") {LoginScreen()}
                        composable(route =  "menu") {MenuScreen()}
                        composable(route =  "perfil") {ProfileScreen()}
                        composable(route =  "pedidos") { OrdersScreen() }

                    }

                    ProfileScreen()
                }
            }
        }
    }
}

