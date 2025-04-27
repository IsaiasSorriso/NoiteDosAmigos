    package com.example.noiteamigos
    

    import android.os.Bundle
    import androidx.activity.ComponentActivity
    import androidx.activity.compose.setContent
    import androidx.activity.enableEdgeToEdge
    import androidx.compose.foundation.Image
    import androidx.compose.foundation.background
    import androidx.compose.foundation.layout.Arrangement
    import androidx.compose.foundation.layout.Column
    import androidx.compose.foundation.layout.Row
    import androidx.compose.foundation.layout.Spacer
    import androidx.compose.foundation.layout.fillMaxSize
    import androidx.compose.foundation.layout.height
    import androidx.compose.foundation.layout.padding
    import androidx.compose.foundation.layout.width
    import androidx.compose.foundation.shape.RoundedCornerShape
    import androidx.compose.material3.Button
    import androidx.compose.material3.ButtonDefaults
    import androidx.compose.material3.MaterialTheme
    import androidx.compose.material3.Text
    import androidx.compose.material3.TextButton
    import androidx.compose.runtime.Composable
    import androidx.compose.runtime.getValue
    import androidx.compose.runtime.mutableStateOf
    import androidx.compose.runtime.remember
    import androidx.compose.runtime.setValue
    import androidx.compose.ui.Alignment
    import androidx.compose.ui.Modifier
    import androidx.compose.ui.graphics.Color
    import androidx.compose.ui.res.painterResource
    import androidx.compose.ui.tooling.preview.Preview
    import androidx.compose.ui.unit.dp
    import androidx.navigation.NavHostController
    import androidx.navigation.compose.NavHost
    import androidx.navigation.compose.composable
    import androidx.navigation.compose.rememberNavController
    import com.example.noiteamigos.ui.theme.NoiteAmigosTheme
    import kotlin.random.Random
    
    class MainActivity : ComponentActivity() {
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            enableEdgeToEdge()
            setContent {
                NoiteAmigosTheme {
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = "main"
                    ) {
                        composable("main") {
                            FilmeDaVezApp(navController)
                        }
                        composable("result/{filme}/{genero}") { backStackEntry ->
                            val filme = backStackEntry.arguments?.getString("filme")
                            val genero = backStackEntry.arguments?.getString("genero")
                            ResultScreen(navController, filme, genero)
                        }
                    }
                }
            }
        }

        @Preview(showBackground = true)
        @Composable
        fun FilmeDaVezPreview() {
            NoiteAmigosTheme {
                // Cria um NavController fake para a preview
                val navController = rememberNavController()
                FilmeDaVezApp(navController = navController)
            }
        }

        @Composable
        fun FilmeDaVezApp(navController: NavHostController) {
            // Listas de filmes por categoria
            val filmesAcao = listOf(
                "Velozes e Furiosos",
                "John Wick",
                "Missão Impossível",
                "O Exterminador do Futuro",
                "Matrix"
            )

            val filmesComedia = listOf(
                "As Branquelas",
                "Todo Mundo em Pânico",
                "Se Beber, Não Case",
                "Debi & Lóide",
                "Escola de Rock"
            )

            val filmesDrama = listOf(
                "Cidade de Deus",
                "O Poderoso Chefão",
                "Forrest Gump",
                "Clube da Luta",
                "O Resgate do Soldado Ryan"
            )

            val filmesTerror = listOf(
                "Cidade de Deus",
                "O Poderoso Chefão",
                "Forrest Gump",
                "Clube da Luta",
                "O Resgate do Soldado Ryan"
            )

            // Estado para armazenar o filme recomendado
            var filmeRecomendado by remember { mutableStateOf("") }

            // Estado para armazenar o gênero selecionado
            var generoSelecionado by remember { mutableStateOf("") }

            val todosFilmes = remember {
                filmesAcao + filmesComedia + filmesDrama
            }

            // Mostra a recomendação do filme

            Column(
                modifier = Modifier.run {
                    fillMaxSize()
                        .background(Color(0xFF121212))
                        .padding(16.dp)
                        .padding(top = 32.dp)
                },
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Image(
                    painter = painterResource(id = R.drawable.r),
                    contentDescription = "Logo do aplicativo",
                    modifier = Modifier
                        .height(100.dp)
                        .padding(bottom = 16.dp)
                )

                Text(
                    text = "RandomFlix",
                    style = MaterialTheme.typography.titleLarge
                        .copy(color = Color.White),
                )

                Spacer(modifier = Modifier.height(50.dp))

                // Mostra o filme recomendado
                Text(
                    color = Color.White,
                    text = "Vamos Ver um Filme Surpresa?",
                    style = MaterialTheme.typography.bodyLarge
                )

                Spacer(modifier = Modifier.height(30.dp))

                // Botões para escolher o gênero
                Row(
                    modifier = Modifier
                        .padding(horizontal = 8.dp)
                ) {
                    TextButton(
                        onClick = {
                            generoSelecionado = "Comédia"
                            filmeRecomendado = filmesComedia[Random.nextInt(filmesComedia.size)]
                        },
                        modifier = Modifier
                            .background(Color.Transparent),
                        shape = RoundedCornerShape(9.dp),

                        ) {
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center,
                            modifier = Modifier
                                .background(Color(0xFF1F1F1F), shape = RoundedCornerShape(9.dp))
                                .padding(8.dp)
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.img),
                                contentDescription = "Logo do aplicativo",
                                modifier = Modifier
                                    .height(100.dp)
                                    .width(100.dp)
                            )

                            Spacer(modifier = Modifier.width(8.dp))

                            Text(
                                text = "Comédia",
                                style = MaterialTheme.typography.titleMedium
                                    .copy(color = Color.White),
                            )
                        }
                    }

                    Spacer(modifier = Modifier.width(10.dp))

                    TextButton(
                        onClick = {
                            generoSelecionado = "Drama"
                            filmeRecomendado = filmesDrama[Random.nextInt(filmesDrama.size)]
                        },
                        modifier = Modifier
                            .background(Color.Transparent),
                        shape = RoundedCornerShape(9.dp),
                    ) {
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center,
                            modifier = Modifier
                                .background(Color(0xFF1F1F1F), shape = RoundedCornerShape(9.dp))
                                .padding(8.dp)
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.img_2),
                                contentDescription = "Logo do aplicativo",
                                modifier = Modifier
                                    .height(100.dp)
                                    .width(100.dp)
                            )

                            Spacer(modifier = Modifier.width(8.dp))

                            Text(
                                text = "Drama",
                                style = MaterialTheme.typography.titleMedium
                                    .copy(color = Color.White),
                            )
                        }
                    }
                }

                Spacer(modifier = Modifier.height(15.dp))

                Row(
                    modifier = Modifier
                        .padding(horizontal = 8.dp)
                ) {
                    TextButton(
                        onClick = {
                            generoSelecionado = "Ação"
                            filmeRecomendado = filmesAcao[Random.nextInt(filmesComedia.size)]
                        },
                        modifier = Modifier
                            .background(Color.Transparent),
                        shape = RoundedCornerShape(9.dp),

                        ) {
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center,
                            modifier = Modifier
                                .background(Color(0xFF1F1F1F), shape = RoundedCornerShape(9.dp))
                                .padding(8.dp)
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.img_1),
                                contentDescription = "Logo do aplicativo",
                                modifier = Modifier
                                    .height(100.dp)
                                    .width(100.dp)
                            )

                            Spacer(modifier = Modifier.width(8.dp))

                            Text(
                                text = "Ação",
                                style = MaterialTheme.typography.titleMedium
                                    .copy(color = Color.White),
                            )
                        }
                    }

                    Spacer(modifier = Modifier.width(10.dp))

                    TextButton(
                        onClick = {
                            generoSelecionado = "Terror"
                            filmeRecomendado = filmesTerror[Random.nextInt(filmesDrama.size)]
                        },
                        modifier = Modifier
                            .background(Color.Transparent),
                        shape = RoundedCornerShape(9.dp),
                    ) {
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center,
                            modifier = Modifier
                                .background(Color(0xFF1F1F1F), shape = RoundedCornerShape(9.dp))
                                .padding(8.dp)
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.img_3),
                                contentDescription = "Logo do aplicativo",
                                modifier = Modifier
                                    .height(100.dp)
                                    .width(100.dp)
                            )

                            Spacer(modifier = Modifier.width(8.dp))

                            Text(
                                text = "Terror",
                                style = MaterialTheme.typography.titleMedium
                                    .copy(color = Color.White),
                            )
                        }
                    }
                }

                Spacer(modifier = Modifier.height(24.dp))

                // Mostra o gênero selecionado
                if (generoSelecionado.isNotEmpty()) {
                    Text(
                        color = Color.White,
                        text = "Gênero: $generoSelecionado",
                        style = MaterialTheme.typography.titleMedium
                    )
                }

                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    color = Color.White,
                    text = filmeRecomendado,
                    style = MaterialTheme.typography.bodyLarge
                )

                Spacer(modifier = Modifier.height(30.dp))
                // Botão para gerar uma nova recomendação
                Button(
                    onClick = {
                        filmeRecomendado = todosFilmes[Random.nextInt(todosFilmes.size)]
                        generoSelecionado = when {
                            filmesAcao.contains(filmeRecomendado) -> "Ação"
                            filmesComedia.contains(filmeRecomendado) -> "Comédia"
                            filmesDrama.contains(filmeRecomendado) -> "Drama"
                            else -> "Aleatório"
                        }
                    },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF1F1F1F),
                        contentColor = Color.White
                    ),
                    shape = RoundedCornerShape(9.dp),
                    modifier = Modifier.padding(8.dp)
                ) {
                    Text("Aleatório")
                }
            }
        }
    }




