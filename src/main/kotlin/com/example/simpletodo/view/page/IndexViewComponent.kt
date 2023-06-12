package com.example.simpletodo.view.page

import com.example.simpletodo.config.security.UserPrincipal
import com.example.simpletodo.view.page.layout.LayoutViewComponent
import com.example.simpletodo.view.page.layout.footer.FooterViewComponent
import de.tschuehly.spring.viewcomponent.core.ViewComponent
import de.tschuehly.spring.viewcomponent.core.toProperty
import de.tschuehly.spring.viewcomponent.jte.ViewContext
import gg.jte.springframework.boot.autoconfigure.JteView
import jakarta.servlet.http.HttpSession
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.core.userdetails.UserDetails

@ViewComponent
class IndexViewComponent(

) {

    fun render(): ViewContext {

        val authentication =
            SecurityContextHolder.getContext().authentication

        println("??????")

        println(authentication.authorities)
        println(authentication.principal)


        return ViewContext(
            "hello" toProperty "is it JTE Worth?",
            "authentication" toProperty authentication,
        )

    }

}