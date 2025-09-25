package com.ekspensify.app.ui.dashboard.profile

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ekspensify.app.utils.spUtils.SpUtilsManager
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LanguageViewModel @Inject constructor(
    private val spUtilsManager: SpUtilsManager
) : ViewModel() {

    val languagePreference = spUtilsManager.languagePreference.stateIn(
        scope = viewModelScope,
        started = SharingStarted.Eagerly,
        initialValue = "system"
    )

    fun updateLanguage(language: String) {
        viewModelScope.launch {
            spUtilsManager.updateLanguagePreference(language)
        }
    }
}
