package com.apm.todo.services

import com.apm.todo.dtos.CreateTodoDto
import com.apm.todo.exceptions.TodoNotFoundException
import com.apm.todo.models.Todo
import com.apm.todo.repositories.TodoRepository
import org.springframework.stereotype.Service
import java.lang.RuntimeException

@Service
class TodoService(private val todoRepository: TodoRepository) {

    fun addTodo(todoDto: CreateTodoDto): Todo = todoRepository.save(Todo().apply {
        this.title = todoDto.title
        this.description = todoDto.description
    })

    fun getAllTodos(): List<Todo> = todoRepository.findAll()

    fun deleteById(id: Long): Long {
        val todo = getOneById(id)
        todoRepository.delete(todo)
        return id
    }

    fun getOneById(id: Long): Todo =
        todoRepository.findById(id).orElseThrow { TodoNotFoundException("No record found") }

}