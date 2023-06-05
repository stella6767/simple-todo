@file:Suppress("ktlint")
package gg.jte.generated.precompiled.com.example.simpletodo.view.page.index
@Suppress("UNCHECKED_CAST", "UNUSED_PARAMETER")
class JteIndexViewComponentGenerated {
companion object {
	@JvmField val JTE_NAME = "com/example/simpletodo/view/page/index/IndexViewComponent.kte"
	@JvmField val JTE_LINE_INFO = intArrayOf(2,2,2,2,2,2,2,5,5,5,5,5)
	@JvmStatic fun render(jteOutput:gg.jte.html.HtmlTemplateOutput, jteHtmlInterceptor:gg.jte.html.HtmlInterceptor?, helloWorld:String) {
		jteOutput.writeContent("\n\n<div>")
		jteOutput.setContext("div", null)
		jteOutput.writeUserContent(helloWorld)
		jteOutput.writeContent("</div>")
	}
	@JvmStatic fun renderMap(jteOutput:gg.jte.html.HtmlTemplateOutput, jteHtmlInterceptor:gg.jte.html.HtmlInterceptor?, params:Map<String, Any?>) {
		val helloWorld = params["helloWorld"] as String
		render(jteOutput, jteHtmlInterceptor, helloWorld);
	}
}
}
