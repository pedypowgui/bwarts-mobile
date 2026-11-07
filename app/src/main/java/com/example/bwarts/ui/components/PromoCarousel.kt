package com.example.bwarts.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bwarts.ui.theme.BwartsOrange

data class PromoItem(
    val title: String,
    val highlight: String,
    val subtitle: String = ""
)

@Composable
@Preview
fun PromoCarousel(
    modifier: Modifier = Modifier
) {
    val items = remember {
        listOf(
            PromoItem(title = "PROMO\nDAY", highlight = "60%\nOFF"),
            PromoItem(title = "FRETE\nGRÁTIS", highlight = "EM TODO\nBRASIL"),
            PromoItem(title = "CORTES\nMDF", highlight = "SOB\nMEDIDA")
        )
    }

    var currentIndex by remember { mutableIntStateOf(0) }

    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(200.dp)
            .background(
                brush = Brush.radialGradient(
                    colors = listOf(
                        Color(0xFF552200),
                        Color(0xFF221100),
                        Color(0xFF141416)
                    ),
                    radius = 800f
                )
            )
            .padding(16.dp)
    ) {
        val item = items[currentIndex]

        Row(
            modifier = Modifier.fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            // Previous Slide Button
            IconButton(
                onClick = {
                    currentIndex = if (currentIndex > 0) currentIndex - 1 else items.size - 1
                },
                modifier = Modifier
                    .size(40.dp)
                    .background(Color(0x66444444), CircleShape)
            ) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.KeyboardArrowLeft,
                    contentDescription = "Anterior",
                    tint = Color.White
                )
            }

            // Carousel Slide Content
            Row(
                modifier = Modifier
                    .weight(1f)
                    .padding(horizontal = 8.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    text = item.title,
                    color = Color.White,
                    fontSize = 32.sp,
                    fontWeight = FontWeight.Black,
                    lineHeight = 34.sp,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.weight(1f)
                )

                // Vertical Orange Separator
                Box(
                    modifier = Modifier
                        .height(90.dp)
                        .width(3.dp)
                        .background(BwartsOrange)
                        .padding(horizontal = 12.dp)
                )

                Spacer(modifier = Modifier.width(12.dp))

                Text(
                    text = item.highlight,
                    color = Color.White,
                    fontSize = 36.sp,
                    fontWeight = FontWeight.Black,
                    lineHeight = 38.sp,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.weight(1f)
                )
            }

            // Next Slide Button
            IconButton(
                onClick = {
                    currentIndex = (currentIndex + 1) % items.size
                },
                modifier = Modifier
                    .size(40.dp)
                    .background(Color(0x66444444), CircleShape)
            ) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                    contentDescription = "Próximo",
                    tint = Color.White
                )
            }
        }

        // Indicator dots
        Row(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 4.dp),
            horizontalArrangement = Arrangement.spacedBy(6.dp)
        ) {
            items.indices.forEach { index ->
                Box(
                    modifier = Modifier
                        .size(if (index == currentIndex) 8.dp else 6.dp)
                        .clip(CircleShape)
                        .background(
                            if (index == currentIndex) BwartsOrange else Color.Gray
                        )
                )
            }
        }
    }
}
