package com.example.myfirstcomposeapp.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TriStateCheckbox
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.state.ToggleableState
import androidx.compose.ui.unit.dp
import com.example.myfirstcomposeapp.R
import com.example.myfirstcomposeapp.components.state.CheckBoxState
import com.example.myfirstcomposeapp.ejercicio.RowColumnBox

@Composable
fun MySwitch(modifier: Modifier = Modifier) {
    var switchState by remember { mutableStateOf(false) }
    Box(modifier = modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Switch(
            checked = switchState,
            onCheckedChange = { switchState = it },
            thumbContent = {
                Icon(
                    painter = painterResource(R.drawable.ic_herramienta),
                    contentDescription = ""
                )
            },
            enabled = false,
            colors = SwitchDefaults.colors(
                //Bolita
                checkedThumbColor = Color.Red,
                uncheckedThumbColor = Color.Blue,
                disabledCheckedThumbColor = Color.Yellow,
                disabledUncheckedThumbColor = Color.LightGray,
                //Icono
                checkedIconColor = Color.Green,
                uncheckedIconColor = Color.Cyan,
                disabledCheckedIconColor = Color.Magenta,
                disabledUncheckedIconColor = Color.DarkGray,
                //Border
                checkedBorderColor = Color.Green,
                uncheckedBorderColor = Color.Blue,
                disabledCheckedBorderColor = Color.Magenta,
                disabledUncheckedBorderColor = Color.Red,
                //Track
                checkedTrackColor = Color.Yellow,
                uncheckedTrackColor = Color.Red,
                disabledCheckedTrackColor = Color.Blue,
                disabledUncheckedTrackColor = Color.Magenta


            )
        )
    }
}

@Composable
fun MyCheckBox(modifier: Modifier) {
    var state by remember { mutableStateOf(false) }

    Box(modifier = modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.clickable { state = !state }
        ) {
            Checkbox(
                checked = state,
                onCheckedChange = { state = it },
                enabled = true,
                colors = CheckboxDefaults.colors(
                    checkedColor = Color.Red,
                    uncheckedColor = Color.Black,
                    checkmarkColor = Color.Blue,
                    disabledCheckedColor = Color.Blue,
                    disabledUncheckedColor = Color.Magenta,
                )
            )
            Text("Acepto los términos y condiciones")
        }

    }
}

@Composable
fun ParentCheckBoxes(modifier: Modifier = Modifier) {
    var state by remember {
        mutableStateOf(
            listOf(
                CheckBoxState("terms", "Aceptar los terminos y condiciones"),
                CheckBoxState("newLetter", "Recibir la newsletter", checked = true),
                CheckBoxState("updates", "Recibir actualizaciones")
            )
        )
    }
    Column(modifier = modifier.fillMaxSize()) {
        state.forEach { myState ->
            CheckBoxWithText(checkBoxState = myState) {
                state = state.map {
                    if (it.id == myState.id) {
                        myState.copy(checked = !myState.checked)
                    } else {
                        it
                    }
                }
            }
        }
    }

}

@Composable
fun CheckBoxWithText(
    modifier: Modifier = Modifier,
    checkBoxState: CheckBoxState,
    onCheckedChange: (CheckBoxState) -> Unit
) {

    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.clickable { onCheckedChange(checkBoxState) }
    ) {
        Checkbox(
            checked = checkBoxState.checked,
            onCheckedChange = { onCheckedChange(checkBoxState) },
            enabled = true,

            )
        Text(checkBoxState.label)
    }
}

@Composable
fun MyTriStateCheckBox(modifier: Modifier = Modifier) {
    var parentState by remember { mutableStateOf(ToggleableState.Off) }
    var child1 by remember { mutableStateOf(false) }
    var child2 by remember { mutableStateOf(false) }
    LaunchedEffect(child1, child2) {
        parentState = when {
            child1 && child2 -> ToggleableState.On
            !child1 && !child2 -> ToggleableState.Off
            else -> ToggleableState.Indeterminate
        }
    }
    Column(modifier = modifier) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            TriStateCheckbox(parentState, onClick = {
                val newState = parentState != ToggleableState.On
                child1 = newState
                child2 = child1
            })
            Text("Seleccionar Todo")
        }
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(horizontal = 16.dp)
        ) {
            Checkbox(child1, onCheckedChange = { child1 = it })
            Text("Example 1")
        }
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(horizontal = 16.dp)
        ) {
            Checkbox(child2, onCheckedChange = { child2 = it })
            Text("Example 2")
        }
    }
}