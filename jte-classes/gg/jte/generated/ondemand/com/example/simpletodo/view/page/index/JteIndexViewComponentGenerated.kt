@file:Suppress("ktlint")
package gg.jte.generated.ondemand.com.example.simpletodo.view.page.index
import com.example.simpletodo.view.layout.footer.FooterViewComponent
@Suppress("UNCHECKED_CAST", "UNUSED_PARAMETER")
class JteIndexViewComponentGenerated {
companion object {
	@JvmField val JTE_NAME = "com/example/simpletodo/view/page/index/IndexViewComponent.kte"
	@JvmField val JTE_LINE_INFO = intArrayOf(2,2,2,4,4,4,4,4,4,4,4,4,7,7,7,7,10,10,10,12)
	@JvmStatic val BINARY_CONTENT = gg.jte.runtime.BinaryContent.load(JteIndexViewComponentGenerated.javaClass, "JteIndexViewComponentGenerated.bin", 6,9,2);
	@JvmStatic val TEXT_PART_BINARY_0 = BINARY_CONTENT.get(0)
	@JvmStatic val TEXT_PART_BINARY_1 = BINARY_CONTENT.get(1)
	@JvmStatic val TEXT_PART_BINARY_2 = BINARY_CONTENT.get(2)
	@JvmStatic fun render(jteOutput:gg.jte.html.HtmlTemplateOutput, jteHtmlInterceptor:gg.jte.html.HtmlInterceptor?, helloWorld:String, footer:FooterViewComponent) {
		jteOutput.writeBinaryContent(TEXT_PART_BINARY_0)
		jteOutput.setContext("div", null)
		jteOutput.writeUserContent(helloWorld)
		jteOutput.writeBinaryContent(TEXT_PART_BINARY_1)
		jteOutput.setContext("html", null)
		jteOutput.writeUserContent(footerViewComponent)
		jteOutput.writeBinaryContent(TEXT_PART_BINARY_2)
	}
	@JvmStatic fun renderMap(jteOutput:gg.jte.html.HtmlTemplateOutput, jteHtmlInterceptor:gg.jte.html.HtmlInterceptor?, params:Map<String, Any?>) {
		val helloWorld = params["helloWorld"] as String
		val footer = params["footer"] as FooterViewComponent
		render(jteOutput, jteHtmlInterceptor, helloWorld, footer);
	}
}
}
