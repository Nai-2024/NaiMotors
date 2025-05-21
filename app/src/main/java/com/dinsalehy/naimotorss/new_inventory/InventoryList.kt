package com.dinsalehy.naimotorss.new_inventory

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.sp
import com.dinsalehy.naimotorss.data.Car

@Composable
fun ExpandableCarList(cars: List<Car>) {
    val expandedStates = remember { mutableStateMapOf<Int, Boolean>() }


    // Filter states
    var selectedYear by remember { mutableStateOf("Year") }
    var selectedMake by remember { mutableStateOf("Make") }
    var selectedModel by remember { mutableStateOf("Model") }
    var selectedEngine by remember { mutableStateOf("Engine Type") }


    // Filtering logic
    val filteredCars = cars.filter { car ->
        (selectedYear == "Year" || car.year == selectedYear.toIntOrNull()) && //toIntOrNull() converts to Int
                (selectedMake == "Make" || car.make == selectedMake) &&
                (selectedModel == "Model" || car.model == selectedModel) &&
                (selectedEngine == "Engine Type" || car.engineType == selectedEngine)
    }

    Column(modifier = Modifier.padding(6.dp)) {
        Text(
            "New Inventory",
            style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.Bold),
            modifier = Modifier.padding(vertical = 8.dp, horizontal = 4.dp)

        )

        // ⬇️ Pass selectedYear and update callback to CarFilters
        // Pass filter states and updaters
        CarFilters(
            selectedYear, { selectedYear = it },
            selectedMake, { selectedMake = it },
            selectedModel, { selectedModel = it },
            selectedEngine, { selectedEngine = it }
        )

        filteredCars.forEachIndexed { index, car ->
            val isExpanded = expandedStates[index] ?: false

            // Card that holds card image and details
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 2.dp),

                shape = RoundedCornerShape(5.dp),
                onClick = {
                    expandedStates[index] = !isExpanded
                },
            ) {
                val columnModifier = Modifier.then(
                    if (!isExpanded) Modifier.padding(10.dp) else Modifier
                )

                Column(modifier = Modifier
                    .fillMaxWidth()
                    .background(Color(0xFFE0E0E0)) //darker bkg for each card

                ) {
                    if (!isExpanded) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Image(
                                painter = painterResource(id = car.imageResourceId),
                                contentDescription = car.model,
                                modifier = Modifier
                                    .size(70.dp)
                                    .clip(RoundedCornerShape(6.dp))
                                    .padding(start = 10.dp)
                            )
                            Spacer(modifier = Modifier.width(21.dp))
                            Text(
                                "${car.year} ${car.make} ${car.model}",
                                fontWeight = FontWeight.Bold,
                                color = Color(0xFF333333),
                                fontSize = 18.sp
                            )
                        }
                    }

                    if (isExpanded) {
                        Image(
                            painter = painterResource(id = car.imageResourceId),
                            contentDescription = "Car Image",
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(240.dp),
                            //.wrapContentHeight(), // Automatically adjusts height
                            contentScale = ContentScale.FillWidth
                        )

                        LabeledTextBox("Make", car.make, Color(0xFFBEBBBB))
                        LabeledTextBox("Model", car.model, Color(0xFFF0F0F0))
                        LabeledTextBox("Year", car.year.toString(), Color(0xFFBEBBBB))
                        LabeledTextBox("Body Style", car.bodyStyle ?: "N/A", Color(0xFFF0F0F0))
                        LabeledTextBox("Engine Type", car.engineType ?: "N/A", Color(0xFFBEBBBB))
                        LabeledTextBox("Exterior Color", car.exteriorColor ?: "N/A", Color(0xFFF0F0F0))
                        LabeledTextBox("Interior Color", car.interiorColor ?: "N/A", Color(0xFFBEBBBB))
                        LabeledTextBox("Price", car.price.toString(), Color(0xFFF0F0F0))
                    }
                }
            }
        }
    }
}

// to set different background colors for each text separately
// Box after the user click over car image and it expands to show details
@Composable
fun LabeledTextBox(label: String,value: String, backgroundColor: Color) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(backgroundColor) // BKG color for text
    ) {
        Row( modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically // Centers content vertically){
        ){
            //Label
            Text(
                text = "$label:", // Combine label and value into a single string
                modifier = Modifier
                    .weight(0.4f)// Allocate 40% space to label
                    .padding(horizontal = 12.dp),

                fontWeight = FontWeight.Bold
            )
            // Value
            Text(
                text = value,
                modifier = Modifier
                    .weight(0.6f)  // Allocate 60% space to value
                    .padding(horizontal = 34.dp),
                fontWeight = FontWeight.Bold
            )
        }
       Spacer(modifier = Modifier.height(6.dp))
    }
}


