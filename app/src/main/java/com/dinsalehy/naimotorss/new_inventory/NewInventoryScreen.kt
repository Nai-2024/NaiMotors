package com.dinsalehy.naimotorss.new_inventory


import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.dinsalehy.naimotorss.home.HeaderSection

import com.dinsalehy.naimotorss.data.newCars


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun NewInventoryScreen(navController: NavController) {

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFA09999))
    ) {
        // Fixed Header
        HeaderSection(navController)

        // Scrollable content below the header
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(top = 90.dp) // Offset for fixed header height
        ) {
            ExpandableCarList(cars = newCars)
        }
    }
}

@Composable
@Preview(showBackground = true)
fun NewInventoryScreenPreview() {
    // Use a dummy NavController for preview
    val navController = rememberNavController()
    NewInventoryScreen(navController = navController)
}

/// -------------


/*
 Notes --- >> 
1- Filtering UI at the Top by
    - Using ExposedDropdownMenuBox for each button ( Year, Make, Model...)

2- Horizontal car card display
    - Using HorizontalPager from Accompanist library to show a scrollable row of car cards to show
        - Thumbnail/image of the car,
        - Basic info (model name, price, etc).

3- Details Section Below Pager
    -    When a car is selected from the carousel, show its detailed info in a box below. This includes:
        - Year, Make, Model
        - Features, Description
        - Price

 4- Using View Model to manage
    - State (selectedYear, selectedMake, selectedModel, selectedCar)
    -

Dependencies required
    - implementation "androidx.compose.material3:material3:1.2.0"
    - implementation "androidx.compose.material:material:1.4.3"

 */