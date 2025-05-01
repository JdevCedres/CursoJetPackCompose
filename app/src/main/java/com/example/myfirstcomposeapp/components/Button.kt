package com.example.myfirstcomposeapp.components

import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun MyButtons(modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        Button(
            onClick = { Log.i("jdev", "PULSADO!!!") },
            enabled = true,
            shape = RoundedCornerShape(20),
            border = BorderStroke(3.dp, Color.Red),
            colors = ButtonDefaults.buttonColors(
                contentColor = Color.Yellow,
                containerColor = Color.Cyan,
                disabledContainerColor = Color.Yellow,
                disabledContentColor = Color.Black
            )
        ) {
            Text("Púlsame")
        }
        OutlinedButton(onClick = {}) {
            Text("OutLinedButton")
        }
        TextButton(onClick = {}) {
            Text("TextButton")
        }
        ElevatedButton(onClick = {}, elevation = ButtonDefaults.elevatedButtonElevation() ) {
            Text("ElevatedButton")
        }
        FilledTonalButton(onClick = {}) { Text("FilledTonalButton") }
    }
}