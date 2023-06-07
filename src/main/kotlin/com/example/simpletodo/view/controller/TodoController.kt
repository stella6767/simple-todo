package com.example.simpletodo.view.controller

import com.example.simpletodo.util.logger
import com.example.simpletodo.view.layout.LayoutViewComponent
import com.example.simpletodo.view.page.todo.TodoListViewComponent
import com.example.simpletodo.view.page.IndexViewComponent
import de.tschuehly.spring.viewcomponent.jte.ViewContext
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping

@Controller
class TodoController(
    private val layoutViewComponent: LayoutViewComponent,
    private val todoListViewComponent: TodoListViewComponent,
    private val indexViewComponent: IndexViewComponent,
) {

    private val log = logger()

    @GetMapping("/")
    fun index(): ViewContext {

        log.info("index")

        return layoutViewComponent.render(indexViewComponent.render())
    }


    @GetMapping("/todos")
    fun todos(): ViewContext {
        return todoListViewComponent.render()
    }


}