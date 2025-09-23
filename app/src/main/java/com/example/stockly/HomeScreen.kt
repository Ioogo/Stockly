package com.example.stockly.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    onProdutosClick: () -> Unit = {},
    onEstoqueClick: () -> Unit = {},
    onConfigClick: () -> Unit = {}
) {
    val AzulStockly = Color(0xFF607FF2)

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Stockly", color = Color.White) },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = AzulStockly)
            )
        }
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(16.dp),
            contentAlignment = Alignment.TopCenter
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                Text(
                    text = "Bem-vindo ao Stockly!",
                    style = MaterialTheme.typography.headlineSmall
                )

                Button(
                    onClick = onProdutosClick,
                    modifier = Modifier.fillMaxWidth(),
                    colors = ButtonDefaults.buttonColors(containerColor = AzulStockly)
                ) {
                    Text("Produtos", color = Color.White)
                }

                Button(
                    onClick = onEstoqueClick,
                    modifier = Modifier.fillMaxWidth(),
                    colors = ButtonDefaults.buttonColors(containerColor = AzulStockly)
                ) {
                    Text("Estoque", color = Color.White)
                }

                Button(
                    onClick = onConfigClick,
                    modifier = Modifier.fillMaxWidth(),
                    colors = ButtonDefaults.buttonColors(containerColor = AzulStockly)
                ) {
                    Text("Configurações", color = Color.White)
                }
            }
        }
    }
}
