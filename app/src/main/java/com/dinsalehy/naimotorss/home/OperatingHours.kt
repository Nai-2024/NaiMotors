package com.dinsalehy.naimotorss.home

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.style.TextAlign
import com.dinsalehy.naimotorss.ui.theme.PrimaryColor
import com.dinsalehy.naimotorss.ui.theme.SecondaryColor

@Composable
fun OperatingHours() {
    // Track the selected tab (default: Sales)
    var selectedTab by remember { mutableStateOf("Sales") }

    // Define operation hours with separate days and times
    val hoursMap = mapOf(
        "Sales" to listOf(
            "Mon - Thu" to "9AM - 8PM",
            "Fri - Sat" to "10AM - 6PM",
            "Sunday" to "Closed"
        ),
        "Parts" to listOf(
            "Mon - Thu" to "9AM - 8PM",
            "Fri - Sat" to "9AM - 5PM",
            "Sunday" to "Closed"
        ),
        "Service" to listOf(
            "Mon - Thu" to "9AM - 7PM",
            "Fri - Sat" to "10AM - 5PM",
            "Sunday" to "Closed"
        )
    )

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(6.dp)
            .background(
                color = PrimaryColor,
                shape = RoundedCornerShape(6.dp)
            )
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Hours of Operation",
            color = Color.White,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )

        Divider(
            color = Color.Cyan,
            thickness = 0.5.dp,
            modifier = Modifier.padding(vertical = 10.dp)
        )

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            ClickableTab("Sales", selectedTab == "Sales") { selectedTab = "Sales" }
            VerticalDivider(24.dp)
            ClickableTab("Parts", selectedTab == "Parts") { selectedTab = "Parts" }
            VerticalDivider(24.dp)
            ClickableTab("Service", selectedTab == "Service") { selectedTab = "Service" }
        }

        Spacer(Modifier.height(6.dp))

        // Two-column hours display
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal =36.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            hoursMap[selectedTab]?.forEach { (day, time) ->
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = day,
                        color = Color.White,
                        modifier = Modifier.weight(1f),
                        textAlign = TextAlign.Start
                    )
                    Text(
                        text = time,
                        color = Color.White,
                        modifier = Modifier.weight(1f),
                        textAlign = TextAlign.End
                    )
                }
            }
        }
    }
}

@Composable
fun ClickableTab(text: String, isSelected: Boolean, onClick: () -> Unit) {
    Text(
        text = text,
        color = if (isSelected) Color.White else SecondaryColor,
        fontSize = 16.sp,
        fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal,
        modifier = Modifier
            .clickable(onClick = onClick)
            .padding(8.dp)
    )
}

// Custom vertical divider
@Composable
private fun VerticalDivider(height: Dp) {
    Box(
        modifier = Modifier
            .width(1.dp)
            .height(height)
            .background(Color.White)
    )
}

@Preview(showBackground = true)
@Composable
fun OperationHoursPreview() {
    OperatingHours()
}
