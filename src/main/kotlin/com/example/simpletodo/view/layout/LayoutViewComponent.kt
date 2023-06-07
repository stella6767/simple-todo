package com.example.simpletodo.view.layout

import com.example.simpletodo.view.layout.footer.FooterViewComponent
import com.example.simpletodo.view.layout.header.HeaderViewComponent
import de.tschuehly.spring.viewcomponent.core.ViewComponent
import de.tschuehly.spring.viewcomponent.core.toProperty
import de.tschuehly.spring.viewcomponent.jte.ViewContext


@ViewComponent
class LayoutViewComponent(
    private val headerViewComponent: HeaderViewComponent,
    private val footerViewComponent: FooterViewComponent,
)  {

    fun render(nestedViewComponent: ViewContext): ViewContext {

        return ViewContext(
            "header" toProperty headerViewComponent.render(),
            "nestedView" toProperty nestedViewComponent,
            "footer" toProperty footerViewComponent.render()
        )

    }

}