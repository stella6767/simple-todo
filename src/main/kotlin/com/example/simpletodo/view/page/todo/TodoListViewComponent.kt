package com.example.simpletodo.view.page.todo

import com.example.simpletodo.entity.Todo
import com.example.simpletodo.util.logger
import de.tschuehly.spring.viewcomponent.core.ViewComponent
import de.tschuehly.spring.viewcomponent.core.toProperty
import de.tschuehly.spring.viewcomponent.jte.ViewContext

@ViewComponent
class TodoListViewComponent {

    val log = logger()


    fun render(): ViewContext {

        val todo1 = Todo(
            1, "title", true
        )

        val todo2 = Todo(
            2, "title2", true
        )

        val todo3 = Todo(
            3, "title3", true
        )

        val todos = listOf(todo1, todo2, todo3)

        return ViewContext(
            "todos" toProperty todos,
        )
    }


}