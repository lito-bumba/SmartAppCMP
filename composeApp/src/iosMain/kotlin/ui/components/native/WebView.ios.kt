package ui.components.native

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
actual fun WebView(url: String, modifier: Modifier) {
    WebViewKit(
        url = url,
        modifier = modifier
    )
}