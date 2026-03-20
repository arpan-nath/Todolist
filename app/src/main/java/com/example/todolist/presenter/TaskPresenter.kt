package com.example.todolist.presenter

import android.R.attr.priority
import com.example.todolist.contract.TaskContract
import com.example.todolist.model.Category
import com.example.todolist.model.Priority
import com.example.todolist.model.Task

class TaskPresenter(
    private val view: TaskContract.View?) : TaskContract.Presenter {

        private val tasks = mutableListOf<Task>()


    override fun addTask(task: Task) {
        if (task.title.isBlank()) {
            view?.displayError(TaskContract.UiMessage.ErrorTitleRequired)
            return
        }

        tasks.add(task)
        view?.displayTasks(tasks)
    }

    override fun updateTask(task: Task) {
        val index = tasks.indexOfFirst {it.id == task.id}

        if (index != -1) {
            tasks[index] = task
            view?.displayTasks(tasks)
        }
    }

    override fun deleteTask(task: Task) {
        tasks.removeAll {it.id == task.id}
    }

    override fun loadTasks() {
        view?.displayTasks(tasks)
    }

    override fun filterByCategory(category: Category) {
        val filteredList = tasks.filter { it.category == category }
        view?.displayTasks(filteredList)
    }

    override fun filterByPriority(priority: Priority) {
        val filteredList = tasks.filter { it.priority == priority }
        view?.displayTasks(filteredList)
    }

    override fun filterByStatus(isDone: Boolean) {
        val filteredList = tasks.filter { it.isDone == isDone }
        view?.displayTasks(filteredList)
    }

    override fun toggleTaskStatus(task: Task) {
        val index = tasks.indexOfFirst {it.id == task.id}
        if (index != -1) {
            tasks[index].isDone = !tasks[index].isDone
            view?.displayTasks(tasks)
        }
    }
}