package com.dinsalehy.naimotorss.new_inventory

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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Checkbox
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.dinsalehy.naimotorss.data.FilterData
import com.dinsalehy.naimotorss.ui.theme.PrimaryColor
import com.dinsalehy.naimotorss.ui.theme.SecondaryColor

@Composable
//fun CarFilters() {

fun CarFilters(
    selectedYear: String,
    onYearSelected: (String) -> Unit,
    selectedMake: String,
    onMakeSelected: (String) -> Unit,
    selectedModel: String,
    onModelSelected: (String) -> Unit,
    selectedEngine: String,
    onEngineSelected: (String) -> Unit,
){

    Column(modifier = Modifier
        .padding( bottom = 2.dp)
        // .background(Color.Black), // Testing purposes
    ) {
        // Dropdowns with filter logic
        DropdownMenuButton("Year", FilterData.years, selectedYear, "Year", onYearSelected)
        Spacer(modifier = Modifier.height(3.dp))
        DropdownMenuButton("Make", FilterData.makes, selectedMake, "Make", onMakeSelected)
        Spacer(modifier = Modifier.height(4.dp))
        DropdownMenuButton("Model", FilterData.models, selectedModel, "Model", onModelSelected)
        Spacer(modifier = Modifier.height(4.dp))
        DropdownMenuButton("Engine", FilterData.engineTypes, selectedEngine, "Engine Type", onEngineSelected)
        Spacer(modifier = Modifier.height(4.dp))
    }

}


///////////============= //////
@Composable
fun DropdownMenuButton(
    label: String,
    options: List<String>,
    selectedOption: String,
    defaultOption: String,
    onOptionSelected: (String) -> Unit,
) {

    // Keeps track of whether the dropdown menu is expanded or not
    var expanded by remember { mutableStateOf(false) }

    // Container for the dropdown button and menu
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(39.dp)
            .clickable { expanded = true }
            .clip(RoundedCornerShape(5.dp))
            .background(PrimaryColor),
        contentAlignment = Alignment.Center
    ) {
        // Row holds text and icon horizontally
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 12.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            // Displays either "Label" or "Label: SelectedOption" based on selection
            Text(
                text = if (selectedOption != defaultOption) "$label : $selectedOption" else label,
                color = SecondaryColor,
                fontWeight = FontWeight.Bold
            )

            // Drop-down arrow icon
            Icon(
                imageVector = Icons.Default.ArrowDropDown, //  Built-in drop-down arrow
                contentDescription = "Dropdown Arrow",
                tint = SecondaryColor,
            )
        }

        // Dropdown menu that shows below the button when expanded is true
        DropdownMenu( modifier = Modifier,
            // .background(Color.Cyan), // Testing purposes
            expanded = expanded,
            onDismissRequest = { expanded = false } // Collapse menu when user taps outside
        ) {
            // Creates a DropdownMenuItem for each option
            options.forEach { option ->
                DropdownMenuItem(
                    text = {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Text(option)
                            Spacer(modifier = Modifier.weight(1f))
                            Checkbox(
                                checked = selectedOption == option,
                                onCheckedChange = { checked ->
                                    if (checked) {
                                        onOptionSelected(option)
                                    } else {
                                        onOptionSelected(defaultOption) // Reset
                                    }
                                    expanded = false
                                }
                            )
                        }
                    },
                    onClick = { /* do nothing here, we use Checkbox instead */ }
                )
            }
        }
    }
}