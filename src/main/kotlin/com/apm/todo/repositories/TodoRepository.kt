package com.apm.todo.repositories;

import com.apm.todo.models.Todo
import org.springframework.data.jpa.repository.JpaRepository

interface TodoRepository : JpaRepository<Todo, Long>