package com.dinsalehy.naimotorss.pre_owned_vehicles

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.dinsalehy.naimotorss.data.Car
import com.dinsalehy.naimotorss.home.HeaderSection
import com.dinsalehy.naimotorss.new_inventory.LabeledTextBox

@Composable
fun PreOwnedVehicleScreen(navController: NavController, viewModel: UsedCarViewModel = viewModel()) {

    val carList = viewModel.usedCarList

    Box(
        modifier = Modifier
            .fillMaxSize()
           // .background(Color(0xFF5DA48E)) // 0xFF1E3A5F - 0xFF4B7F72 -- 0xFF2F4F4F
            .background(Color(0xFFA09999))
    ) {

        // Fixed Header on top
        HeaderSection(
            navController = navController,
            modifier = Modifier
                .fillMaxWidth()
                .height(90.dp) // Match this to top padding below
                .zIndex(1f)
        )

        // Scrollable content (Used Cars text and list)
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 97.dp, bottom = 30.dp)
        ) {
            item {
                Text(
                    text = "Pre-Owned Vehicles",
                    style = MaterialTheme.typography.titleLarge.copy(
                        fontWeight = FontWeight.Bold
                    ),
                    color = Color.Black,
                    modifier = Modifier.padding(12.dp)
                )
            }

            items(carList) { car ->
                CarItem(car)
            }
        }
    }
}


@Composable
fun CarItem(car: Car) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding( horizontal = 7.dp, vertical = 3.dp),
        shape = RoundedCornerShape(5.dp)

    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalAlignment = Alignment.Start
        ) {
            Image(
                painter = painterResource(id = car.imageResourceId),
                contentDescription = "Model",
                modifier = Modifier
                    .fillMaxWidth()
                .aspectRatio(16f / 13f), // Adjusting as per the screen height . f = float
                contentScale = ContentScale.Crop
            )

            LabeledTextBox("Make", car.make, Color(0xFFBEBBBB))
            LabeledTextBox("Model", car.model, Color(0xFFF0F0F0))
            LabeledTextBox("Exterior Color", car.exteriorColor ?: "N/A", Color(0xFFBEBBBB))
            LabeledTextBox("Mileage", "${car.mileage ?: 0} KM", Color(0xFFF0F0F0))
            LabeledTextBox("Price", "$ ${car.price}", Color(0xFFBEBBBB))
            LabeledTextBox("Year", "${car.year}", Color(0xFFF0F0F0))

        }
    }
}
