package ui.components.native

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
expect fun WebView(
    url: String,
    modifier: Modifier = Modifier
)