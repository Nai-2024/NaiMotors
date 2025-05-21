package com.dinsalehy.naimotorss.contact_us

import android.util.Log
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class ContactUsViewModel : ViewModel() {

    private val formStateMutable = MutableStateFlow(ContactFormState())
    val formState: StateFlow<ContactFormState> = formStateMutable

    fun onNameChanged(newValue: String) {
        formStateMutable.value = formStateMutable.value.copy(
            name = newValue,
            nameError = validateName(newValue)
        )
    }

    fun onEmailChanged(newValue: String) {
        formStateMutable.value = formStateMutable.value.copy(
            email = newValue,
            emailError = validateEmail(newValue)
        )
    }

    fun onPhoneChanged(newValue: String) {
        formStateMutable.value = formStateMutable.value.copy(
            phone = newValue,
            phoneError = validatePhone(newValue)
        )
    }

    fun onMessageChanged(newValue: String) {
        formStateMutable.value = formStateMutable.value.copy(
            message = newValue,
            messageError = validateMessage(newValue)
        )
    }

    fun submitForm(): Boolean {
        return try {
            val current = formStateMutable.value

            val nameError = validateName(current.name)
            val emailError = validateEmail(current.email)
            val phoneError = validatePhone(current.phone)
            val messageError = validateMessage(current.message)

            val hasError = listOf(nameError, emailError, phoneError, messageError).any { it.isNotEmpty() }

            if (hasError) {
                formStateMutable.value = current.copy(
                    nameError = nameError,
                    emailError = emailError,
                    phoneError = phoneError,
                    messageError = messageError
                )
                false
            } else {
                formStateMutable.value = ContactFormState(isSubmitted = true)
                true
            }
        } catch (e: Exception) {
            Log.e("ContactUsViewModel", "Form submission failed", e)
            false
        }
        }
    }

    private fun validateName(name: String): String {
        return when {
            name.isBlank() -> "Name is required"
            !name.matches(Regex("^[a-zA-Z ]+$")) -> "Name can only contain letters"
            else -> ""
        }
    }

    private fun validateEmail(email: String): String =
        if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) "Invalid email" else ""

    private fun validatePhone(phone: String): String {
        return when {
            phone.isBlank() -> "Phone is required"
            !phone.matches(Regex("^\\d{10,}$")) -> "Phone must be at least 10 digits and contain only numbers"
            else -> ""
        }
    }

    private fun validateMessage(message: String): String =
        if (message.isBlank()) "Message cannot be empty" else ""


/*
data class ContactFormValidationData(
    val isNameValid: Boolean,
    val nameError: String = "",
    val isEmailValid: Boolean,
    val emailError: String = "",
    val isPhoneValid: Boolean,
    val phoneError: String = "",
    val isMessageValid: Boolean,
    val messageError: String = ""
)

fun validateContactForm(name: String, email: String, phone: String, message: String): ContactFormValidationData {
    val isNameValid = name.isNotBlank() && name.all { it.isLetter() || it.isWhitespace() }
    val nameError = when {
        name.isBlank() -> "Full name cannot be empty"
        !name.all { it.isLetter() || it.isWhitespace() } -> "Only letters and spaces allowed"
        else -> ""
    }

    val isEmailValid = email.isNotBlank() && Patterns.EMAIL_ADDRESS.matcher(email).matches()
    val emailError = when {
        email.isBlank() -> "Email cannot be empty"
        !Patterns.EMAIL_ADDRESS.matcher(email).matches() -> "Invalid email format"
        else -> ""
    }

    val phoneRegex = "^[0-9\\-\\s]*$"  // Regex to allow digits, spaces, and hyphens
    val isPhoneValid = phone.isNotBlank() && phone.matches(Regex(phoneRegex))
    val phoneError = when {
        phone.isBlank() -> "Phone number cannot be empty"
        !phone.matches(Regex(phoneRegex)) -> "Only numbers, spaces, and hyphens are allowed"
        else -> ""
    }

    val isMessageValid = message.isNotBlank()
    val messageError = when {
        message.isBlank() -> "Message cannot be empty"
        else -> ""
    }

    return ContactFormValidationData(
        isNameValid = isNameValid,
        nameError = nameError,
        isEmailValid = isEmailValid,
        emailError = emailError,
        isPhoneValid = isPhoneValid,
        phoneError = phoneError,
        isMessageValid = isMessageValid,
        messageError = messageError
    )
}



 */