package com.ekspensify.app.ui.dashboard.profile

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.ekspensify.app.R

@Composable
fun LanguageScreen(navController: NavController, viewModel: LanguageViewModel = hiltViewModel()) {
    val lang by viewModel.languagePreference.collectAsState()

    Column(modifier = Modifier.padding(16.dp)) {
        Text(text = stringResource(R.string.select_language), style = MaterialTheme.typography.titleMedium)
        LanguageOption(label = stringResource(R.string.language_system), value = "system", selected = lang == "system") {
            viewModel.updateLanguage(it)
        }
        LanguageOption(label = stringResource(R.string.language_english), value = "en", selected = lang == "en") {
            viewModel.updateLanguage(it)
        }
        LanguageOption(label = stringResource(R.string.language_thai), value = "th", selected = lang == "th") {
            viewModel.updateLanguage(it)
        }
    }
}

@Composable
private fun LanguageOption(label: String, value: String, selected: Boolean, onSelect: (String) -> Unit) {
    androidx.compose.foundation.layout.Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onSelect(value) }
            .padding(vertical = 12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        RadioButton(selected = selected, onClick = { onSelect(value) })
        Text(text = label, modifier = Modifier.padding(start = 12.dp))
    }
}
