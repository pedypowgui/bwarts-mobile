package com.example.bwarts.ui.components

import com.example.bwarts.R
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

data class PromoItem(
    @param:DrawableRes val imagem: Int
)

@Composable
@Preview
fun PromoCarousel(
    modifier: Modifier = Modifier
) {
    //Imagens do carrossel
    val imagens = listOf(
        R.drawable.carrossel1,
        R.drawable.carrossel2,
        R.drawable.carrossel3
    )

    val pagerState = rememberPagerState { imagens.size }

    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(200.dp)
    ) {
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
    }
}
