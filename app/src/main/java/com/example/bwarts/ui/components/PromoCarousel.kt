package com.example.bwarts.ui.components

import com.example.bwarts.R
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.animateScrollBy
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsDraggedAsState
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay

data class PromoItem(
    @param:DrawableRes val imagem: Int
)

@Composable
fun PromoCarousel(
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(200.dp)
    ) {
        //Imagens do carrossel
        val imagens = listOf(
            R.drawable.carrossel1,
            R.drawable.carrossel2,
            R.drawable.carrossel3
        )

        val pagerState = rememberPagerState { 3 }
        val pageInteractionSource = remember { MutableInteractionSource() }

        // Identificando se está ocorrendo alguma interação com o carrossel
        val pagerIsDragged by pagerState.interactionSource.collectIsDraggedAsState()
        val pagerIsPressed by pageInteractionSource.collectIsPressedAsState()
        val autoAdvance = !pagerIsDragged && pagerIsPressed

        // Passagem automática de slides
        if(autoAdvance) {
            LaunchedEffect(pagerState, pageInteractionSource) {
                while(true) {
                    delay(2000)
                    val nextPage = (pagerState.currentPage + 1) % 3
                    pagerState.animateScrollToPage(nextPage)
                }
            }
        }

        // carrossel promocional
        HorizontalPager(
            state = pagerState,
            modifier = Modifier.fillMaxSize()
        ) { page ->
            Image(
                painter = painterResource(id = imagens[page]),
                contentDescription = "Slide promocional do carrossel",
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )
        }

        PagerIndicator(imagens.size, pagerState.currentPage)
    }
}

@Composable
fun PagerIndicator(pageCount: Int, currentPageIndex: Int, modifier: Modifier = Modifier){
    Box(modifier = Modifier.fillMaxSize()){
        Row (
            modifier = Modifier
                .wrapContentHeight()
                .fillMaxWidth()
                .align(Alignment.BottomCenter)
                .padding(bottom = 8.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            repeat(pageCount) { iteration ->
                val color = if (currentPageIndex == iteration) Color(0xFFFF8833) else Color(0xFFA0A0AB)
                Box(
                    modifier = modifier
                        .padding(2.dp)
                        .clip(CircleShape)
                        .background(color)
                        .size(6.dp)
                )
            }
        }
    }
}