package com.example.bwarts.ui.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun PersonalizationBanner(
    onBannerClick: () -> Unit = {},
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(230.dp)
            .background(
                brush = Brush.linearGradient(
                    colors = listOf(
                        Color(0xFFFFB74D),
                        Color(0xFFFF7043),
                        Color(0xFFFF9800),
                        Color(0xFFFF8A00)
                    )
                )
            )
            .clickable { onBannerClick() }
    ) {
        // Decorative translucent circles in background
        Canvas(modifier = Modifier.fillMaxSize()) {
            drawCircle(
                color = Color(0x33FFFFFF),
                radius = 90.dp.toPx(),
                center = Offset(size.width * 0.15f, size.height * 0.2f)
            )
            drawCircle(
                color = Color(0x22FFFFFF),
                radius = 110.dp.toPx(),
                center = Offset(size.width * 0.85f, size.height * 0.15f)
            )
            drawCircle(
                color = Color(0x22FFFFFF),
                radius = 120.dp.toPx(),
                center = Offset(size.width * 0.95f, size.height * 0.85f)
            )
        }

        // Central Dark Card with Stylized Text
        Box(
            modifier = Modifier
                .align(Alignment.Center)
                .fillMaxWidth(0.9f)
                .padding(vertical = 16.dp)
                .shadow(12.dp, RoundedCornerShape(24.dp))
                .clip(RoundedCornerShape(24.dp))
                .background(Color(0xEE1C1C1E))
                .border(2.dp, Color(0x33FFFFFF), RoundedCornerShape(24.dp))
                .padding(horizontal = 20.dp, vertical = 24.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "PERSONALIZE\nSEU PRODUTO AQUI!",
                color = Color.White,
                fontSize = 28.sp,
                fontWeight = FontWeight.Black,
                letterSpacing = 1.sp,
                textAlign = TextAlign.Center,
                lineHeight = 34.sp
            )
        }
    }
}
