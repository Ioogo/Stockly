package com.example.stockly

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

@Composable
fun WelcomeScreen(
    onLoginClick: () -> Unit = {},
    onRegisterClick: () -> Unit = {}
) {
    val AzulStockly = Color(0xFF607FF2)

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(24.dp)
        ) {
            // Logo
            // Troque pelo seu recurso real: R.drawable.logo_stockly
            Image(
                painter = painterResource(id = R.drawable.ic_launcher_foreground),
                contentDescription = "Logo Stockly",
                modifier = Modifier.size(120.dp)
            )

            // Título com destaque na cor
            Text(
                text = buildAnnotatedString {
                    append("Bem-vindo a ")
                    withStyle(style = SpanStyle(color = AzulStockly, fontWeight = FontWeight.Bold)) {
                        append("Stockly")
                    }
                },
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold
            )

            // Subtítulo
            Text(
                text = "A organização na palma da mão",
                style = MaterialTheme.typography.bodyMedium
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Botão Entrar
            Button(
                onClick = onLoginClick,
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(containerColor = AzulStockly)
            ) {
                Text("Entrar", color = Color.White)
            }

            // Botão Criar Conta
            Button(
                onClick = onRegisterClick,
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(containerColor = AzulStockly)
            ) {
                Text("Criar conta", color = Color.White)
            }
        }
    }
}
