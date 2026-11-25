package com.example.bwarts.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.bwarts.R

@Composable
@Preview
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
        // Central Dark Card with Stylized Text
        Box(
            modifier = Modifier
                .align(Alignment.Center)
                .fillMaxSize(0.9f),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(R.drawable.banner_personalizacao),
                contentDescription = "Banner para redirecionar para personalização de produto",
                modifier = Modifier.fillMaxSize()
            )
        }
    }
}
