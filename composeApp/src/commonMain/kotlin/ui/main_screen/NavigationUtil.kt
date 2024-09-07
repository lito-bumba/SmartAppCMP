package ui.main_screen

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AppsOutage
import androidx.compose.material.icons.filled.Group
import androidx.compose.material.icons.filled.Home
import androidx.compose.ui.graphics.vector.ImageVector

enum class NavigationUtil (
    val title: String,
    val icon: ImageVector,
    val route: String
) {
    HOME("Home", Icons.Default.Home, "home"),
    GOOGLE("Google", Icons.Default.Group, "https://google.com"),
    TOUCH_LAB("TouchLab", Icons.Default.Group, "https://touchlab.co"),
    WHATSAPP("WhatsApp", Icons.Default.AppsOutage, "https://web.whatsapp.com"),
}