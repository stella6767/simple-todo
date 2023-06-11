package com.example.simpletodo.view.component

import com.example.simpletodo.entity.Todo
import com.example.simpletodo.view.page.layout.header.HeaderViewComponent
import de.tschuehly.spring.viewcomponent.core.ViewComponent
import de.tschuehly.spring.viewcomponent.core.toProperty
import de.tschuehly.spring.viewcomponent.jte.ViewContext


@ViewComponent
class TodoViewComponent(

) {

    fun render(todo: Todo): ViewContext {

        return ViewContext(
            "todo" toProperty todo,
        )
    }

}