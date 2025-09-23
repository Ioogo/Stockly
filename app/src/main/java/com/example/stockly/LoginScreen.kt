package com.example.stockly.ui.screens

import android.R
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.firebase.auth.FirebaseAuth

@Composable
fun LoginScreen(
    onLogin: (String) -> Unit,
    onRegisterClick: () -> Unit,
    onForgotPasswordClick: () -> Unit
) {
    var email by remember { mutableStateOf("") }
    var senha by remember { mutableStateOf("") }
    var errorMessage by remember {mutableStateOf<String?>(null)}
    var isLoading by remember { mutableStateOf(false) }
    val auth = remember { FirebaseAuth.getInstance() }

    val AzulStockly = Color(0xFF607FF2)
    val LaranjaStockly = Color(0xFFFD830D)

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            // Título
            Text(
                text = "Bem-Vindo de volta!",
                color = AzulStockly,
                style = MaterialTheme.typography.headlineMedium
            )

            // Campo email
            OutlinedTextField(
                value = email,
                onValueChange = { email = it },
                label = { Text("E-mail") },
                singleLine = true,
                modifier = Modifier.fillMaxWidth(),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
            )

            // Campo senha
            OutlinedTextField(
                value = senha,
                onValueChange = { senha = it },
                label = { Text("Senha") },
                singleLine = true,
                modifier = Modifier.fillMaxWidth(),
                visualTransformation = PasswordVisualTransformation()
            )

            // Esqueceu a senha
            Text(
                text = "Esqueceu a senha?",
                color = LaranjaStockly,
                modifier = Modifier
                    .align(Alignment.End)
                    .clickable { onForgotPasswordClick() }
            )

            // Botão login
            Button(
                onClick = {
                    isLoading = true
                    errorMessage = null
                    auth.signInWithEmailAndPassword(email, senha)
                        .addOnCompleteListener { task ->
                            if (task.isSuccessful){
                                onLogin(task.result?.user?.uid ?: email)
                            } else{
                                errorMessage = task.exception?.localizedMessage
                            }
                        }
                },
                colors = ButtonDefaults.buttonColors(containerColor = AzulStockly),
                modifier = Modifier.fillMaxWidth()
            ) {
                if (isLoading){
                    Text("Entrar", fontSize = 16.sp, color = Color.White)
                    CircularProgressIndicator(
                        color = AzulStockly,
                        strokeWidth = 2.dp,
                        modifier = Modifier.size(24.dp)
                    )
                } else{
                    Text("Entrar", fontSize = 16.sp, color = Color.White)
                }
            }
                errorMessage?.let {
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(it, color = LaranjaStockly, fontSize = 14.sp)
                }
            // Botão registrar
            Button(
                onClick = onRegisterClick,
                colors = ButtonDefaults.buttonColors(containerColor = LaranjaStockly),
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(text = "Cadastrar", color = Color.White)
            }
        }
    }
}
