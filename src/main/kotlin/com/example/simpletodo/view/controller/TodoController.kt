package com.example.simpletodo.view.controller

import com.example.simpletodo.dto.StatusDto
import com.example.simpletodo.service.TodoService
import com.example.simpletodo.util.logger
import com.example.simpletodo.view.component.TodoViewComponent
import com.example.simpletodo.view.layout.LayoutViewComponent
import com.example.simpletodo.view.page.todo.TodoListViewComponent
import com.example.simpletodo.view.page.IndexViewComponent
import de.tschuehly.spring.viewcomponent.jte.ViewContext
import jdk.jshell.Snippet.Status
import org.springframework.data.domain.Pageable
import org.springframework.data.web.PageableDefault
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseBody

@Controller
class TodoController(
    private val todoService: TodoService,

    private val layoutViewComponent: LayoutViewComponent,
    private val todoListViewComponent: TodoListViewComponent,
    private val indexViewComponent: IndexViewComponent,
    private val todoViewComponent: TodoViewComponent,
) {

    private val log = logger()

    @GetMapping("/")
    fun index(): ViewContext {
        log.info("index")
        return layoutViewComponent.render(indexViewComponent.render())
    }


    @GetMapping("/todos")
    fun todos(@PageableDefault(size = 10) pageable: Pageable ): ViewContext {

        return layoutViewComponent.render(todoListViewComponent.render(pageable))
    }


    @PutMapping("/todo/{id}")
    //@ResponseBody
    fun updateTodo(@PathVariable id: Long,
                   //@RequestBody status:StatusDto
    ): ViewContext {

        val todo =
            todoService.updateStatusTodo(id)

        return todoViewComponent.render(todo)
    }

    @DeleteMapping("/todo/{id}")
    @ResponseBody
    fun deleteTodoById(@PathVariable id:Long): String {

        todoService.deleteTodoById(id)

        return ""
    }

    @PostMapping("/todo")
    fun addTodo(@RequestParam("newTodo") todo: String): ViewContext {

        return todoViewComponent.render(todoService.save(todo))
    }


}