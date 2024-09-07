package ui.main_screen

import Greeting
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.BrokenImage
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Button
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import kotlinx.coroutines.launch
import org.jetbrains.compose.resources.painterResource
import smartapp.composeapp.generated.resources.Res
import smartapp.composeapp.generated.resources.compose_multiplatform
import ui.AppScreen
import ui.components.native.WebView

@Composable
fun MainScreen(
    navController: NavController
) {
    val scope = rememberCoroutineScope()
    val drawerNavController = rememberNavController()
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    var selectedItem: NavigationUtil by remember { mutableStateOf(NavigationUtil.HOME) }

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet(
                modifier = Modifier
                    .fillMaxWidth(.75f)
                    .fillMaxHeight()
            ) {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "Smart App",
                        fontSize = 24.sp,
                        fontWeight = FontWeight.ExtraBold,
                        modifier = Modifier.padding(16.dp)
                    )
                    HorizontalDivider(
                        thickness = 3.dp,
                        color = Color.Blue
                    )

                    NavigationUtil.entries.toTypedArray().forEach { navItem ->
                        NavigationDrawerItem(
                            icon = {
                                Image(
                                    imageVector = navItem.icon,
                                    contentDescription = navItem.title
                                )
                            },
                            label = {
                                Text(
                                    text = navItem.title,
                                    color = MaterialTheme.colorScheme.onBackground,
                                    fontWeight = FontWeight.W400
                                )
                            },
                            selected = navItem == selectedItem,
                            onClick = {
                                selectedItem = navItem
                                scope.launch { drawerState.close() }
                                drawerNavController.navigate(navItem.route)
                            }
                        )
                    }
                }
            }
        }
    ) {
        Scaffold(
            topBar = {
                MainScreenTopBar {
                    scope.launch {
                        drawerState.apply {
                            if (isClosed) open() else close()
                        }
                    }
                }
            }
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(it)
            ) {
                NavHost(
                    navController = drawerNavController,
                    startDestination = NavigationUtil.HOME.route
                ) {
                    composable(route = NavigationUtil.HOME.route) {
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
                            IconButton(onClick = {
                                scope.launch {
                                    drawerState.apply {
                                        if (isClosed) open() else close()
                                    }
                                }
                            }) {
                                Icon(
                                    imageVector = Icons.Default.BrokenImage,
                                    contentDescription = null
                                )
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

                    composable(NavigationUtil.GOOGLE.route) {
                        WebView(
                            url = selectedItem.route,
                            modifier = Modifier.fillMaxSize()
                        )
                    }

                    composable(NavigationUtil.TOUCH_LAB.route) {
                        WebView(
                            url = selectedItem.route,
                            modifier = Modifier.fillMaxSize()
                        )
                    }

                    composable(NavigationUtil.WHATSAPP.route) {
                        WebView(
                            url = selectedItem.route,
                            modifier = Modifier.fillMaxSize()
                        )
                    }
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun MainScreenTopBar(
    onMenuIconClick: () -> Unit
) {
    TopAppBar(
        title = {
            Text(
                text = "SmartApp",
                fontWeight = FontWeight.SemiBold,
                style = MaterialTheme.typography.titleLarge,
                color = Color.White
            )
        },
        actions = {
            IconButton(onClick = onMenuIconClick) {
                Icon(
                    imageVector = Icons.Default.Menu,
                    contentDescription = "Menu Icon",
                    tint = Color.White,
                    modifier = Modifier.size(32.dp)
                )
            }
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Color.Blue
        )
    )
}