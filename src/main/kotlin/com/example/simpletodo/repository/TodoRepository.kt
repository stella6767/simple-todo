package com.example.simpletodo.repository

import com.example.simpletodo.entity.Todo
import org.springframework.data.jpa.repository.JpaRepository

interface TodoRepository : JpaRepository<Todo, Long>, TodoCustomRepository {

}