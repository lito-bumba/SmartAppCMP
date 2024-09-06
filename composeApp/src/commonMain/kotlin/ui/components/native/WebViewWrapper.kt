package ui.components.native

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

interface WebViewWrapper {

    @Composable
    fun WebViewKit(
        url: String,
        modifier: Modifier
    )
}