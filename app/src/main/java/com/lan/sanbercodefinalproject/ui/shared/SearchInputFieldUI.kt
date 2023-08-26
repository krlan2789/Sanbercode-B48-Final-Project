package com.lan.sanbercodefinalproject.ui.shared

import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.lan.sanbercodefinalproject.ui.theme.SanbercodeFinalProjectTheme

@Composable
fun SearchInputFieldUI(placeHolder: String = "Search", modifier: Modifier = Modifier, onValueChange: (String) -> Unit = {}) {
    CustomTextField(
        onValueChange = onValueChange,
        modifier = modifier.height(40.dp).clip(RoundedCornerShape(32.dp)),
        placeholderText = placeHolder,
        leadingIcon = { Icon(imageVector = Icons.Default.Search, contentDescription = null, tint = MaterialTheme.colorScheme.secondary, modifier = Modifier.height(32.dp).padding(start = 8.dp).aspectRatio(1f)) },
        keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Search)
    )
}

@Preview
@Composable
private fun Preview() {
    SanbercodeFinalProjectTheme {
        SearchInputFieldUI()
    }
}