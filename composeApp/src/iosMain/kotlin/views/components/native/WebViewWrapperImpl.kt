package views.components.native

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.interop.UIKitViewController
import kotlinx.cinterop.ExperimentalForeignApi
import platform.UIKit.UIViewController

class WebViewWrapperImpl(
    private val webViewFactory: (url: String) -> UIViewController
) : WebViewWrapper {

    @OptIn(ExperimentalForeignApi::class)
    @Composable
    override fun WebViewKit(url: String, modifier: Modifier) {
        UIKitViewController(
            modifier = modifier,
            factory = { webViewFactory(url) },
            update = {}
        )
    }
}