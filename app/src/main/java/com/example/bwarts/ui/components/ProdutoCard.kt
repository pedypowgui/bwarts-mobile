package com.example.bwarts.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bwarts.ui.theme.BwartsCardBg
import com.example.bwarts.ui.theme.BwartsTextGray
import com.example.bwarts.ui.theme.BwartsTextMuted

data class Product(
    val id: String,
    val title: String = "Produto legal de MDF de 3mmx9mm",
    val price: String = "R$999,99",
    val installments: String = "Em 3x sem juros"
)

@Composable
fun ProdutoCard(
    product: Product,
    onProductClick: (Product) -> Unit = {},
    modifier: Modifier = Modifier
) {
    var isFavorite by remember { mutableStateOf(false) }

    Card(
        modifier = modifier
            .width(160.dp)
            .clip(RoundedCornerShape(12.dp))
            .clickable { onProductClick(product) },
        colors = CardDefaults.cardColors(
            containerColor = BwartsCardBg
        ),
        shape = RoundedCornerShape(12.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column {
            // Imagem do produto
            imagemProdutoCard(
                isFavorite = isFavorite,
                onFavoriteToggle = { isFavorite = !isFavorite },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(140.dp)
            )

            // Product Information
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp)
            ) {
                Text(
                    text = product.title,
                    color = BwartsTextGray,
                    fontSize = 11.sp,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis,
                    lineHeight = 13.sp
                )

                Spacer(modifier = Modifier.height(4.dp))

                Text(
                    text = product.price,
                    color = Color.White,
                    fontSize = 17.sp,
                    fontWeight = FontWeight.Bold
                )

                Spacer(modifier = Modifier.height(2.dp))

                Text(
                    text = product.installments,
                    color = BwartsTextMuted,
                    fontSize = 10.sp
                )
            }
        }
    }
}
