package com.dinsalehy.naimotorss.contact_us

data class ContactFormState(
    val name: String = "",
    val email: String = "",
    val phone: String = "",
    val message: String = "",
    val nameError: String = "",
    val emailError: String = "",
    val phoneError: String = "",
    val messageError: String = "",
    val isSubmitted: Boolean = false
)