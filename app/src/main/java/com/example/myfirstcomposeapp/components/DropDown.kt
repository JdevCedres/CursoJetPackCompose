package com.example.myfirstcomposeapp.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.MenuDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.PopupProperties
import com.example.myfirstcomposeapp.R




@Composable
fun MyDropDownMenu(modifier: Modifier = Modifier) {
    var expanded by remember { mutableStateOf(false) }
    Box(modifier = modifier) {
        Button(onClick = { expanded = true }) {
            Text("Options:")
        }
        DropdownMenu(
            expanded,
            onDismissRequest = { expanded = false },
            offset = DpOffset(36.dp, 16.dp),
            properties = PopupProperties(
                focusable = true,
                dismissOnClickOutside = true,
                dismissOnBackPress = true,
                clippingEnabled = true
            )
        ) {
            DropdownMenuItem(text = { Text("Option1") }, onClick = { expanded = false })
            DropdownMenuItem(text = { Text("Option2") }, onClick = { expanded = false })
            DropdownMenuItem(text = { Text("Option3") }, onClick = { expanded = false })
            DropdownMenuItem(text = { Text("Option4") }, onClick = { expanded = false })
        }
    }
}


@Composable
fun MyDropDownItem(modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        DropdownMenuItem(
            modifier = Modifier.fillMaxWidth(),
            text = {
                Text("Example 1")
            },
            leadingIcon = {
                Icon(
                    painter = painterResource(R.drawable.ic_herramienta),
                    contentDescription = ""
                )
            },
            trailingIcon = {
                Icon(
                    painter = painterResource(R.drawable.ic_herramienta),
                    contentDescription = ""
                )
            },
            enabled = false,
            contentPadding = PaddingValues(16.dp),
            colors = MenuDefaults.itemColors(
                textColor = Color.Red,
                leadingIconColor = Color.Blue,
                trailingIconColor = Color.Green,
                disabledTextColor = Color.Magenta,
                disabledLeadingIconColor = Color.Cyan,
                disabledTrailingIconColor = Color.LightGray
            ),
            onClick = {})
    }
}