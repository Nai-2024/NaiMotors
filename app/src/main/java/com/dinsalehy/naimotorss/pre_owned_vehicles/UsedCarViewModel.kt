package com.dinsalehy.naimotorss.pre_owned_vehicles


import androidx.lifecycle.ViewModel
import com.dinsalehy.naimotorss.R
import com.dinsalehy.naimotorss.data.Car


class UsedCarViewModel : ViewModel() {
    val usedCarList = listOf(
        Car(year = 2015, make = "Toyota", model = "Corolla", exteriorColor = "Silver", price = 10400.00, mileage = 15000, imageResourceId = R.drawable.corolla_2015),
        Car(year = 2012, make = "Honda", model = "Civic", exteriorColor = "White", price = 12500.00, mileage = 12000, imageResourceId = R.drawable.hond_2012),
        Car(year = 2022, make = "Ford", model = "Focus", exteriorColor = "Red", price = 8900.00, mileage = 18000, imageResourceId = R.drawable.ford_2022),
        Car(year = 1994, make = "Jeep", model = "Thunder", exteriorColor = "Army Green", price = 9200.00, mileage = 122000, imageResourceId = R.drawable.jeep_1994
        )
    )
}

