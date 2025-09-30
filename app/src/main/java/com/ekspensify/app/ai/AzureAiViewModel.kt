package com.ekspensify.app.ai

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class AzureAiViewModel : ViewModel() {
    private val repo = AzureOpenAIRepository()

    private val _response = MutableStateFlow<String?>(null)
    val response: StateFlow<String?> = _response

    private val _loading = MutableStateFlow(false)
    val loading: StateFlow<Boolean> = _loading

    fun sendPrompt(prompt: String) {
        viewModelScope.launch {
            _loading.value = true
            val messages = listOf(ChatMessage("system", "You are Ekspensify assistant."), ChatMessage("user", prompt))
            val resp = repo.chat(messages, maxTokens = 1024)
            _response.value = resp?.choices?.firstOrNull()?.message?.content
            _loading.value = false
        }
    }
}
