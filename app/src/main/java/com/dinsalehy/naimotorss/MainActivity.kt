package com.dinsalehy.naimotorss

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.dinsalehy.naimotorss.nav_setup.NavigationSetup
import com.dinsalehy.naimotorss.ui.theme.NaiMotorssTheme
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NaiMotorssTheme {
                val navController = rememberNavController()
                Scaffold(
                    contentWindowInsets = WindowInsets(0.dp) // removes default padding
                ) { innerPadding ->
                    NavigationSetup(
                        navController = navController,
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

