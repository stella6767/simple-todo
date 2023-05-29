package gg.jte.generated.ondemand.com.example.simpletodo.view.page.index;
public final class JteIndexViewComponentGenerated {
	public static final String JTE_NAME = "com/example/simpletodo/view/page/index/IndexViewComponent.jte";
	public static final int[] JTE_LINE_INFO = {2,2,2,2,2,2,2,5,5,5,5,5};
	private static final gg.jte.runtime.BinaryContent BINARY_CONTENT = gg.jte.runtime.BinaryContent.load(JteIndexViewComponentGenerated.class, "JteIndexViewComponentGenerated.bin", 7,6);
	private static final byte[] TEXT_PART_BINARY_0 = BINARY_CONTENT.get(0);
	private static final byte[] TEXT_PART_BINARY_1 = BINARY_CONTENT.get(1);
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, String helloWorld) {
		jteOutput.writeBinaryContent(TEXT_PART_BINARY_0);
		jteOutput.setContext("div", null);
		jteOutput.writeUserContent(helloWorld);
		jteOutput.writeBinaryContent(TEXT_PART_BINARY_1);
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		String helloWorld = (String)params.get("helloWorld");
		render(jteOutput, jteHtmlInterceptor, helloWorld);
	}
}
