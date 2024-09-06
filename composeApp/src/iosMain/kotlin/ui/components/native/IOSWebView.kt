package ui.components.native

import LocalNativeViewFactory
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.interop.UIKitViewController
import kotlinx.cinterop.ExperimentalForeignApi

@OptIn(ExperimentalForeignApi::class)
@Composable
internal fun WebViewKit(
    url: String,
    modifier: Modifier
) {
    val factory = LocalNativeViewFactory.current

    UIKitViewController(
        modifier = modifier,
        factory = { factory.createWebView(url) }
    )
}