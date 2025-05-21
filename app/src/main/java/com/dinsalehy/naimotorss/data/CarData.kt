package com.dinsalehy.naimotorss.data

import com.dinsalehy.naimotorss.R

data class Car(
    val year: Int,
    val make: String,
    val model: String,
    val bodyStyle: String? = null,         // Optional for used cars
    val engineType: String? = null,        // Optional
    val exteriorColor: String? = null,     // Optional
    val interiorColor: String? = null,     // Optional
    val price: Double,
    val imageResourceId: Int,
    val mileage: Int? = null               // Only for used cars
)

val newCars = listOf(
    Car(2025, "Toyota", "GR Supra", "Coupe", "Hybrid", "Black", "Dark Gray", 90000.0, R.drawable.car_6),
    Car(2024, "Porsche", "911", "Coupe", "Gasoline", "Yellow", "Dark Gray", 120000.0, R.drawable.car_2),
    Car(2025, "Chevrolet", "Thunder", "Pickup Truck", "Hybrid", "Black", "Dark Gray", 170000.0, R.drawable.car_4),
    Car(2025, "Mercedes-Benz", "C-Class", "Sedan", "Electric", "White", "Dark Gray", 70000.0, R.drawable.car_7),
    Car(2023, "Porsche", "Panamera", "Sedan", "Gasoline", "Yellow", "Dark Gray", 70000.0, R.drawable.car_8),
    Car(2023, "Jeep", "Compass", "SUV", "Hybrid", "Black", "Dark Gray", 80000.0, R.drawable.car_11),
    Car(2025, "Mercedes-Benz", "E-Class", "Sedan", "Gasoline", "Red", "Dark Gray", 70000.0, R.drawable.car_12),
)

object FilterData {
    val years = listOf("2025", "2024", "2023")
    val makes = listOf("Toyota", "Porsche", "Jeep", "Chevrolet", "Mercedes-Benz")
    val models = listOf("GR Supra", "911", "Thunder", "C-Class", "Panamera", "Compass", "E-Class")
    val engineTypes = listOf(  "Hybrid", "Gasoline", "Electric")
}


val showroomImages = listOf(
    R.drawable.car_6,
    R.drawable.car_2,
    R.drawable.car_12,
    R.drawable.car_4,
    R.drawable.car_8,
    R.drawable.car_7,
    R.drawable.car_11,
)
