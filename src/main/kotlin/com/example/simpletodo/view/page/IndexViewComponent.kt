package com.example.simpletodo.view.page

import com.example.simpletodo.view.layout.footer.FooterViewComponent
import de.tschuehly.spring.viewcomponent.core.ViewComponent
import de.tschuehly.spring.viewcomponent.core.toProperty
import de.tschuehly.spring.viewcomponent.jte.ViewContext
import gg.jte.springframework.boot.autoconfigure.JteView

@ViewComponent
class IndexViewComponent(
    private val footerViewComponent: FooterViewComponent
) {

    fun render(): ViewContext {
        return ViewContext(
            "helloWorld" toProperty "stella6767",
            "footer" toProperty footerViewComponent.render()
        )
    }

}