package com.apm.todo.models

import org.hibernate.annotations.CreationTimestamp
import java.time.LocalDateTime
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "todos")
class Todo {
    @Id
    @GeneratedValue
    val id: Long? = null
    var title: String? = null
    var description: String? = null

    @CreationTimestamp
    val createdAt: LocalDateTime? = null
}