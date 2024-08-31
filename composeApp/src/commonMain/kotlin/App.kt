import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import smartapp.composeapp.generated.resources.Res
import smartapp.composeapp.generated.resources.compose_multiplatform
import views.WebViewScreen
import views.components.native.WebViewWrapper

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
                .verticalScroll(rememberScrollState())
        ) {
            composable(route = AppScreen.Initial.name) {
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    var showContent by remember { mutableStateOf(false) }

                    Spacer(Modifier.height(16.dp))
                    Button(onClick = {
                        navController.navigate(AppScreen.WebView.name)
                    }) {
                        Text("WebView Screen")
                    }
                    Spacer(Modifier.height(16.dp))
                    Button(onClick = { showContent = !showContent }) {
                        Text("Click me!")
                    }
                    AnimatedVisibility(showContent) {
                        val greeting = remember { Greeting().greet() }
                        Column(
                            Modifier.fillMaxWidth(),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Image(painterResource(Res.drawable.compose_multiplatform), null)
                            Text("Compose: $greeting")
                        }
                    }
                }
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