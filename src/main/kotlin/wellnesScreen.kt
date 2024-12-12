import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun WellnessScreen(
    modifier: Modifier = Modifier,
    wellnessViewModel: WellnessViewModel = viewModel()
) {
    var vasosContador by rememberSaveable { mutableStateOf(0) }
    Column(modifier = modifier) {
        if (vasosContador > 0) {
            val vasosTexto = if (vasosContador == 1) "vaso" else "vasos"
            Text("Has bebido $vasosContador $vasosTexto de agua hoy")
        }
        Row {
            Button(onClick = { vasosContador++ }) {
                Text("Beber vaso")
            }
            Button(onClick = { vasosContador = 0 }) {
                Text("Reiniciar contador")
            }
        }
        WellnessTaskList(
            listaItems = wellnessViewModel.tasks,
            onCheckedTask = { taskId, checked ->
                wellnessViewModel.changeTaskCheked(taskId, checked)
            },
            onCloseTask = { taskId ->
                wellnessViewModel.remove(taskId)
            }
        )
    }
}
