package com.example.myfirstcomposeapp.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.sp


@Composable
fun MyText(modifier: Modifier) {
    Column(modifier = modifier) {
        Text("Jose")
        Text("Jose", color = Color.Red)
        Text("Jose", color = Color.Red, fontSize = 25.sp)
        Text("Jose", color = Color.Red, fontSize = 25.sp, fontStyle = FontStyle.Italic)
        Text(
            "Jose",
            color = Color.Red,
            fontSize = 25.sp,
            fontStyle = FontStyle.Italic,
            fontWeight = FontWeight.Bold
        )
        Text("LetterSpacing", letterSpacing = 10.sp)
        Text("TextDecoration", textDecoration = TextDecoration.Underline)
        Text(
            "TextDecoration",
            textDecoration = TextDecoration.Underline + TextDecoration.LineThrough
        )
        Text(
            "Aling",
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Red),
            textAlign = TextAlign.Center
        )
        Text(
            "Aling, Aling, Aling, Aling, Aling, Aling, Aling, Aling, Aling, Aling, Aling, Aling, ",
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Red),
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )

    }

}