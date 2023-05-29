package com.example.simpletodo.view.page.index

import de.tschuehly.spring.viewcomponent.core.ViewComponent
import de.tschuehly.spring.viewcomponent.core.toProperty
import de.tschuehly.spring.viewcomponent.jte.ViewContext
import gg.jte.springframework.boot.autoconfigure.JteView

@ViewComponent
class IndexViewComponent(

) {


    fun render(): ViewContext {
        return ViewContext(
            "helloWorld" toProperty "stella6767"
        )
    }

}