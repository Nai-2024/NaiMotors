package com.dinsalehy.naimotorss.service

import android.app.TimePickerDialog
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import android.app.DatePickerDialog
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.width
import androidx.compose.material.Divider
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccessTime
import androidx.compose.material.icons.filled.CalendarToday
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.rememberNavController
import com.dinsalehy.naimotorss.home.HeaderSection
import java.util.Calendar

@Composable
fun ServiceAppointmentForm(navController: NavController) {
    // State variables
    var name by remember { mutableStateOf("") }
    var vehicle by remember { mutableStateOf("") }
    var date by remember { mutableStateOf("") }
    var time by remember { mutableStateOf("") }
    var serviceDescription by remember { mutableStateOf("") }
    var confirmationMessage by remember { mutableStateOf("") }
    var isSubmitted by remember { mutableStateOf(false) }
    var nameError by remember { mutableStateOf("") }
    var vehicleError by remember { mutableStateOf("") }


    val context = LocalContext.current
    val calendar = Calendar.getInstance()

    // Date Picker Dialog
    val datePickerDialog = remember {
        DatePickerDialog(
            context,
            { _, year, month, dayOfMonth ->
                date = "${month + 1}/$dayOfMonth/$year"
            },
            calendar.get(Calendar.YEAR),
            calendar.get(Calendar.MONTH),
            calendar.get(Calendar.DAY_OF_MONTH)
        )
    }

    // Time Picker Dialog
    val timePickerDialog = remember {
        TimePickerDialog(
            context,
            { _, hour, minute ->
                val amPm = if (hour < 12) "AM" else "PM"
                val displayHour = if (hour > 12) hour - 12 else hour
                time = "$displayHour:${minute.toString().padStart(2, '0')} $amPm"
            },
            calendar.get(Calendar.HOUR_OF_DAY),
            calendar.get(Calendar.MINUTE),
            false
        )
    }

    // Now your UI layout can follow here
    Box(modifier = Modifier.fillMaxSize()) {
        HeaderSection(
            navController,
            modifier = Modifier
                .fillMaxWidth()
                .height(80.dp)
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 100.dp, start = 16.dp, end = 16.dp),
            verticalArrangement = Arrangement.spacedBy(6.dp)
        ) {
            Text("Book Service Appointment", style = MaterialTheme.typography.headlineSmall)

            OutlinedTextField(
                label = "Name",
                value = name,
                onValueChange = {
                    name = it
                    nameError =
                        if (it.matches(Regex("^[A-Za-z ]*$"))) "" else "Name must contain letters only"
                },
                error = nameError,
                enabled = !isSubmitted // Disable field after form submission
            )

            OutlinedTextField(
                label = "Vehicle",
                value = vehicle,
                onValueChange = {
                    vehicle = it
                    vehicleError =
                        if (it.matches(Regex("^[A-Za-z0-9 ]*$"))) "" else "Vehicle must contain only letters and numbers"
                },
                error = vehicleError,
                enabled = !isSubmitted // Disable field after form submission
            )


            // Date Picker Row
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                   // .clickable { datePickerDialog.show() }
                    .clickable(enabled = !isSubmitted) { datePickerDialog.show() } // Disable date picker after submission
                    .padding(vertical = 12.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(Icons.Default.CalendarToday, contentDescription = "Date")
                Spacer(Modifier.width(16.dp))
                Text(
                    text = if (date.isEmpty()) "Select Date" else "Date: $date",
                    color = if (date.isEmpty()) Color.Gray else Color.Black
                )
            }
            Divider()

            // Time Picker Row
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    //.clickable { timePickerDialog.show() }
                    .clickable(enabled = !isSubmitted) { timePickerDialog.show() } // Disable time picker after submission
                    .padding(vertical = 12.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(Icons.Default.AccessTime, contentDescription = "Time")
                Spacer(Modifier.width(16.dp))
                Text(
                    text = if (time.isEmpty()) "Select Time" else "Time: $time",
                    color = if (time.isEmpty()) Color.Gray else Color.Black
                )
            }
            Divider()

            val minLines = 3

            OutlinedTextField(
                value = serviceDescription,
                onValueChange = { serviceDescription = it },
                label = { Text("Service Description") },
                singleLine = false,
                modifier = Modifier
                    .fillMaxWidth()
                    .heightIn(min = (minLines * 72).dp),
                maxLines = Int.MAX_VALUE,
                enabled = !isSubmitted // Disable field after form submission
            )
            // Submit Button
            Button(
                onClick = {
                    val result = validateServiceAppointmentForm(name, vehicle)
                    nameError = result.nameError
                    vehicleError = result.vehicleError

                    if (result.isFormValid) {
                        confirmationMessage = "Thank you, $name! Your $vehicle is booked for service on $date at $time."

                        // Clear fields
                        name = ""
                        vehicle = ""
                        date = ""
                        time = ""
                        serviceDescription = ""
                        isSubmitted = true // Disable the form
                    }
                },
                enabled = !isSubmitted,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
            ) {
                Text("Submit", fontSize = 16.sp)
            }
            if (confirmationMessage.isNotEmpty()) {
                Text(
                    text = confirmationMessage,
                    color = Color.Black,
                    fontSize = 16.sp,
                    style = TextStyle(fontWeight = FontWeight.Bold),
                    modifier = Modifier.padding(top = 12.dp)
                )
            }
        }
    }
}


@Composable
fun OutlinedTextField(
    label: String,
    value: String,
    onValueChange: (String) -> Unit,
    isMultiline: Boolean = false,
    error: String = "",
    modifier: Modifier = Modifier,
    enabled: Boolean = true // Add the enabled parameter here

) {
    Column(modifier = modifier.fillMaxWidth()) {
        OutlinedTextField(
            value = value,
            onValueChange = onValueChange,
            label = { Text(label) },
            isError = error.isNotEmpty(),
            singleLine = !isMultiline,
            enabled = enabled,
            modifier = Modifier
                .fillMaxWidth()
                .then(
                    if (isMultiline) Modifier.defaultMinSize(minHeight = 56.dp) else Modifier
                ),
            maxLines = if (isMultiline) Int.MAX_VALUE else 1
        )
        if (error.isNotEmpty()) {
            Text(
                text = error,
                color = Color.Red,
                fontSize = 12.sp,
                modifier = Modifier.padding(start = 8.dp, top = 2.dp)
            )
        }
    }
}



@Preview(showBackground = true)
@Composable
fun ServiceAppointmentFormPreview() {
    // Provide a dummy NavController for preview
    val navController = rememberNavController()
    Surface(modifier = Modifier.padding(16.dp)) {
        ServiceAppointmentForm(navController)
    }
}
