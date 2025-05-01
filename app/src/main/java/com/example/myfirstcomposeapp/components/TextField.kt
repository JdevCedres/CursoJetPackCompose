package com.example.myfirstcomposeapp.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp


@Composable
fun MyTextFieldParent(modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        var user by remember { mutableStateOf("Jose") }
        var value by remember { mutableStateOf("") }
        MyTextField(user) { user = it }
        MySecondTextField(value) { value = it }
        AdvanceTextField(value) { value = it }
        MyPasswordTextField(value) { value = it }
        Spacer(Modifier.height(20.dp))
        MyOutlinedTextField(value) { value = it }
    }
}

@Composable
fun MyTextField(user: String, onUserChange: (String) -> Unit) {
    TextField(user, onValueChange = { onUserChange(it) }, readOnly = user.isEmpty())
}

@Composable
fun MySecondTextField(value: String, onValueChange: (String) -> Unit) {
    TextField(value, onValueChange = { onValueChange(it) }, label = { Text("Introduce tu email") })
}

@Composable
fun AdvanceTextField(value: String, onValueChange: (String) -> Unit) {
    TextField(value, onValueChange = {
        if (it.contains("o")) {
            onValueChange(it.replace("o", "w"))
        } else {
            onValueChange(it)
        }


    })
}

@Composable
fun MyPasswordTextField(value: String, onValueChange: (String) -> Unit) {
    var passwordHidden by remember { mutableStateOf(false) }
    TextField(
        value, onValueChange = { onValueChange(it) },
        singleLine = true,
        label = { Text("Introduce tu password") },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        visualTransformation = if (passwordHidden) PasswordVisualTransformation() else VisualTransformation.None,
        trailingIcon = {
            Text(
                text = if (passwordHidden) "Mostrar" else "Ocultar",
                modifier = Modifier.clickable {
                    passwordHidden = !passwordHidden
                })
        }
    )
}

@Composable
fun MyOutlinedTextField(value: String, onValueChange: (String) -> Unit) {
    OutlinedTextField(value = value, onValueChange = { onValueChange(it) })
}

























