package domain

import domain.models.Task

sealed class TaskAction {
    data class Add(val task: Task) : TaskAction()
    data class Update(val task: Task) : TaskAction()
    data class Delete(val task: Task) : TaskAction()
    data class SetCompleted(val task: Task, val completed: Boolean) : TaskAction()
    data class SetFavorite(val task: Task, val isFavorite: Boolean) : TaskAction()
}