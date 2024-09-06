package ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import org.jetbrains.compose.ui.tooling.preview.Preview
import ui.main_screen.MainScreen

@Composable
@Preview
fun App() {
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
                    url = "https://touchlab.co",
                    onBack = { navController.popBackStack() }
                )
            }
        }
    }
}

enum class AppScreen { Initial, WebView }