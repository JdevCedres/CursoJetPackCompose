package com.example.myfirstcomposeapp.components

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.example.myfirstcomposeapp.R


@Composable
fun MyImage(modifier: Modifier = Modifier) {
    Image(
        painter = painterResource(R.drawable.barca),
        contentDescription = "Avatar image profile",
        modifier = modifier
            .size(75.dp)
            .clip(RoundedCornerShape(50))
            .border(
                width = 5.dp,
                brush = Brush.linearGradient(colors = listOf(Color.Blue, Color.Red)),
                shape = RoundedCornerShape(50)
            ),

        contentScale = ContentScale.Crop
    )
}

@Preview
@Composable
fun MyIcon(modifier: Modifier = Modifier) {
    Icon(
        painter = painterResource(R.drawable.ic_herramienta),
        contentDescription = null,
        modifier = Modifier.size(200.dp),
        tint = Color.Green
    )
}

@Composable
fun MyNetworkImage(modifier: Modifier = Modifier) {
    AsyncImage(
        modifier = modifier.size(150.dp),
        model = "https://avatars.githubusercontent.com/u/128382689?v=4&size=64",
        contentDescription = "Image from network",
        onError = { Log.i("image", "Ha ocurrido un error ${it.result.throwable.message}") }
    )
}
