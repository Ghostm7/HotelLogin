package com.example.hotelloginsystem.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.hotelloginsystem.R
import com.example.hotelloginsystem.nav.Screens

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DashboardScreen(navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Hotel Dashboard") },
                navigationIcon = {
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(Icons.Default.Menu, contentDescription = "Hamburger Menu")
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    titleContentColor = Color.White,
                    navigationIconContentColor = Color.White
                )
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            // Hotel logo
            Image(
                modifier = Modifier
                    .size(100.dp)
                    .clip(CircleShape),
                painter = painterResource(R.drawable.attack_6806140_1280),
                contentDescription = "Hotel Logo"
            )
            Spacer(modifier = Modifier.height(20.dp))

            // Cards layout
            Column(
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                DashboardCard(title = "Today's Bookings", content = "25 Rooms Booked")
                DashboardCard(title = "Recent Activity", content = "Check-in completed for Room 102\nRoom service requested for Room 210")
                DashboardCard(title = "Upcoming Check-outs", content = "10 Rooms to Check-out Today")
                DashboardCard(title = "Staff on Duty", content = "5 Staff Members Currently on Duty")
            }

            Spacer(modifier = Modifier.height(30.dp))

            // Navigate back to main screen
            Button(onClick = { navController.navigate(Screens.MainScreen.route) }) {
                Text(text = "Go Back")
            }
        }
    }
}

@Composable
fun DashboardCard(title: String, content: String) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        elevation = CardDefaults.cardElevation(8.dp)
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
        ) {
            Text(
                text = title,
                style = MaterialTheme.typography.bodyLarge,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = content,
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}
