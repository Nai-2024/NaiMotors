package com.dinsalehy.naimotorss.about

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import com.dinsalehy.naimotorss.R
import com.dinsalehy.naimotorss.home.FooterSection
import com.dinsalehy.naimotorss.home.HeaderSection
import com.dinsalehy.naimotorss.ui.theme.PrimaryColor
import com.dinsalehy.naimotorss.ui.theme.SecondaryColor

@Composable
fun AboutUsScreen(navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFA09999))
           // .verticalScroll(rememberScrollState())
    ) {
        // Fixed Header
        HeaderSection(navController)

        // Scrollable Content Below the Header
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .verticalScroll(rememberScrollState())
                .padding(top = 86.dp) // Push content below the fixed header
        ) {
            Image(
                painter = painterResource(id = R.drawable.bg_main),
                contentDescription = "About Us Background image",
                contentScale = ContentScale.Crop, // Fill width, crop excess sides
                alignment = Alignment.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(230.dp)
            )
            Spacer(modifier = Modifier.padding(bottom = 3.dp))

            SectionBox(
                title = "About Us",
                description = "At Nai Motors, we’re more than just a car dealership. We’re your trusted partner in finding the perfect vehicle to match your lifestyle, needs, and budget. Whether you’re buying your first car, upgrading your ride, or expanding your fleet, Nai Motors is committed to delivering top-notch service and unbeatable value."
            )
            SectionBox(
                title = "Who We Are?",
                description = "Founded with a passion for automobiles and a mission to make car buying simple and stress-free, Nai Motors has grown into a trusted name in the automotive industry. We specialize in both new and pre-owned vehicles and take pride in our transparent, customer-first approach. Our team brings years of experience, industry knowledge, and a genuine love for cars to help you make informed decisions. We believe that every vehicle tells a story — and we’re here to help you start yours."
            )
            SectionBox(
                title ="What We Offer",
                description =
                    "- Quality New & Used Vehicles:\n" +
                            "  Thoroughly inspected, competitively priced.\n" +
                            "- Financing Solutions:\n" +
                            "  Flexible plans to suit every budget and credit profile.\n" +
                            "- Trade-In Services:\n" +
                            "  Get the best value for your current vehicle.\n" +
                            "- Friendly Support:\n" +
                            "  No pressure — just honest advice and helpful guidance."
            )
            SectionBox(
                title = "Why Choose Nai Motors?",
                description =
                    "- ✅ Transparent pricing with no hidden fees.\n" +
                            "- ✅ Expert team passionate about what they do.\n" +
                            "- ✅ Focus on customer satisfaction and long-term relationships.\n" +
                            "- ✅ Wide selection of makes and models"
            )
            Spacer(modifier = Modifier.padding(bottom = 6.dp))
            FooterSection()
        }

    }
}

@Composable
fun SectionBox(title: String, description: String) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
           .padding(top = 3.dp, start = 4.dp, end = 4.dp),
        colors = CardDefaults.cardColors(containerColor = PrimaryColor),
        shape = RoundedCornerShape(5.dp)
    ) {
        Column(modifier = Modifier.padding(13.dp)) {
            Text(
                text = title,
                style = MaterialTheme.typography.titleMedium,
                color = SecondaryColor
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = description,
                style = MaterialTheme.typography.bodyMedium,
                color = SecondaryColor
            )
        }
    }
}
