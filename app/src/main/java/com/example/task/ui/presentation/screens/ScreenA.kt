package com.example.task.ui.presentation.screens

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.task.Core.data.Viewmodel.UserViewModel
import com.example.task.Core.data.models.User
import com.example.task.Core.data.models.Users

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScreenA(viewModel: UserViewModel) {

    val users by viewModel.users.collectAsState()
    val user by viewModel.user.collectAsState()


    LaunchedEffect(Unit) {
        viewModel.getAllUsers()
    }

    LaunchedEffect(user) {
        Log.d("7326482738922", "ScreenA: User: $user")
    }

    Scaffold(
        topBar = {
            TopAppBar(title = { Text("User List") })
        }
    ) {
        LazyColumn(contentPadding = it) {
            itemsIndexed(users) {index, user ->
                UserListItem(user = user){
                    viewModel.getUserById(index + 1)
                }
            }
        }
    }
}

@Composable
fun UserListItem(user: User, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable { onClick() },
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = "Name: $user.", style = MaterialTheme.typography.titleMedium)
            Text(text = "Email: ${user.email}", style = MaterialTheme.typography.bodyMedium)
        }
    }
}