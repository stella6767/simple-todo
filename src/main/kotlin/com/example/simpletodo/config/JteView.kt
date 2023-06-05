package com.example.simpletodo.config

import gg.jte.TemplateEngine
import gg.jte.output.Utf8ByteOutput
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.http.MediaType
import org.springframework.web.servlet.view.AbstractTemplateView
import java.nio.charset.StandardCharsets


class JteView(templateEngine: TemplateEngine) : AbstractTemplateView() {
    private val templateEngine: TemplateEngine

    init {
        this.templateEngine = templateEngine
    }

    @Throws(Exception::class)
    override fun renderMergedTemplateModel(
        model: Map<String, Any>,
        request: HttpServletRequest,
        response: HttpServletResponse
    ) {
        val url = url
        val output = Utf8ByteOutput()
        templateEngine.render(url, model, output)
        response.contentType = MediaType.TEXT_HTML_VALUE
        response.characterEncoding = StandardCharsets.UTF_8.name()
        response.setContentLength(output.getContentLength())
        output.writeTo(response.outputStream)
    }
}