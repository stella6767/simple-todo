package com.example.simpletodo.config

import gg.jte.CodeResolver
import gg.jte.ContentType
import gg.jte.TemplateEngine
import gg.jte.output.Utf8ByteOutput
import gg.jte.resolve.DirectoryCodeResolver
import gg.jte.springframework.boot.autoconfigure.JteProperties
import gg.jte.springframework.boot.autoconfigure.JteViewResolver
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Primary
import org.springframework.http.MediaType
import org.springframework.web.servlet.ViewResolver
import org.springframework.web.servlet.view.AbstractTemplateView
import org.springframework.web.servlet.view.AbstractTemplateViewResolver
import org.springframework.web.servlet.view.AbstractUrlBasedView
import java.nio.charset.StandardCharsets
import java.nio.file.FileSystems
import java.nio.file.Path
import java.nio.file.Paths


@Configuration
class TemplateConfiguration {

    @Value("\${spring.profiles.active:unknown}")
    private val profile: String? = null

    @Bean
    fun jteViewResolver(templateEngine: TemplateEngine): ViewResolver {

        return JteViewResolver(templateEngine)
    }


    @Bean
    fun templateEngine(): TemplateEngine {

        //val profile = System.getProperty("spring.profiles.active")

        println("profile = $profile")

        return if ("prod" == profile) {

            println("되나")
            // Templates will be compiled by the maven build task
            TemplateEngine.createPrecompiled(ContentType.Html)
        } else {

//            val split = jteProperties.templateLocation.split("/".toRegex()).dropLastWhile { it.isEmpty() }
//                .toTypedArray()
//
//            val codeResolver: CodeResolver = DirectoryCodeResolver(FileSystems.getDefault().getPath("", *split))

//            val targetDirectory: Path = Path.of("jte-classes")
//            TemplateEngine.createPrecompiled(targetDirectory, ContentType.Html);

            var codeResolver = DirectoryCodeResolver(Path.of("src", "main", "kotlin"));


            val templateEngine =
                TemplateEngine.create(codeResolver, Paths.get("jte-classes"), ContentType.Html, javaClass.classLoader)
            templateEngine.setBinaryStaticContent(true)
            templateEngine
        }
    }

}