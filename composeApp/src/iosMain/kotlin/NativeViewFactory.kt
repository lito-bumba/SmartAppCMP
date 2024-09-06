import platform.UIKit.UIViewController

interface NativeViewFactory {

    fun createWebView(
        url: String
    ): UIViewController
}