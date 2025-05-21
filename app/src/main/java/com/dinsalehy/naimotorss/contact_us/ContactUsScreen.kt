package com.dinsalehy.naimotorss.contact_us

import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.dinsalehy.naimotorss.home.HeaderSection

@Composable
fun ContactUsScreen(navController: NavController, viewModel: ContactUsViewModel = viewModel()) {
    val state by viewModel.formState.collectAsState()
    val context = LocalContext.current
    val minLines = 7

    Box(modifier = Modifier.fillMaxSize()) {
        HeaderSection(
            navController = navController,
            modifier = Modifier
                .fillMaxWidth()
                .height(80.dp)
                .align(Alignment.TopStart)
                .zIndex(1f)
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 107.dp, start = 15.dp, end = 15.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Text("Contact Us", fontSize = 24.sp, style = MaterialTheme.typography.titleLarge)

            OutlinedTextField(
                value = state.name,
                onValueChange = { viewModel.onNameChanged(it) },
                label = { Text("Full Name") },
                isError = state.nameError.isNotEmpty(),
                enabled = !state.isSubmitted,
                modifier = Modifier.fillMaxWidth()
            )
            if (state.nameError.isNotEmpty()) ErrorText(state.nameError)

            OutlinedTextField(
                value = state.email,
                onValueChange = { viewModel.onEmailChanged(it) },
                label = { Text("Email address") },
                isError = state.emailError.isNotEmpty(),
                enabled = !state.isSubmitted,
                modifier = Modifier.fillMaxWidth()
            )
            if (state.emailError.isNotEmpty()) ErrorText(state.emailError)

            OutlinedTextField(
                value = state.phone,
                onValueChange = { viewModel.onPhoneChanged(it) },
                label = { Text("Phone Number") },
                isError = state.phoneError.isNotEmpty(),
                enabled = !state.isSubmitted,
                modifier = Modifier.fillMaxWidth()
            )
            if (state.phoneError.isNotEmpty()) ErrorText(state.phoneError)

            OutlinedTextField(
                value = state.message,
                onValueChange = { viewModel.onMessageChanged(it) },
                label = { Text("Message") },
                isError = state.messageError.isNotEmpty(),
                enabled = !state.isSubmitted,
                modifier = Modifier
                    .fillMaxWidth()
                    .defaultMinSize(minHeight = (minLines * 24).dp),
                maxLines = Int.MAX_VALUE
            )
            if (state.messageError.isNotEmpty()) ErrorText(state.messageError)

            Button(
                onClick = {
                    val success = viewModel.submitForm()
                    if (success) {
                        Toast.makeText(context, "Thank you for contacting us!", Toast.LENGTH_LONG).show()
                    }
                },
                enabled = !state.isSubmitted,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
            ) {
                Text("Submit", fontSize = 16.sp)
            }
        }
    }
}

@Composable
fun ErrorText(text: String) {
    Text(
        text = text,
        color = Color.Red,
        fontSize = 12.sp,
        modifier = Modifier.padding(start = 8.dp)
    )
}

/*
@Composable
fun ContactUsScreen(navController: NavController) {

    val minLines = 7
    val context = LocalContext.current

    var name by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var phone by remember { mutableStateOf("") }
    var message by remember { mutableStateOf("") }
    var nameError by remember { mutableStateOf("") }
    var emailError by remember { mutableStateOf("") }
    var phoneError by remember { mutableStateOf("") }
    var messageError by remember { mutableStateOf("") }
    var isSubmitted by remember { mutableStateOf(false) }

    Box(modifier = Modifier.fillMaxSize()) {
        // HEADER OUTSIDE COLUMN AND NO PADDING
        HeaderSection(
            navController,
        //    showBackground = false,
            modifier = Modifier
                .fillMaxWidth()
                .height(80.dp)
                .align(Alignment.TopStart)
                .zIndex(1f)
        )

        // MAIN CONTENT BELOW HEADER WITH PADDING
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 107.dp, start = 15.dp, end = 15.dp), // leave room for header
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Text(
                text = "Contact Us",
                fontSize = 24.sp,
                style = MaterialTheme.typography.titleLarge,
                // modifier = Modifier.padding(bottom = 6.dp)
            )
            OutlinedTextField(
                value = name,
                onValueChange = {
                    name = it
                    val result = validateContactForm(name, email, phone, message)
                    nameError = result.nameError
                },
                label = { Text("Full Name") },
                isError = nameError.isNotEmpty(),
                singleLine = true,
                enabled = !isSubmitted,
                modifier = Modifier.fillMaxWidth()
            )
            if (nameError.isNotEmpty()) {
                Text(
                    text = nameError,
                    color = Color.Red,
                    fontSize = 12.sp,
                    modifier = Modifier.padding(start = 8.dp)
                )
            }


            OutlinedTextField(
                value = email,
                onValueChange = {
                    email = it
                    val result = validateContactForm(name, email, phone, message)
                    emailError = result.emailError
                },
                label = { Text("Email address") },
                isError = emailError.isNotEmpty(),
                singleLine = true,
                enabled = !isSubmitted,
                modifier = Modifier.fillMaxWidth()
            )
            if (emailError.isNotEmpty()) {
                Text(
                    text = emailError,
                    color = Color.Red,
                    fontSize = 12.sp,
                    modifier = Modifier.padding(start = 8.dp)
                )
            }

            OutlinedTextField(
                value = phone,
                onValueChange = {
                    phone = it
                    val result = validateContactForm(name, email, phone, message)
                    phoneError = result.phoneError
                },
                label = { Text("Phone Number") },
                isError = phoneError.isNotEmpty(),
                singleLine = true,
                enabled = !isSubmitted,
                modifier = Modifier.fillMaxWidth()
            )
            if (phoneError.isNotEmpty()) {
                Text(
                    text = phoneError,
                    color = Color.Red,
                    fontSize = 12.sp,
                    modifier = Modifier.padding(start = 8.dp)
                )
            }

            OutlinedTextField(
                value = message,
                onValueChange = {
                    message = it
                    val result = validateContactForm(name, email, phone, message)
                    messageError = result.messageError
                },
                label = { Text("Message") },
                isError = messageError.isNotEmpty(),
                singleLine = false,
                enabled = !isSubmitted,
                modifier = Modifier
                    .fillMaxWidth()
                    .defaultMinSize(minHeight = (minLines * 24).dp), // 24.dp per line approx
                maxLines = Int.MAX_VALUE,
               // keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Text)
            )

            if (messageError.isNotEmpty()) {
                Text(
                    text = messageError,
                    color = Color.Red,
                    fontSize = 12.sp,
                    modifier = Modifier.padding(start = 8.dp)
                )
            }

            Button(
                onClick = {
                    val result = validateContactForm(name, email, phone, message)
                    nameError = result.nameError
                    emailError = result.emailError
                    phoneError = result.phoneError

                    if (result.isNameValid && result.isEmailValid && result.isPhoneValid) {
                        Toast.makeText(context, "Thank you for contacting us!", Toast.LENGTH_LONG)
                            .show()
                        // Optionally clear fields:
                        name = ""
                        email = ""
                        phone = ""
                        message = ""

                        // Disable all fields
                        isSubmitted = true
                    }
                },
                enabled = !isSubmitted,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
            ) {
                Text(text = "Submit", fontSize = 16.sp)
            }

        }
    }
}


 */