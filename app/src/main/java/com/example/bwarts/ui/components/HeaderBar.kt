package com.example.bwarts.ui.components

import com.example.bwarts.R
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bwarts.ui.theme.BwartsSurface
import com.example.bwarts.ui.theme.BwartsYellow

@Composable
@Preview
fun HeaderBar(
    cartItemCount: Int = 3,
    onMenuClick: () -> Unit = {},
    onSearchClick: () -> Unit = {},
    onCartClick: () -> Unit = {}
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(BwartsSurface)
            .padding(horizontal = 12.dp, vertical = 8.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Menu hamburguer
        IconButton(onClick = onMenuClick) {
            Icon(
                imageVector = Icons.Default.Menu,
                contentDescription = "Menu Hamburguer",
                tint = Color.White
            )
        }

        // Logo BWarts
        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = "Logo BWarts",
            modifier = Modifier
                .width(90.dp)
                .padding(0.dp)
                .height(40.dp)
        )
//        Text(
//            text = buildAnnotatedString {
//                withStyle(style = SpanStyle(color = BwartsOrange, fontWeight = FontWeight.Bold, fontSize = 24.sp)) {
//                    append("BW")
//                }
//                withStyle(style = SpanStyle(color = Color.White, fontWeight = FontWeight.Bold, fontSize = 24.sp)) {
//                    append("arts")
//                }
//            }
//        )

        // Pesquisa e carrinho
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            IconButton(onClick = onSearchClick) {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = "Pesquisar produtos",
                    tint = Color.White
                )
            }

            IconButton(onClick = onCartClick) {
                BadgedBox(
                    badge = {
                        if (cartItemCount > 0) {
                            Badge(
                                containerColor = BwartsYellow,
                                contentColor = Color.Black
                            ) {
                                Text(
                                    text = cartItemCount.toString(),
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 10.sp
                                )
                            }
                        }
                    }
                ) {
                    Icon(
                        imageVector = Icons.Default.ShoppingCart,
                        contentDescription = "Carrinho de compras",
                        tint = Color.White
                    )
                }
            }
        }
    }
}
