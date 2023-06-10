package com.example.simpletodo.view.page.todo

import com.example.simpletodo.repository.TodoRepository
import com.example.simpletodo.util.CustomPaginator
import com.example.simpletodo.util.logger
import de.tschuehly.spring.viewcomponent.core.ViewComponent
import de.tschuehly.spring.viewcomponent.core.toProperty
import de.tschuehly.spring.viewcomponent.jte.ViewContext
import org.springframework.data.domain.Pageable

@ViewComponent
class TodoListViewComponent(
    private val todoRepository: TodoRepository,
) {

    val log = logger()


    fun render(pageable: Pageable): ViewContext {

        val todos =
            todoRepository.findTodos(pageable)

        val paginator =
            CustomPaginator(5, pageable.pageSize, todos.totalElements)

        val pageInfo =
            paginator.getFixedBlock(pageable.pageNumber)

        println(pageInfo)


        return ViewContext(
            "todos" toProperty todos,
            "pageInfo" toProperty pageInfo,
        )
    }


}