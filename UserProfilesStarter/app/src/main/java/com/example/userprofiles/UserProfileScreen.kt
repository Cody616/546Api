package com.example.userprofiles

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun UserProfileScreen(viewModel: UserViewModel = viewModel()) {
    val user by viewModel.user.collectAsState()
    val loading by viewModel.loading.collectAsState()
    val error by viewModel.error.collectAsState()

    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        when {
            loading -> {
                CircularProgressIndicator()
            }

            error != null -> {
                Text(text = error!!, fontSize = 16.sp, color = Color.Red)
                Button(onClick = { viewModel.fetchRandomUser() }) {
                    Text(text = "Load New User")
                }
            }

            user != null -> {
                AsyncImage(
                    model = user!!.url,
                    contentDescription = "Random Duck",
                    modifier = Modifier.size(200.dp).clip(CircleShape)
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = user!!.message ?: "Here's a random duck 🦆",
                    fontSize = 16.sp,
                    color = Color.Gray
                )
                Spacer(modifier = Modifier.height(16.dp))
                Button(onClick = { viewModel.fetchRandomUser() }) {
                    Text(text = "Load New User")
                }
            }
        }
    }
}
