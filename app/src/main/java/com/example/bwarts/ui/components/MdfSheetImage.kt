package com.example.bwarts.ui.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.StarBorder
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.rotate
import androidx.compose.ui.unit.dp
import com.example.bwarts.ui.theme.BwartsYellow

@Composable
fun MdfSheetImage(
    isFavorite: Boolean = false,
    onFavoriteToggle: () -> Unit = {},
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .background(Color(0xFFEFEFEF))
    ) {
        // Render 3D stacked MDF sheets using Canvas
        Canvas(modifier = Modifier.fillMaxSize()) {
            val w = size.width
            val h = size.height

            // Layer 1 (Bottom beige raw MDF sheet)
            drawPath(
                path = Path().apply {
                    moveTo(w * 0.15f, h * 0.35f)
                    lineTo(w * 0.70f, h * 0.20f)
                    lineTo(w * 0.90f, h * 0.65f)
                    lineTo(w * 0.35f, h * 0.85f)
                    close()
                },
                brush = Brush.linearGradient(
                    colors = listOf(Color(0xFFD7CCC8), Color(0xFFBCAAA4)),
                    start = Offset(0f, 0f),
                    end = Offset(w, h)
                )
            )

            // Layer 2 (Middle lighter oak MDF sheet)
            drawPath(
                path = Path().apply {
                    moveTo(w * 0.12f, h * 0.28f)
                    lineTo(w * 0.65f, h * 0.15f)
                    lineTo(w * 0.85f, h * 0.58f)
                    lineTo(w * 0.30f, h * 0.75f)
                    close()
                },
                brush = Brush.linearGradient(
                    colors = listOf(Color(0xFFE0D5C1), Color(0xFFC7B299)),
                    start = Offset(0f, 0f),
                    end = Offset(w, h)
                )
            )

            // Layer 3 (Top dark wood veneer MDF sheet)
            drawPath(
                path = Path().apply {
                    moveTo(w * 0.10f, h * 0.20f)
                    lineTo(w * 0.60f, h * 0.10f)
                    lineTo(w * 0.80f, h * 0.50f)
                    lineTo(w * 0.25f, h * 0.65f)
                    close()
                },
                brush = Brush.linearGradient(
                    colors = listOf(Color(0xFF6D4C41), Color(0xFF4E342E), Color(0xFF3E2723)),
                    start = Offset(0f, 0f),
                    end = Offset(w, h)
                )
            )

            // Edge highlight/shadow on top sheet
            drawPath(
                path = Path().apply {
                    moveTo(w * 0.25f, h * 0.65f)
                    lineTo(w * 0.80f, h * 0.50f)
                    lineTo(w * 0.82f, h * 0.52f)
                    lineTo(w * 0.26f, h * 0.67f)
                    close()
                },
                color = Color(0xFF271510)
            )
        }

        // Star button at top-right corner
        IconButton(
            onClick = onFavoriteToggle,
            modifier = Modifier
                .align(Alignment.TopEnd)
                .padding(6.dp)
                .size(28.dp)
                .background(Color(0x77333333), CircleShape)
        ) {
            Icon(
                imageVector = if (isFavorite) Icons.Default.Star else Icons.Outlined.StarBorder,
                contentDescription = "Favorito",
                tint = if (isFavorite) BwartsYellow else Color.White,
                modifier = Modifier.size(16.dp)
            )
        }
    }
}
