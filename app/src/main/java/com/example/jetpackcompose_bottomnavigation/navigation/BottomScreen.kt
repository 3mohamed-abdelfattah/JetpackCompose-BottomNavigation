package com.example.jetpackcompose_bottomnavigation.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomScreen(val route: String, val title: String, val icon: ImageVector) {
    object Home : BottomScreen("Home", "Home", Icons.Filled.Home)
    object Favourite : BottomScreen("Favourite", "Favourite", Icons.Filled.Favorite)
    object Search : BottomScreen("Search", "Search", Icons.Filled.Search)
    object Setting : BottomScreen("Setting", "Setting", Icons.Filled.Settings)
    object User : BottomScreen("User", "User", Icons.Filled.Person)
}

val bottomNavigationItems = listOf(
    BottomScreen.Home,
    BottomScreen.Favourite,
    BottomScreen.Search,
    BottomScreen.User,
    BottomScreen.Setting
)