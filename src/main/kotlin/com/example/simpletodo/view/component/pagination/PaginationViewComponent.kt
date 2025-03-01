package com.example.simpletodo.view.component.pagination

import de.tschuehly.spring.viewcomponent.core.ViewComponent
import de.tschuehly.spring.viewcomponent.core.toProperty
import de.tschuehly.spring.viewcomponent.jte.ViewContext
import org.springframework.data.domain.Page

@ViewComponent
class PaginationViewComponent(

) {


    fun render(pages: Page<out Any>, endpoint:String): ViewContext {
        return ViewContext(
            "pages" toProperty pages,
            "endpoint" toProperty endpoint
        )
    }

}