package com.example.simpletodo.service

import com.example.simpletodo.entity.Todo
import com.example.simpletodo.repository.TodoRepository
import com.example.simpletodo.util.logger
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class TodoService(
    private val todoRepository: TodoRepository,
) {

    val logger = logger()


    fun save(todo: String): Todo {

        val newTodo = Todo(content = todo,)

        return todoRepository.save(newTodo)
    }


    fun findAll(): MutableList<Todo> {

        return todoRepository.findAll()
    }


    fun deleteTodoById(id: Long){

        todoRepository.deleteById(id)
    }


    fun updateStatusTodo(id: Long, status: Boolean){


    }



}