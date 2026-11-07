package com.example.bwarts

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.example.bwarts.ui.components.DrawerContent
import com.example.bwarts.ui.components.FooterSection
import com.example.bwarts.ui.components.HeaderBar
import com.example.bwarts.ui.components.PersonalizationBanner
import com.example.bwarts.ui.components.Product
import com.example.bwarts.ui.components.ProductSection
import com.example.bwarts.ui.components.PromoCarousel
import com.example.bwarts.ui.theme.BwartsDarkBg
import com.example.bwarts.ui.theme.BwartsTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BwartsTheme {
                HomeScreen()
            }
        }
    }
}

@Composable
fun HomeScreen() {
    val context = LocalContext.current
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()
    val snackbarHostState = remember { SnackbarHostState() }

    // Sample data for the product sections
    val ultimasNovidades = remember {
        listOf(
            Product(id = "1", title = "Produto legal de MDF de 3mmx9mm", price = "R$999,99", installments = "Em 3x sem juros"),
            Product(id = "2", title = "Placa MDF Crua 3mm para Artesanato", price = "R$49,90", installments = "Em 2x sem juros"),
            Product(id = "3", title = "Painel Ripado de MDF Amadeirado", price = "R$189,00", installments = "Em 4x sem juros"),
            Product(id = "4", title = "Caixa Organizadora MDF Personalizada", price = "R$79,90", installments = "Em 3x sem juros")
        )
    }

    val baseadoEmPesquisas = remember {
        listOf(
            Product(id = "5", title = "Produto legal de MDF de 3mmx9mm", price = "R$999,99", installments = "Em 3x sem juros"),
            Product(id = "6", title = "Chapa de MDF 6mm 100x60cm Premium", price = "R$129,90", installments = "Em 3x sem juros"),
            Product(id = "7", title = "Kit Mandalas Decorativas em MDF 3mm", price = "R$89,90", installments = "Em 3x sem juros"),
            Product(id = "8", title = "Escultura de Parede Geométrica MDF", price = "R$159,00", installments = "Em 5x sem juros")
        )
    }

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            DrawerContent(
                onItemSelect = { item ->
                    scope.launch {
                        drawerState.close()
                    }
                    Toast.makeText(context, "Navegando para: $item", Toast.LENGTH_SHORT).show()
                }
            )
        }
    ) {
        Scaffold(
            modifier = Modifier.statusBarsPadding(),
            containerColor = BwartsDarkBg,
            snackbarHost = { SnackbarHost(snackbarHostState) },
            topBar = {
                HeaderBar(
                    cartItemCount = 3,
                    onMenuClick = {
                        scope.launch {
                            drawerState.open()
                        }
                    },
                    onSearchClick = {
                        Toast.makeText(context, "Abrir busca de produtos", Toast.LENGTH_SHORT).show()
                    },
                    onCartClick = {
                        Toast.makeText(context, "Abrir carrinho (3 itens)", Toast.LENGTH_SHORT).show()
                    }
                )
            }
        ) { innerPadding ->
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
                    .background(BwartsDarkBg)
            ) {
                // 1. Promo Carousel Section
                item {
                    PromoCarousel()
                }

                // 2. "Últimas novidades" Horizontal Section
                item {
                    ProductSection(
                        title = "Últimas novidades",
                        products = ultimasNovidades,
                        onProductClick = { product ->
                            Toast.makeText(context, "Clicou em: ${product.title}", Toast.LENGTH_SHORT).show()
                        }
                    )
                }

                // 3. "Baseado em suas pesquisas" Horizontal Section
                item {
                    ProductSection(
                        title = "Baseado em suas pesquisas",
                        products = baseadoEmPesquisas,
                        onProductClick = { product ->
                            Toast.makeText(context, "Clicou em: ${product.title}", Toast.LENGTH_SHORT).show()
                        }
                    )
                }

                // 4. Fixed Personalization Banner Section
                item {
                    PersonalizationBanner(
                        onBannerClick = {
                            Toast.makeText(context, "Abrindo personalização de produtos!", Toast.LENGTH_SHORT).show()
                        }
                    )
                }

                // 5. Footer Section
                item {
                    FooterSection(
                        onLinkClick = { link ->
                            Toast.makeText(context, "Acessando: $link", Toast.LENGTH_SHORT).show()
                        }
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    BwartsTheme {
        HomeScreen()
    }
}
