package com.dinsalehy.naimotorss.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dinsalehy.naimotorss.R
import com.dinsalehy.naimotorss.ui.theme.PrimaryColor
import com.dinsalehy.naimotorss.ui.theme.SecondaryColor

@Composable
fun FooterSection() {
    Column(
        modifier = Modifier
            .padding(start = 5.dp, end = 5.dp, bottom = 5.dp)
            .fillMaxWidth()
            .clip(RoundedCornerShape(
                topStart = 5.dp,
                topEnd = 5.dp,
                bottomStart = 16.dp,  // Android phone bottom edge, often 16.dp to 28.dp depending on the design.
                bottomEnd = 16.dp))
            .background(PrimaryColor),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // === Map Section ===
        Image(
            painter = painterResource(id = R.drawable.bg_map_location),
            contentDescription = "Footer Map",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)

        )

        Spacer(modifier = Modifier.height(8.dp))

        // === Address Text ===
        Text(
            text = "We are conveniently located at \n22 Church St. Ajax, ON, A2N P3M",
            textAlign = TextAlign.Center,
            fontSize = 14.sp,
            color = SecondaryColor,
            fontWeight = FontWeight.Bold
        )

        // === Divider ===
        Divider(
            color = Color.Cyan,
            thickness = 0.3.dp,
            modifier = Modifier
                .padding(vertical = 10.dp)
                .fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(2.dp))
        // === Footer Content (Contacts & Icons) ===
        ContactNumbers()
    }
}


@Composable
fun ContactNumbers() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            //.padding(10.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            FooterContactItem("Sales:", "905-344 1234" , true )
            FooterContactItem("Service:", "905-344 1234" , true )
            FooterContactItem("Parts:", "905-344 1234" , false )
        }

       // Spacer(modifier = Modifier.height(3.dp))

        CopyrightFooter()
    }
}



@Composable
fun FooterContactItem(label: String, number: String, showDivider: Boolean = true) {
    Row(
        modifier = Modifier.padding(horizontal = 4.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = "$label $number",
            color = SecondaryColor,
            fontWeight = FontWeight.Bold,
            fontSize = 11.sp
        )

        if (showDivider) {
            Spacer(modifier = Modifier.width(10.dp))
            Text(
                text = "|",
                color = SecondaryColor,
                fontWeight = FontWeight.Bold,
                fontSize = 12.sp

            )
            //Spacer(modifier = Modifier.width(6.dp))
        }
    }
}


@Composable
fun CopyrightFooter() {
    Text(
        text = "© 2025 Nai Motors Inc. All rights reserved.",
        fontSize = 14.sp,
        fontWeight = FontWeight.Bold,
        color = SecondaryColor,
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 6.dp, bottom = 10.dp),
        textAlign = TextAlign.Center
    )
}


@Preview(showBackground = true)
@Composable
fun FooterSection2Preview() {
    Surface(modifier = Modifier.fillMaxSize(), color = PrimaryColor) {
        FooterSection()
    }
}