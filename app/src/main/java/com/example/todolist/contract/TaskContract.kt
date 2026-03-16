package com.example.todolist.contract

import com.example.todolist.model.Category
import com.example.todolist.model.Priority
import com.example.todolist.model.Task

interface TaskContract {

    sealed class UiMessage {
        data object ErrorTitleRequired : UiMessage()
        data object ErrorCategoryRequired : UiMessage()
        data object ErrorPriorityRequired : UiMessage()
    }
    interface View {
        fun displayTasks(tasks : List<Task>)
        fun displayError(message: UiMessage)
    }

    interface Presenter {
        fun addTask(task: Task)
        fun updateTask(task: Task)
        fun deleteTask(task: Task)
        fun loadTasks()
        fun filterByCategory(category: Category)
        fun filterByPriority(priority: Priority)
        fun filterByStatus(isDone: Boolean)
        fun toggleTaskStatus(task: Task)
    }
}