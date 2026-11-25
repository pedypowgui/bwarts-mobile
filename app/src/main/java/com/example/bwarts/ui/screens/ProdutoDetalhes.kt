package com.example.bwarts.ui.screens

import android.widget.Toast
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Remove
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bwarts.R
import com.example.bwarts.ui.components.FooterSection
import com.example.bwarts.ui.components.HeaderBar
import com.example.bwarts.ui.components.Product
import com.example.bwarts.ui.components.ProdutoSecao
import com.example.bwarts.ui.theme.BwartsCardBg
import com.example.bwarts.ui.theme.BwartsDarkBg
import com.example.bwarts.ui.theme.BwartsOrange
import com.example.bwarts.ui.theme.BwartsTextGray
import com.example.bwarts.ui.theme.BwartsYellow

@Composable
fun ProdutoDetalhes(
    product: Product,
    onBack: () -> Unit = {},
    onProductClick: (Product) -> Unit = {},
    onMenuClick: () -> Unit = {},
    onSearchClick: () -> Unit = {},
    onCartClick: () -> Unit = {}
) {
    val contexto = LocalContext.current
    BackHandler { onBack() }

    var indexImagemSelecionada by remember { mutableIntStateOf(0) }
    var especificacaoProduto by remember { mutableStateOf(product.units.firstOrNull() ?: "3mm") }
    var unidadesProduto by remember { mutableIntStateOf(1) }
    var abaSelecionada by remember { mutableIntStateOf(0) } // 0 = Descrição, 1 = Avaliações

    val recomendacoes = remember {
        listOf(
            Product(id = "r1", title = "Produto legal de MDF de 3mmx9mm", price = "R$999,99", installments = "Em 3x sem juros"),
            Product(id = "r2", title = "Produto legal de MDF de 3mmx9mm", price = "R$999,99", installments = "Em 3x sem juros"),
            Product(id = "r3", title = "Produto legal de MDF de 3mmx9mm", price = "R$999,99", installments = "Em 3x sem juros")
        )
    }

    val baseadoEmPesquisas = remember {
        listOf(
            Product(id = "b1", title = "Produto legal de MDF de 3mmx9mm", price = "R$999,99", installments = "Em 3x sem juros"),
            Product(id = "b2", title = "Produto legal de MDF de 3mmx9mm", price = "R$999,99", installments = "Em 3x sem juros"),
            Product(id = "b3", title = "Produto legal de MDF de 3mmx9mm", price = "R$999,99", installments = "Em 3x sem juros")
        )
    }

    Scaffold(
        modifier = Modifier.statusBarsPadding(),
        containerColor = BwartsDarkBg,
        topBar = {
            HeaderBar(
                cartItemCount = 3,
                onMenuClick = onMenuClick,
                onSearchClick = onSearchClick,
                onCartClick = onCartClick,
                onLogoClick = onBack
            )
        }
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .background(BwartsDarkBg)
        ) {
            item {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp)
                ) {
                    Spacer(modifier = Modifier.height(12.dp))

                // Imagem principal do produto
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(300.dp),
                    shape = RoundedCornerShape(12.dp),
                    colors = CardDefaults.cardColors(containerColor = Color(0xFFF4F7F9))
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(16.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.produto),
                            contentDescription = product.title,
                            contentScale = ContentScale.Fit,
                            modifier = Modifier.fillMaxSize()
                        )
                    }
                }

                Spacer(modifier = Modifier.height(12.dp))

                // Miniaturas das imagens
                Row(
                    horizontalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    repeat(3) { index ->
                        Box(
                            modifier = Modifier
                                .size(64.dp)
                                .clip(RoundedCornerShape(8.dp))
                                .background(Color(0xFFF4F7F9))
                                .border(
                                    border = if (indexImagemSelecionada == index) BorderStroke(2.dp, BwartsOrange) else BorderStroke(0.dp, Color.Transparent),
                                    shape = RoundedCornerShape(8.dp)
                                )
                                .clickable { indexImagemSelecionada = index }
                                .padding(4.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.produto),
                                contentDescription = "Miniatura ${index + 1}",
                                contentScale = ContentScale.Fit,
                                modifier = Modifier.fillMaxSize()
                            )
                        }
                    }
                }

                Spacer(modifier = Modifier.height(16.dp))

                // Título do Produto
                Text(
                    text = product.title,
                    color = Color.White,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    lineHeight = 22.sp
                )

                Spacer(modifier = Modifier.height(6.dp))

                // Avaliações
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(2.dp)
                ) {
                    repeat(5) {
                        Icon(
                            imageVector = Icons.Default.Star,
                            contentDescription = null,
                            tint = BwartsYellow,
                            modifier = Modifier.size(16.dp)
                        )
                    }
                    Spacer(modifier = Modifier.width(6.dp))
                    Text(
                        text = "${product.rating} (${product.reviewCount})",
                        color = BwartsTextGray,
                        fontSize = 13.sp
                    )
                }

                Spacer(modifier = Modifier.height(16.dp))

                // Preço
                Text(
                    text = product.price,
                    color = Color.White,
                    fontSize = 32.sp,
                    fontWeight = FontWeight.Bold
                )

                // Parcelamento
                Text(
                    text = product.installments,
                    color = BwartsTextGray,
                    fontSize = 12.sp
                )

                Spacer(modifier = Modifier.height(16.dp))

                // Unidade (3mm, 6mm, 9mm)
                Text(
                    text = "Unidade:",
                    color = BwartsTextGray,
                    fontSize = 13.sp
                )

                Spacer(modifier = Modifier.height(6.dp))

                Row(
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    product.units.forEach { unit ->
                        val isSelected = especificacaoProduto == unit
                        Box(
                            modifier = Modifier
                                .clip(RoundedCornerShape(8.dp))
                                .background(if (isSelected) BwartsOrange else BwartsCardBg)
                                .clickable { especificacaoProduto = unit }
                                .padding(horizontal = 16.dp, vertical = 8.dp)
                        ) {
                            Text(
                                text = unit,
                                color = Color.White,
                                fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal,
                                fontSize = 14.sp
                            )
                        }
                    }
                }

                Spacer(modifier = Modifier.height(16.dp))

                // Quantidade
                Text(
                    text = "Quantidade:",
                    color = BwartsTextGray,
                    fontSize = 13.sp
                )

                Spacer(modifier = Modifier.height(6.dp))

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .clip(RoundedCornerShape(6.dp))
                        .background(BwartsCardBg)
                        .padding(horizontal = 4.dp, vertical = 2.dp)
                ) {
                    IconButton(
                        onClick = { if (unidadesProduto > 1) unidadesProduto-- },
                        modifier = Modifier.size(32.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Default.Remove,
                            contentDescription = "Diminuir quantidade",
                            tint = Color.White
                        )
                    }

                    Text(
                        text = unidadesProduto.toString(),
                        color = Color.White,
                        fontWeight = FontWeight.Bold,
                        fontSize = 15.sp,
                        modifier = Modifier.padding(horizontal = 12.dp)
                    )

                    IconButton(
                        onClick = { unidadesProduto++ },
                        modifier = Modifier.size(32.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Default.Add,
                            contentDescription = "Aumentar quantidade",
                            tint = Color.White
                        )
                    }
                }

                Spacer(modifier = Modifier.height(20.dp))

                // Botão Finalizar Compra
                Button(
                    onClick = {
                        Toast.makeText(contexto, "Finalizando compra de $unidadesProduto item(ns) ($especificacaoProduto)", Toast.LENGTH_SHORT).show()
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(48.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = BwartsOrange),
                    shape = RoundedCornerShape(8.dp)
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Text(
                            text = "Finalizar compra",
                            color = Color.White,
                            fontWeight = FontWeight.Bold,
                            fontSize = 15.sp
                        )
                    }
                }

                Spacer(modifier = Modifier.height(10.dp))

                // Botão Adicionar ao carrinho
                Button(
                    onClick = {
                        Toast.makeText(contexto, "Adicionado $unidadesProduto item(ns) ao carrinho!", Toast.LENGTH_SHORT).show()
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(48.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = BwartsCardBg),
                    shape = RoundedCornerShape(8.dp)
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Icon(
                            imageVector = Icons.Default.ShoppingCart,
                            contentDescription = null,
                            tint = Color.White,
                            modifier = Modifier.size(20.dp)
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(
                            text = "Adicionar ao carrinho",
                            color = Color.White,
                            fontWeight = FontWeight.Bold,
                            fontSize = 15.sp
                        )
                    }
                }

                Spacer(modifier = Modifier.height(24.dp))

                // Card de Descrição / Avaliações
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(12.dp),
                    colors = CardDefaults.cardColors(containerColor = BwartsCardBg)
                ) {
                    Column {
                        // Aba de Navegação (Descrição / Avaliações)
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 16.dp, vertical = 12.dp),
                            horizontalArrangement = Arrangement.spacedBy(24.dp)
                        ) {
                            Column(
                                modifier = Modifier.clickable { abaSelecionada = 0 }
                            ) {
                                Text(
                                    text = "Descrição",
                                    color = if (abaSelecionada == 0) BwartsOrange else Color.White,
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 15.sp
                                )
                                if (abaSelecionada == 0) {
                                    Box(
                                        modifier = Modifier
                                            .padding(top = 4.dp)
                                            .width(70.dp)
                                            .height(2.dp)
                                            .background(BwartsOrange)
                                    )
                                }
                            }

                            Column(
                                modifier = Modifier.clickable { abaSelecionada = 1 }
                            ) {
                                Text(
                                    text = "Avaliações",
                                    color = if (abaSelecionada == 1) BwartsOrange else Color.White,
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 15.sp
                                )
                                if (abaSelecionada == 1) {
                                    Box(
                                        modifier = Modifier
                                            .padding(top = 4.dp)
                                            .width(75.dp)
                                            .height(2.dp)
                                            .background(BwartsOrange)
                                    )
                                }
                            }
                        }

                        HorizontalDivider(color = Color(0xFF38383D), thickness = 1.dp)

                        // Conteúdo da Aba
                        Column(
                            modifier = Modifier.padding(16.dp)
                        ) {
                            if (abaSelecionada == 0) {
                                Text(
                                    text = product.description,
                                    color = BwartsTextGray,
                                    fontSize = 14.sp,
                                    lineHeight = 20.sp
                                )
                                Spacer(modifier = Modifier.height(12.dp))
                                Text(
                                    text = "Largura: ${product.width}",
                                    color = BwartsTextGray,
                                    fontSize = 14.sp
                                )
                                Spacer(modifier = Modifier.height(4.dp))
                                Text(
                                    text = "Altura: ${product.height}",
                                    color = BwartsTextGray,
                                    fontSize = 14.sp
                                )
                                Spacer(modifier = Modifier.height(4.dp))
                                Text(
                                    text = "Material: ${product.material}",
                                    color = BwartsTextGray,
                                    fontSize = 14.sp
                                )
                                Spacer(modifier = Modifier.height(12.dp))
                                Text(
                                    text = product.shipping,
                                    color = BwartsTextGray,
                                    fontSize = 14.sp
                                )
                            } else {
                                Text(
                                    text = "Excelente produto! Muito bem acabado e entrega super rápida. Nota 5.0/5.0",
                                    color = BwartsTextGray,
                                    fontSize = 14.sp,
                                    lineHeight = 20.sp
                                )
                            }
                        }
                    }
                }

                Spacer(modifier = Modifier.height(24.dp))
                }
            }

            // Recomendações
            item {
                ProdutoSecao(
                    title = "Recomendações",
                    products = recomendacoes,
                    onProductClick = onProductClick
                )
            }

            // Baseado em suas pesquisas
            item {
                ProdutoSecao(
                    title = "Baseado em suas pesquisas",
                    products = baseadoEmPesquisas,
                    onProductClick = onProductClick
                )
            }

            // Footer Section
            item {
                FooterSection(
                    onLinkClick = { link ->
                        Toast.makeText(contexto, "Acessando: $link", Toast.LENGTH_SHORT).show()
                    }
                )
            }
        }
    }
}

@Preview
@Composable
fun ProdutoDetalhesPreview() {
    ProdutoDetalhes(
        product = Product(
            id = "demo",
            title = "Produto muito legal de MDF de 3mm x 9mm - mdf",
            price = "R$999,99",
            installments = "Em até 3x sem juros"
        )
    )
}
