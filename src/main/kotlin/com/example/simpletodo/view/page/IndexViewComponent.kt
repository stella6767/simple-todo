package com.example.simpletodo.view.page

import com.example.simpletodo.view.page.layout.LayoutViewComponent
import com.example.simpletodo.view.page.layout.footer.FooterViewComponent
import de.tschuehly.spring.viewcomponent.core.ViewComponent
import de.tschuehly.spring.viewcomponent.core.toProperty
import de.tschuehly.spring.viewcomponent.jte.ViewContext
import gg.jte.springframework.boot.autoconfigure.JteView

@ViewComponent
class IndexViewComponent(
    private val layoutViewComponent: LayoutViewComponent,
) {

    fun render(): ViewContext {

        return ViewContext(
            "hello" toProperty "is it JTE Worth?",
        )

    }

}