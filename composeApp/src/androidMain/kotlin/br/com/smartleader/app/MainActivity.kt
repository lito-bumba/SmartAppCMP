package br.com.smartleader.app

import App
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import views.components.native.WebViewWrapperImpl

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            App(webViewWrapper = WebViewWrapperImpl())
        }
    }
}

@Preview
@Composable
fun AppAndroidPreview() {
    App(WebViewWrapperImpl())
}