package com.example.jetpackcompose_bottomnavigation

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.jetpackcompose_bottomnavigation.navigation.BottomScreen
import com.example.jetpackcompose_bottomnavigation.navigation.bottomNavigationItems
import com.example.jetpackcompose_bottomnavigation.ui.theme.JetpackComposeBottomNavigationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeBottomNavigationTheme {
                BottomNavigate()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun BottomNavigate() {
    val navController = rememberNavController()
    Scaffold(
        bottomBar = {
            AppBottomNavigation(navController, bottomNavigationItems)
        }
    ) {
        NavHost(
            navController = navController,
            startDestination = BottomScreen.Home.route
        ) {
            composable(BottomScreen.Home.route) {
                BottomHome()
            }
            composable(BottomScreen.Favourite.route) {
                BottomFavourite()
            }
            composable(BottomScreen.Search.route) {
                BottomSearch()
            }
            composable(BottomScreen.User.route) {
                BottomUser()
            }
            composable(BottomScreen.Setting.route) {
                BottomSetting()
            }
        }
    }
}


@Composable
fun AppBottomNavigation(navController: NavController, bottomNavigationItems: List<BottomScreen>) {
    NavigationBar {
        bottomNavigationItems.forEach { screen ->
            NavigationBarItem(
                icon = {
                    Icon(screen.icon, contentDescription = null)
                },
                label = {
                    Text(text = screen.route)
                },
                selected = navController.currentDestination?.route == screen.route,
                onClick = {
                    navController.navigate(screen.route) {
                        // Avoid multiple copies of the same destination when reselecting the same item
                        popUpTo(navController.graph.startDestinationId) {
                            saveState = true
                        }
                        // Avoid multiple copies of the same destination when reselecting the same item
                        launchSingleTop = true
                        // Restore state when reselecting a previously selected item
                        restoreState = true
                    }
                }
            )
        }
    }
}