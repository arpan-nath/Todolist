package com.example.todolist.model

import java.util.UUID

data class Task(
    val id: String = UUID.randomUUID().toString(),
    var title: String,
    var description: String?,
    var category: Category,
    var priority: Priority,
    var isDone: Boolean = false,
    val dateCreation: Long = System.currentTimeMillis()
)
