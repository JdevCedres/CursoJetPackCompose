package com.example.myfirstcomposeapp

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun SimpleRecyclerView(modifier: Modifier) {
    val myList = listOf("Jose", "Manuel", "Elena", "Adrian", "Aitana")
    LazyColumn(modifier = modifier) {
        item { Text("Header") }

        items(myList) {
            Text("Hola me llamo $it")
        }
        item { Text("Footer") }
    }
}
