package com.ekspensify.app.ai

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun AIChatScreen(viewModel: AzureAiViewModel = viewModel()) {
    val loading by viewModel.loading.collectAsState()
    val response by viewModel.response.collectAsState()
    var input by remember { mutableStateOf("") }

    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        BasicTextField(value = input, onValueChange = { input = it }, modifier = Modifier
            .fillMaxWidth()
            .height(120.dp))

        Spacer(modifier = Modifier.height(12.dp))

        Button(onClick = { if (input.isNotBlank()) viewModel.sendPrompt(input) }) {
            Text(text = "Send")
        }

        Spacer(modifier = Modifier.height(12.dp))

        if (loading) {
            CircularProgressIndicator()
        }

        Spacer(modifier = Modifier.height(12.dp))

        Text(text = response ?: "No response yet")
    }
}
