package com.example.bwarts.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.Help
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Category
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.ShoppingBag
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.NavigationDrawerItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bwarts.ui.theme.BwartsDarkBg
import com.example.bwarts.ui.theme.BwartsOrange
import com.example.bwarts.ui.theme.BwartsSurface
import com.example.bwarts.ui.theme.BwartsTextGray

@Composable
fun DrawerContent(
    onItemSelect: (String) -> Unit = {}
) {
    ModalDrawerSheet(
        drawerContainerColor = BwartsSurface,
        drawerContentColor = Color.White,
        modifier = Modifier.width(280.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxHeight()
                .padding(16.dp)
        ) {
            // Header Logo
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 16.dp),
                contentAlignment = Alignment.CenterStart
            ) {
                Text(
                    text = buildAnnotatedString {
                        withStyle(style = SpanStyle(color = BwartsOrange, fontWeight = FontWeight.Black, fontSize = 26.sp)) {
                            append("BW")
                        }
                        withStyle(style = SpanStyle(color = Color.White, fontWeight = FontWeight.Bold, fontSize = 26.sp)) {
                            append("arts")
                        }
                    }
                )
            }

            HorizontalDivider(color = Color(0xFF333336), thickness = 1.dp)

            Spacer(modifier = Modifier.height(16.dp))

            // Navigation Options
            DrawerMenuItem(icon = Icons.Default.Home, label = "Início", onClick = { onItemSelect("Início") })
            DrawerMenuItem(icon = Icons.Default.Category, label = "Produtos em MDF", onClick = { onItemSelect("Produtos") })
            DrawerMenuItem(icon = Icons.Default.Build, label = "Personalizar Produto", onClick = { onItemSelect("Personalizar") })
            DrawerMenuItem(icon = Icons.Default.ShoppingCart, label = "Carrinho de Compras", onClick = { onItemSelect("Carrinho") })
            DrawerMenuItem(icon = Icons.Default.ShoppingBag, label = "Meus Pedidos", onClick = { onItemSelect("Pedidos") })
            DrawerMenuItem(icon = Icons.AutoMirrored.Filled.Help, label = "Ajuda & Suporte", onClick = { onItemSelect("Ajuda") })

            Spacer(modifier = Modifier.weight(1f))

            Text(
                text = "BWarts Mobile App v1.0",
                color = BwartsTextGray,
                fontSize = 11.sp,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
        }
    }
}

@Composable
private fun DrawerMenuItem(
    icon: ImageVector,
    label: String,
    onClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(48.dp)
            .clickable { onClick() }
            .padding(horizontal = 12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = icon,
            contentDescription = label,
            tint = BwartsOrange,
            modifier = Modifier.padding(end = 16.dp)
        )
        Text(
            text = label,
            color = Color.White,
            fontSize = 15.sp,
            fontWeight = FontWeight.Medium
        )
    }
}
