package com.dinsalehy.naimotorss.nav_setup

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.dinsalehy.naimotorss.about.AboutUsScreen
import com.dinsalehy.naimotorss.contact_us.ContactUsScreen
import com.dinsalehy.naimotorss.home.HomeScreen
import com.dinsalehy.naimotorss.new_inventory.NewInventoryScreen
import com.dinsalehy.naimotorss.pre_owned_vehicles.PreOwnedVehicleScreen
import com.dinsalehy.naimotorss.service.ServiceAppointmentForm

@Composable
fun NavigationSetup(navController: NavHostController, modifier: Modifier = Modifier) {
    NavHost(navController = navController, startDestination = "home", modifier = modifier) {
        composable("home") { HomeScreen(navController) }
        composable("about_us") { AboutUsScreen(navController) }
        composable("new_inventory") { NewInventoryScreen(navController) }
        composable("pre_owned_vehicle") {PreOwnedVehicleScreen(navController) }
        composable("service_appointment") { ServiceAppointmentForm(navController) }
        composable("service_appointment_form") { ServiceAppointmentForm(navController) }
        composable("contact_us") { ContactUsScreen(navController) }

    }
}
