package com.example.simpletodo.config

import gg.jte.TemplateEngine
import org.springframework.web.servlet.view.AbstractTemplateViewResolver
import org.springframework.web.servlet.view.AbstractUrlBasedView

class JteViewResolver(templateEngine: TemplateEngine) : AbstractTemplateViewResolver() {
    private val templateEngine: TemplateEngine

    init {
        viewClass = requiredViewClass()
        setSuffix(".kte")
        this.templateEngine = templateEngine
    }

    override fun instantiateView(): AbstractUrlBasedView {
        return JteView(templateEngine)
    }
}
