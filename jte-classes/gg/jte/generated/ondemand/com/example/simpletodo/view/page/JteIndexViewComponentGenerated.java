package gg.jte.generated.ondemand.com.example.simpletodo.view.page;
import com.example.simpletodo.view.layout.footer.FooterViewComponent;
import de.tschuehly.spring.viewcomponent.jte.ViewContext;
public final class JteIndexViewComponentGenerated {
	public static final String JTE_NAME = "com/example/simpletodo/view/page/IndexViewComponent.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,3,3,3,3,3,3,15,15,15,15,27};
	private static final gg.jte.runtime.BinaryContent BINARY_CONTENT = gg.jte.runtime.BinaryContent.load(JteIndexViewComponentGenerated.class, "JteIndexViewComponentGenerated.bin", 486,69);
	private static final byte[] TEXT_PART_BINARY_0 = BINARY_CONTENT.get(0);
	private static final byte[] TEXT_PART_BINARY_1 = BINARY_CONTENT.get(1);
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, String hello) {
		jteOutput.writeBinaryContent(TEXT_PART_BINARY_0);
		jteOutput.setContext("button", null);
		jteOutput.writeUserContent(hello);
		jteOutput.writeBinaryContent(TEXT_PART_BINARY_1);
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		String hello = (String)params.get("hello");
		render(jteOutput, jteHtmlInterceptor, hello);
	}
}
