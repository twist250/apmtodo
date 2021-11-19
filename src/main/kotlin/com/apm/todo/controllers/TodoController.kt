package com.apm.todo.controllers

import com.apm.todo.dtos.CreateTodoDto
import com.apm.todo.models.Todo
import com.apm.todo.services.TodoService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/todos")
class TodoController(private val todoService: TodoService) {
    @PostMapping
    fun createTodo(@RequestBody todoDto: CreateTodoDto): ResponseEntity<Todo> {
        val todo: Todo = todoService.addTodo(todoDto)
        return ResponseEntity.status(HttpStatus.CREATED).body(todo)
    }

    @GetMapping
    fun getAllTodos(): ResponseEntity<List<Todo>> {
        val todos: List<Todo> = todoService.getAllTodos()
        return ResponseEntity.ok(todos)
    }

    @DeleteMapping("/{id}")
    fun deleteTodo(@PathVariable id: Long): ResponseEntity<Long> {
        val deletedId: Long = todoService.deleteById(id)
        return ResponseEntity.ok(deletedId)
    }

    @GetMapping("/{id}")
    fun getOneById(@PathVariable id: Long): ResponseEntity<Todo> {
        val todo: Todo = todoService.getOneById(id)
        return ResponseEntity.ok(todo)
    }
}