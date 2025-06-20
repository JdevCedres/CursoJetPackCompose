package com.example.myfirstcomposeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.FabPosition
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.SnackbarResult
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.myfirstcomposeapp.components.MyCard
import com.example.myfirstcomposeapp.components.MyFAB
import com.example.myfirstcomposeapp.components.MyModalDrawer
import com.example.myfirstcomposeapp.components.MyNavigationBar
import com.example.myfirstcomposeapp.components.MyTopAppBar
import com.example.myfirstcomposeapp.ui.theme.MyFirstComposeAppTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyFirstComposeAppTheme {
               // val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
               // val snackBarHostState = remember { SnackbarHostState() }
               // val scope = rememberCoroutineScope()

               // MyModalDrawer(drawerState) {
                    Scaffold(

                        modifier = Modifier.fillMaxSize()
                        /*,
                      topBar = { MyTopAppBar{
                          scope.launch { drawerState.open() }
                      } },
                      snackbarHost = { SnackbarHost(snackBarHostState)},
                      floatingActionButton = { MyFAB() },
                      floatingActionButtonPosition = FabPosition.Start,
                      bottomBar = {MyNavigationBar()}

                       */
                    )
                    { innerPadding ->
                        MyCard(Modifier.padding(innerPadding))
                        /*
                        Box(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(innerPadding)
                                .background(Color.Cyan),
                            contentAlignment = Alignment.Center,

                            ) {
                            Text("Esta es mi screen", modifier = Modifier.clickable {
                                scope.launch {
                                    val result = snackBarHostState.showSnackbar(
                                        "Example",
                                        actionLabel = "Deshacer"
                                    )
                                    if (result == SnackbarResult.ActionPerformed) {
                                        // Pulso deshacer
                                    } else {
                                        // no hizo nada
                                    }
                                }

                            })


                        }
                         */
                    }
                }

            }
        }
    }


@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyFirstComposeAppTheme {
        Greeting("Jose")
    }
}