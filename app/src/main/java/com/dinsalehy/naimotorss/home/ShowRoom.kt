package com.dinsalehy.naimotorss.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.google.accompanist.pager.*
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import com.dinsalehy.naimotorss.ui.theme.PrimaryColor
import com.dinsalehy.naimotorss.ui.theme.SecondaryColor


@OptIn(ExperimentalPagerApi::class)
@Composable
fun ShowroomCarousel(imageList: List<Int>) {
    val pagerState = rememberPagerState()

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(250.dp)
            .padding(start = 5.dp, end = 5.dp, bottom = 6.dp)
            .clip(RoundedCornerShape(5.dp))
    ) {
        // The image pager
        HorizontalPager(
            count = imageList.size,
            state = pagerState,
            modifier = Modifier.fillMaxSize()
        ) { page ->
            Image(
                painter = painterResource(id = imageList[page]),
                contentDescription = "Showroom Image",
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()

            )
        }

        // The indicator dots overlayed at the bottom center
        HorizontalPagerIndicator(
            pagerState = pagerState,
            activeColor = PrimaryColor,
            inactiveColor = SecondaryColor,
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 12.dp),
            indicatorWidth = 8.dp,
            indicatorHeight = 8.dp,
            spacing = 6.dp
        )
    }
}
