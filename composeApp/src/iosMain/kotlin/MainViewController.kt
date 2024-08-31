import androidx.compose.ui.window.ComposeUIViewController
import platform.UIKit.UIViewController
import views.components.native.WebViewWrapperImpl

fun MainViewController(
    webViewFactory: () -> UIViewController
) = ComposeUIViewController {
    val webViewWrapper = WebViewWrapperImpl(webViewFactory)
    App(webViewWrapper = webViewWrapper)
}