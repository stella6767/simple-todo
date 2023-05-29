//package com.example.simpletodo.config
//
//import gg.jte.CodeResolver
//import gg.jte.ContentType
//import gg.jte.TemplateEngine
//import gg.jte.resolve.DirectoryCodeResolver
//import gg.jte.springframework.boot.autoconfigure.JteProperties
//import gg.jte.springframework.boot.autoconfigure.JteViewResolver
//import org.springframework.context.annotation.Bean
//import org.springframework.context.annotation.Configuration
//import java.nio.file.FileSystems
//import java.nio.file.Path
//import java.nio.file.Paths
//
//
//@Configuration
//class TemplateConfiguration {
//
//
//    @Bean
//    fun jteProperties(): JteProperties {
//
//        val jteProperties = JteProperties()
//        jteProperties.templateLocation = "src/main/kotlin"
//
//        return jteProperties
//    }
//
//
//    @Bean
//    fun jteViewResolver(templateEngine: TemplateEngine): JteViewResolver {
//
//
//        return JteViewResolver(templateEngine, ".jte").apply {
//            //this.setSuffix(".kte")
//            this.setSuffix(".jte")
//            this.setPrefix("src/main/kotlin")
//            this.order = -100
//
//        }
//    }
//
//
//
//    @Bean
//    fun templateEngine(jteProperties: JteProperties): TemplateEngine {
//        val profile = System.getenv("SPRING_ENV")
//
//
//
//        return if ("prod" == profile) {
//            // Templates will be compiled by the maven build task
//            TemplateEngine.createPrecompiled(ContentType.Html)
//        } else {
//            // Here, a JTE file watcher will recompile the JTE templates upon file save (the web browser will auto-refresh)
//            // If using IntelliJ, use Ctrl-F9 to trigger an auto-refresh when editing non-JTE files.
//            //val codeResolver: CodeResolver = DirectoryCodeResolver(Path.of("src", "main", "kotlin"))
//
//
//            val split = jteProperties.templateLocation.split("/".toRegex()).dropLastWhile { it.isEmpty() }
//                .toTypedArray()
//            val codeResolver: CodeResolver = DirectoryCodeResolver(FileSystems.getDefault().getPath("", *split))
//
//            val templateEngine =
//                TemplateEngine.create(codeResolver, Paths.get("jte-classes"), ContentType.Html, javaClass.classLoader)
//            templateEngine.setBinaryStaticContent(true)
//            templateEngine
//        }
//    }
//
//}