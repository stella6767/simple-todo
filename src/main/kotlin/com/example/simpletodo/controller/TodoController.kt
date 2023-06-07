package com.example.simpletodo.controller

import com.example.simpletodo.view.page.todo.TodoListViewComponent
import com.example.simpletodo.view.page.IndexViewComponent
import de.tschuehly.spring.viewcomponent.jte.ViewContext
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping

@Controller
class TodoController(
    private val todoListViewComponent: TodoListViewComponent,
    private val indexViewComponent: IndexViewComponent,
) {

    @GetMapping("/")
    fun index(): ViewContext {

        println("????")

        return indexViewComponent.render()
    }


    @GetMapping("/todos")
    fun todos(): ViewContext {
        return todoListViewComponent.render()
    }


}