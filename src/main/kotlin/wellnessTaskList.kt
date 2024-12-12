import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.modifier.modifierLocalMapOf




@Composable
fun WellnessTaskList(
    listaItems: List<WellnessTask>,
    onCheckedTask: (taskId: Int, checked: Boolean) -> Unit,
    onCloseTask: (taskId: Int) -> Unit
) {
    LazyColumn(
        state = rememberLazyListState()
    ) {
        items(listaItems) { task ->
            WellnessTaskItem(
                taskName = task.label,
                taskId = task.id,
                onClose = { onCloseTask(task.id) }
            )
        }
    }
}