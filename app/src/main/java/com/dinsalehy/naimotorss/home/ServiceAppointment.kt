package com.dinsalehy.naimotorss.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.dinsalehy.naimotorss.R



@Composable
fun ServiceAppointment(navController: NavController) {
    Box(
        modifier = Modifier
            .padding(horizontal = 6.dp)
            .fillMaxWidth()
            .height(250.dp)
            .clip(RoundedCornerShape(5.dp))
    ) {
        Image(
            painter = painterResource(id = R.drawable.service),
            contentDescription = "Service Image",
            contentScale = ContentScale.Crop,
            modifier = Modifier.matchParentSize()
        )

        Column(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 25.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Book A Service With Us",
                color = Color.White,
                fontSize = 19.sp,
                fontWeight = FontWeight.Bold,
                style = TextStyle(
                    shadow = Shadow(
                        color = Color.Black,
                        offset = Offset(3f, 3f),
                        blurRadius = 6f
                    )
                )
            )

            Spacer(modifier = Modifier.height(6.dp))

            Button(
                onClick = { navController.navigate("service_appointment_form") },
                modifier = Modifier.fillMaxWidth(0.6f),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFFE4A95D),
                    contentColor = Color.Black
                ),
              //  shape = RoundedCornerShape(12.dp)
            ) {
                Text(
                    text = "BOOK APPOINTMENT",
                        fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                )
            }
        }
    }
}



@Preview(showBackground = true)
@Composable
fun ServiceAppointmentPreview() {
    val navController = rememberNavController()
    ServiceAppointment(navController = navController)
}