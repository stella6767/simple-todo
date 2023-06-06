package gg.jte.generated.ondemand.com.example.simpletodo.view.page.index;
import com.example.simpletodo.view.layout.footer.FooterViewComponent;
public final class JteIndexViewComponentGenerated {
	public static final String JTE_NAME = "com/example/simpletodo/view/page/index/IndexViewComponent.jte";
	public static final int[] JTE_LINE_INFO = {2,2,4,4,4,4,4,4,4,7,7,7,7,10,10,10,12};
	private static final gg.jte.runtime.BinaryContent BINARY_CONTENT = gg.jte.runtime.BinaryContent.load(JteIndexViewComponentGenerated.class, "JteIndexViewComponentGenerated.bin", 6,9,2);
	private static final byte[] TEXT_PART_BINARY_0 = BINARY_CONTENT.get(0);
	private static final byte[] TEXT_PART_BINARY_1 = BINARY_CONTENT.get(1);
	private static final byte[] TEXT_PART_BINARY_2 = BINARY_CONTENT.get(2);
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, String helloWorld, FooterViewComponent footerViewComponent) {
		jteOutput.writeBinaryContent(TEXT_PART_BINARY_0);
		jteOutput.setContext("div", null);
		jteOutput.writeUserContent(helloWorld);
		jteOutput.writeBinaryContent(TEXT_PART_BINARY_1);
		jteOutput.setContext("html", null);
		jteOutput.writeUserContent(footerViewComponent.render());
		jteOutput.writeBinaryContent(TEXT_PART_BINARY_2);
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		String helloWorld = (String)params.get("helloWorld");
		FooterViewComponent footerViewComponent = (FooterViewComponent)params.get("footerViewComponent");
		render(jteOutput, jteHtmlInterceptor, helloWorld, footerViewComponent);
	}
}
