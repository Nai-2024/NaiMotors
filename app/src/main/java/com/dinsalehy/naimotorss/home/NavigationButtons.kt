package com.dinsalehy.naimotorss.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.dinsalehy.naimotorss.ui.theme.PrimaryColor
import com.dinsalehy.naimotorss.ui.theme.SecondaryColor


@Composable
fun NavigationButtons(navController: NavController) {
    var currentScreen by remember { mutableStateOf("") }  // No default selected

    Column(
       modifier = Modifier.padding(5.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ColoredButton(
            text = "About Us",
            isSelected = currentScreen == "about_us",
            onClick = {
                currentScreen = "about_us"
                navController.navigate("about_us")
            }
        )

        ColoredButton(
            text = "New Inventory",
            isSelected = currentScreen == "new_inventory",
            onClick = {
                currentScreen = "new_inventory"
                navController.navigate("new_inventory")
            }
        )

        ColoredButton(
            text = "Pre-Owned Vehicle",
            isSelected = currentScreen == "pre_owned_vehicle",
            onClick = {
                currentScreen = "pre_owned_vehicle"
                navController.navigate("pre_owned_vehicle")
            }
        )

        ColoredButton(
            text = "Contact Us",
            isSelected = currentScreen == "contact_us",
            onClick = {
                currentScreen = "contact_us"
                navController.navigate("contact_us")
            }
        )
    }
}


@Composable
fun ColoredButton(
    text: String,
    isSelected: Boolean,
    onClick: () -> Unit
) {
    val buttonColor = if (isSelected) {
        ButtonDefaults.buttonColors()
    } else {
        ButtonDefaults.buttonColors(containerColor = PrimaryColor)
    }

    val buttonModifier = Modifier
        .padding(vertical = 2.dp)
        .fillMaxWidth()
        .height(45.dp)

    Button(
        onClick = onClick,
        modifier = buttonModifier,
        shape = RoundedCornerShape(5.dp),
        colors = buttonColor
    ) {
        Text(
            text = text,
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            color = SecondaryColor
        )
    }
}

