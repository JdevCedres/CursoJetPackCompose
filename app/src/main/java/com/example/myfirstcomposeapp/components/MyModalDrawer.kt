package com.example.myfirstcomposeapp.components

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.Badge
import androidx.compose.material3.DrawerState
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.NavigationDrawerItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.myfirstcomposeapp.components.model.DrawerItem

@Composable
fun MyModalDrawer(drawerState: DrawerState, content: @Composable (() -> Unit)) {

    val scope = rememberCoroutineScope()
    val myItem:List<DrawerItem> = listOf(
        DrawerItem(title = "Home", icon = Icons.Default.Home, notification = 3),
        DrawerItem(title = "Fav", icon = Icons.Default.Favorite, notification = 0),
        DrawerItem(title = "Build", icon = Icons.Default.Build, notification = 9),
        DrawerItem(title = "Call", icon = Icons.Default.Call, notification = 0),
        DrawerItem(title = "LocationOn", icon = Icons.Default.LocationOn, notification = 5),
    )
    var selectedIndex by remember { mutableIntStateOf(0) }
    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet(
                drawerShape = RoundedCornerShape(
                    topEndPercent = 16,
                    bottomEndPercent = 16,
                    bottomStartPercent = 0
                ),
                drawerContentColor = Color.White,
            ) {
                Spacer(Modifier.height(40.dp))
                myItem.forEachIndexed { index, drawerItem ->
                    NavigationDrawerItem(
                        label = { Text(drawerItem.title) },
                        selected = selectedIndex == index,
                        onClick = {selectedIndex = index},
                        icon = { Icon(imageVector = drawerItem.icon, contentDescription = "") },
                        badge = {
                            if (drawerItem.notification > 0){
                                Badge(
                                    containerColor = if(selectedIndex == index) Color.White else Color.Red,
                                    contentColor =  if(selectedIndex == index) Color.Red else Color.White
                                ) { Text(drawerItem.notification.toString()) }
                            }

                        },
                        shape = RoundedCornerShape(0),
                        colors = NavigationDrawerItemDefaults.colors(
                            selectedContainerColor = Color.Red,
                            selectedIconColor = Color.White,
                            selectedTextColor = Color.White,
                            selectedBadgeColor = Color.Yellow,
                            unselectedContainerColor = Color.White,
                            unselectedIconColor = Color.Red,
                            unselectedTextColor = Color.Red,
                            unselectedBadgeColor = Color.Green
                        )

                    )

                }

            }
        },
        scrimColor = Color.Red.copy(alpha = 0.8f)
    ) {
        content()
    }
}