package gg.jte.generated.ondemand.com.example.simpletodo.view.component;
import com.example.simpletodo.entity.Todo;
import java.util.*;
public final class JteTodoViewComponentGenerated {
	public static final String JTE_NAME = "com/example/simpletodo/view/component/TodoViewComponent.jte";
	public static final int[] JTE_LINE_INFO = {1,1,2,4,4,4,4,4,4,8,8,8,8,16};
	private static final gg.jte.runtime.BinaryContent BINARY_CONTENT = gg.jte.runtime.BinaryContent.load(JteTodoViewComponentGenerated.class, "JteTodoViewComponentGenerated.bin", 93,303);
	private static final byte[] TEXT_PART_BINARY_0 = BINARY_CONTENT.get(0);
	private static final byte[] TEXT_PART_BINARY_1 = BINARY_CONTENT.get(1);
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, Todo todo) {
		jteOutput.writeBinaryContent(TEXT_PART_BINARY_0);
		jteOutput.setContext("p", null);
		jteOutput.writeUserContent(todo.getContent());
		jteOutput.writeBinaryContent(TEXT_PART_BINARY_1);
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		Todo todo = (Todo)params.get("todo");
		render(jteOutput, jteHtmlInterceptor, todo);
	}
}
