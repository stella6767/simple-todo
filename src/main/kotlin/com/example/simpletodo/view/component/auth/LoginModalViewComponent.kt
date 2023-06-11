package com.example.simpletodo.view.component.auth

import com.example.simpletodo.entity.type.SignType
import com.example.simpletodo.view.page.layout.header.HeaderViewComponent
import de.tschuehly.spring.viewcomponent.core.ViewComponent
import de.tschuehly.spring.viewcomponent.core.toProperty
import de.tschuehly.spring.viewcomponent.jte.ViewContext

@ViewComponent
class LoginModalViewComponent(
    private val headerViewComponent: HeaderViewComponent,

) {


    fun render(): ViewContext {

        val signTypes =
            SignType.values().map { it.name }

        return ViewContext(
            "headerViewComponent" toProperty headerViewComponent.render(),
            "signTypes" toProperty signTypes,
        )

    }

}