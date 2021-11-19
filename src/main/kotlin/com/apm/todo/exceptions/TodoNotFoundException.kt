package com.apm.todo.exceptions

import java.lang.RuntimeException

class TodoNotFoundException(msg: String) : RuntimeException(msg)
