package com.android.lobantain

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material3.Text
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.android.designsystem.theme.LbtTheme
import com.android.lobantain.ui.LbtApp
import com.android.lobantain.ui.theme.LobantainTheme
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.internal.GeneratedComponent

@OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
@AndroidEntryPoint
class MainActivity  : ComponentActivity() {

    val viewModel: MainActivityViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel
        setContent {
                LbtTheme(
                ) {
                    LbtApp(
                        windowSizeClass = calculateWindowSizeClass(this),
                    )
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
    LobantainTheme {
        Greeting("Android")
    }
}