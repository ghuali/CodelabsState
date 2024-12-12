import androidx.compose.runtime.toMutableStateList
import androidx.lifecycle.ViewModel

private fun getWellnessTasks() = List(30) { i -> WellnessTask(i, "Task # $i") }

class WellnessViewModel : ViewModel() {
    private val _tasks = getWellnessTasks().toMutableStateList()
    val tasks: List<WellnessTask> get() = _tasks

    fun remove(taskId: Int) {
        _tasks.removeAll { it.id == taskId }
    }

    fun changeTaskCheked(taskId: Int, checked: Boolean) {
        tasks.find { it.id == taskId }?.let { task ->
            task.checked = checked
        }
    }
}
