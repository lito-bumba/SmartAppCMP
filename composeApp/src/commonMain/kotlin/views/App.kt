package views

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import org.jetbrains.compose.ui.tooling.preview.Preview
import views.components.native.WebViewWrapper
import views.main_screen.MainScreen

@Composable
@Preview
fun App(
    webViewWrapper: WebViewWrapper
) {
    MaterialTheme {
        val navController = rememberNavController()

        NavHost(
            navController = navController,
            startDestination = AppScreen.Initial.name,
            modifier = Modifier.fillMaxSize()
        ) {
            composable(route = AppScreen.Initial.name) {
                MainScreen(navController)
            }
            composable(route = AppScreen.WebView.name) {
                WebViewScreen(
                    webViewKit = {
                        webViewWrapper.WebViewKit(
                            url = "https://touchlab.co",
                            modifier = Modifier.fillMaxSize()
                        )
                    },
                    onBack = { navController.popBackStack() }
                )
            }
        }
    }
}

enum class AppScreen { Initial, WebView }