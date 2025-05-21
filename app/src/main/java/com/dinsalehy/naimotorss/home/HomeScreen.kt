package com.dinsalehy.naimotorss.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.dinsalehy.naimotorss.data.showroomImages
import com.dinsalehy.naimotorss.ui.theme.NaiMotorssTheme

@Composable
fun HomeScreen(navController: NavController, modifier: Modifier = Modifier) {
    Box(modifier = Modifier.fillMaxSize()) {
        // Fixed top bar
        HeaderSection(
            navController = navController,
            modifier = Modifier
                .fillMaxWidth()
               // .height(90.dp)  // Same as TopBarSection height
        )

        // Scrollable content under the header
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFFA09999)),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Background image now scrolls
            item { MainBackgroundImageSection() }

            item { NavigationButtons(navController) }
            item { ShowroomCarousel(imageList = showroomImages) }
            item { ServiceAppointment(navController) }
            item { OperatingHours() }
            item { FooterSection() }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    NaiMotorssTheme {
        val navController = rememberNavController()
        HomeScreen(navController = navController)
    }
}