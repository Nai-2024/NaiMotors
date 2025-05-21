package com.dinsalehy.naimotorss.service

data class ServiceFormValidationData(
    val isNameValid: Boolean = true,
    val isVehicleValid: Boolean = true,
    val nameError: String = "",
    val vehicleError: String = "",
    val isFormValid: Boolean = false
)


fun validateServiceAppointmentForm(
    name: String,
    vehicle: String
): ServiceFormValidationData {
    var nameError = ""
    var vehicleError = ""
    var isNameValid = true
    var isVehicleValid = true

    val nameRegex = "^[A-Za-z ]+$".toRegex()
    val vehicleRegex = "^[A-Za-z0-9 ]+$".toRegex()

    if (name.isBlank()) {
        isNameValid = false
        nameError = "Name is required"
    } else if (!name.matches(nameRegex)) {
        isNameValid = false
        nameError = "Name must contain letters only"
    }

    if (vehicle.isBlank()) {
        isVehicleValid = false
        vehicleError = "Vehicle is required"
    } else if (!vehicle.matches(vehicleRegex)) {
        isVehicleValid = false
        vehicleError = "Vehicle must contain only letters and numbers"
    }

    return ServiceFormValidationData(
        isNameValid = isNameValid,
        isVehicleValid = isVehicleValid,
        nameError = nameError,
        vehicleError = vehicleError,
        isFormValid = isNameValid && isVehicleValid
    )
}