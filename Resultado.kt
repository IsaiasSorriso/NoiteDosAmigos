package com.example.noiteamigos

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun ResultScreen(
    navController: NavController,
    filme: String?,
    genero: String?
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF121212))
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Recomendação do Dia",
            style = MaterialTheme.typography.headlineMedium,
            color = Color.White
        )

        Spacer(modifier = Modifier.height(32.dp))

        Text(
            text = genero ?: "Gênero não selecionado",
            style = MaterialTheme.typography.titleLarge,
            color = Color(0xFFBB86FC)
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = filme ?: "Nenhum filme selecionado",
            style = MaterialTheme.typography.displaySmall,
            color = Color.White,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(horizontal = 16.dp)
        )

        Spacer(modifier = Modifier.height(48.dp))

        Button(
            onClick = { navController.popBackStack() },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFFBB86FC)
            ),
            modifier = Modifier.width(200.dp)
        ) {
            Text("Voltar")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ResultScreenPreview() {
    com.example.noiteamigos.ui.theme.NoiteAmigosTheme {
        ResultScreen(
            navController = androidx.navigation.compose.rememberNavController(),
            filme = "Matrix",
            genero = "Ação"
        )
    }
}