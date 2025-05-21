package com.dinsalehy.naimotorss.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import androidx.navigation.NavController
import com.dinsalehy.naimotorss.R
import com.dinsalehy.naimotorss.ui.theme.PrimaryColor
import com.dinsalehy.naimotorss.ui.theme.SecondaryColor


@Composable
fun HeaderSection(
    navController: NavController,
    modifier: Modifier = Modifier
) {
    var expanded by remember { mutableStateOf(false) }

    // This Box ensures TopBarSection stays fixed
    Box(modifier = Modifier
        .fillMaxWidth()
        .zIndex(1f)) {
        TopBarSection(
            expanded = expanded,
            onToggleMenu = { expanded = !expanded },
            navController = navController,
            onDismiss = { expanded = false }
        )
    }

    // Add spacing below so content doesn’t overlap it
    //Spacer(modifier = Modifier.height(90.dp)) // Same as TopBarSection height
}

/*
@Composable
fun HeaderSection(
    navController: NavController,
    modifier: Modifier
) {
    var expanded by remember { mutableStateOf(false) }

    TopBarSection(
        expanded = expanded,
        onToggleMenu = { expanded = !expanded },
        navController = navController,
        onDismiss = { expanded = false }
    )
}
 */


// Fixed top bar section that holds, logo, text and hamburger icon
@Composable
fun TopBarSection(
    expanded: Boolean,
    onToggleMenu: () -> Unit,
    navController: NavController,
    onDismiss: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(90.dp)
            .background(PrimaryColor)
            .padding(12.dp),
           // .zIndex(1f),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Logo
        Image(
            painter = painterResource(id = R.drawable.logo_naimotors),
            contentDescription = "Nai Motors Logo",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(50.dp)
                .clip(CircleShape)
                .background(Color.LightGray)
        )

        // Title
        // Text in the center
        Text(
            text = "Nai Motors",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = SecondaryColor
        )

        // Hamburger Icon
        Box {
            IconButton(
                onClick = onToggleMenu,
                modifier = Modifier.size(50.dp)
            ) {
                Icon(
                    imageVector = if (expanded) Icons.Filled.Close else Icons.Filled.Menu,
                    contentDescription = if (expanded) "Close Menu" else "Open Menu",
                    modifier = Modifier.size(60.dp),
                    tint = Color(0xFFD3D3D3)
                )
            }

            // DROPDOWN MENU
            DropdownMenu(
                expanded = expanded,
                onDismissRequest = onDismiss,
                modifier = Modifier.width(230.dp),
                offset = DpOffset(x = 11.dp, y = 19.dp)
            ) {
                val menuItems = listOf(
                    "Home" to "home",
                    "About Us" to "about_us",
                    "New Inventory" to "new_inventory",
                    "Pre-Owned Vehicles" to "pre_owned_vehicle",
                    "Service Appointment" to "service_appointment",
                    "Contact Us" to "contact_us"
                )
                menuItems.forEach { (title, route) ->
                    DropdownMenuItem(
                        text = { Text(title) },
                        onClick = {
                            onDismiss()
                            navController.navigate(route)
                        }
                    )
                }
            }
        }
    }
}

// Header bkg img
@Composable
fun MainBackgroundImageSection() {
    Image(
        painter = painterResource(id = R.drawable.bkg_1),
        contentDescription = "Home Background image",
        contentScale = ContentScale.Crop, // Fill width, crop excess sides
        alignment = Alignment.Center,
        modifier = Modifier
            .fillMaxWidth()
            .height(330.dp)
            .aspectRatio(1.25f) // Maintain 3:1 ratio (width:height)
           .padding(top = 85.dp)
    )
}


/*
@Composable
fun HeaderSection(
    navController: NavController,
    showBackground: Boolean = true,
    modifier: Modifier
) {
    var expanded by remember { mutableStateOf(false) }

    Box(modifier = Modifier.fillMaxWidth()) {
        TopBarSection(
            expanded = expanded,
            onToggleMenu = { expanded = !expanded },
            navController = navController,
            onDismiss = { expanded = false }
        )

        //  Condition to display on/off the main bkg image across different screens
        if (showBackground) {
            MainBackgroundImageSection()
        }
    }
}
 */