package ui.components.native

import android.annotation.SuppressLint
import android.view.ViewGroup
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.viewinterop.AndroidView


@Composable
@SuppressLint("SetJavaScriptEnabled")
fun AndroidWebView(url: String, modifier: Modifier) {

    val context = LocalContext.current

    AndroidView(
        factory = {
            WebView(it).apply {
                settings.javaScriptEnabled = true
                layoutParams = ViewGroup.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.MATCH_PARENT
                )
                webViewClient = object : WebViewClient() {
                    override fun shouldOverrideUrlLoading(
                        view: WebView?,
                        request: WebResourceRequest?
                    ): Boolean = false
                }
            }
        },
        update = { webView ->
            webView.loadUrl(url)
        },
        modifier = modifier
    )
}