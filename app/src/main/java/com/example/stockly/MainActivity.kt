package com.example.stockly

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.stockly.ui.screens.HomeScreen
import com.example.stockly.ui.screens.LoginScreen
import com.example.stockly.WelcomeScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()

            MaterialTheme {
                NavHost(
                    navController = navController,
                    startDestination = "welcome"
                ){
                    composable("welcome"){
                    WelcomeScreen(
                        onLoginClick = {navController.navigate("login")},
                        onRegisterClick = {/* futura tela de registro*/}
                        )
                    }
                    composable("login") {
                        LoginScreen(
                            onLogin = { navController.navigate("home") },
                            onRegisterClick = { /* futura tela de registro */ },
                            onForgotPasswordClick = { /* futura tela de recuperação */ }
                        )
                    }
                    composable("home") {
                        HomeScreen(
                            onProdutosClick = { /* futura tela de produtos */ },
                            onEstoqueClick = { /* futura tela de estoque */ },
                            onConfigClick = { /* futura tela de config */ }
                        )
                    }
                }
            }
        }
    }
}
