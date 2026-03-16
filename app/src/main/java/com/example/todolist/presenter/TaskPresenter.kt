package com.example.todolist.presenter

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
        TODO("Not yet implemented")
    }

    override fun filterByPriority(priority: Priority) {
        TODO("Not yet implemented")
    }

    override fun filterByStatus(isDone: Boolean) {
        TODO("Not yet implemented")
    }

    override fun toggleTaskStatus(task: Task) {
        TODO("Not yet implemented")
    }
}