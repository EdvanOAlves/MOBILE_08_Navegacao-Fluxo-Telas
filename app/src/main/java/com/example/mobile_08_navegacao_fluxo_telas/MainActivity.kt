package com.example.mobile_08_navegacao_fluxo_telas

import android.R.attr.defaultValue
import android.R.attr.name
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
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
                        startDestination = "login",
//                        exitTransition = {  //transição de slide pra esquerda, vai aplicar pra todas as telas
//                            slideOutOfContainer(
//                                towards = AnimatedContentTransitionScope.SlideDirection.Left,
//                                animationSpec = tween(1500)
//                            )
//                        }
                        //Gostei do quão caótico ficou esse:
                        exitTransition = {
                            slideOutOfContainer(
                                AnimatedContentTransitionScope.SlideDirection.Right,
                                animationSpec = tween(1000)
                            ) + fadeOut(animationSpec = tween(800))
                        },
                        enterTransition = {
                            slideIntoContainer(
                                AnimatedContentTransitionScope.SlideDirection.Left,
                                animationSpec = tween(1500)
                            )
                        }
                    ) {
                        composable(
                            route = "login",
                            //Exemplo de overflow da transição de saida
                            exitTransition = {
                                slideOutOfContainer(
                                    AnimatedContentTransitionScope.SlideDirection.Right,
                                    animationSpec = tween(1000)
                                ) + fadeOut(animationSpec = tween(800))
                            }
                        ) { LoginScreen(navController = navController) }
                        composable(route = "menu") { MenuScreen(navController = navController) }

                        composable(
                            route = "profile/{name}/{age}",
                            arguments = listOf(
                                navArgument("name") {
                                    type = NavType.StringType
                                },
                                navArgument("age") {
                                    type = NavType.IntType
                                }
                            )
                        ) { navBackStackEntry ->
                            val nome = navBackStackEntry.arguments?.getString("name")
                            val age = navBackStackEntry.arguments?.getInt("age")
                            //Declarando campos a receber na query

                            ProfileScreen(
                                navController = navController,
                                name = nome!!,
                                age = age!!
                            )
                        }
                        composable(
                            //Montando a query na rota
                            route = "orders?orderMessage={orderMessage}",
                            arguments = listOf(
                                navArgument("orderMessage") {
                                    defaultValue = "Sem pedidos"
                                }
                            )
                        ) {
                            val orderMessage = it
                                .arguments?.getString("orderMessage")
                            OrdersScreen(
                                navController = navController,
                                orderMessage = orderMessage!!
                            )
                        }

                    }
                }
            }
        }
    }
}

