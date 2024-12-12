import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
@Preview
fun App(wellnessViewModel: WellnessViewModel = viewModel()) {
    MaterialTheme {
        Surface {
            Column {
                WellnessScreen(wellnessViewModel = wellnessViewModel)
            }
        }
    }
}

fun main() = application {
    val wellnessViewModel = WellnessViewModel()
    Window(onCloseRequest = ::exitApplication) {
        App(wellnessViewModel = wellnessViewModel) // Pasamos el ViewModel a la App
    }
}