package gg.jte.generated.ondemand.com.example.simpletodo.view.page.todo;
import com.example.simpletodo.entity.Todo;
import com.example.simpletodo.util.CustomPaginator;
import org.springframework.data.domain.Page;
import java.util.*;
public final class JteTodoListViewComponentGenerated {
	public static final String JTE_NAME = "com/example/simpletodo/view/page/todo/TodoListViewComponent.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,2,3,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,39,39,39,42,42,42,50,50,61,61,62,62,63,63,65,65,67,67,69,69,69,69,70,70,73,73,75,75,79,79,79,79,79,79,79,79,80,80,80,80,84,84,88,88,88,88,88,88,88,88,89,89,89,89,92,92,94,94,96,96,98,98,100,100,100,100,102,102,109};
	private static final gg.jte.runtime.BinaryContent BINARY_CONTENT = gg.jte.runtime.BinaryContent.load(JteTodoListViewComponentGenerated.class, "JteTodoListViewComponentGenerated.bin", 1103,125,427,105,9,9,10,74,99,26,11,14,130,13,1,67,66,130,13,1,67,35,10,10,82,99,38,23);
	private static final byte[] TEXT_PART_BINARY_0 = BINARY_CONTENT.get(0);
	private static final byte[] TEXT_PART_BINARY_1 = BINARY_CONTENT.get(1);
	private static final byte[] TEXT_PART_BINARY_2 = BINARY_CONTENT.get(2);
	private static final byte[] TEXT_PART_BINARY_3 = BINARY_CONTENT.get(3);
	private static final byte[] TEXT_PART_BINARY_4 = BINARY_CONTENT.get(4);
	private static final byte[] TEXT_PART_BINARY_5 = BINARY_CONTENT.get(5);
	private static final byte[] TEXT_PART_BINARY_6 = BINARY_CONTENT.get(6);
	private static final byte[] TEXT_PART_BINARY_7 = BINARY_CONTENT.get(7);
	private static final byte[] TEXT_PART_BINARY_8 = BINARY_CONTENT.get(8);
	private static final byte[] TEXT_PART_BINARY_9 = BINARY_CONTENT.get(9);
	private static final byte[] TEXT_PART_BINARY_10 = BINARY_CONTENT.get(10);
	private static final byte[] TEXT_PART_BINARY_11 = BINARY_CONTENT.get(11);
	private static final byte[] TEXT_PART_BINARY_12 = BINARY_CONTENT.get(12);
	private static final byte[] TEXT_PART_BINARY_13 = BINARY_CONTENT.get(13);
	private static final byte[] TEXT_PART_BINARY_14 = BINARY_CONTENT.get(14);
	private static final byte[] TEXT_PART_BINARY_15 = BINARY_CONTENT.get(15);
	private static final byte[] TEXT_PART_BINARY_16 = BINARY_CONTENT.get(16);
	private static final byte[] TEXT_PART_BINARY_17 = BINARY_CONTENT.get(17);
	private static final byte[] TEXT_PART_BINARY_18 = BINARY_CONTENT.get(18);
	private static final byte[] TEXT_PART_BINARY_19 = BINARY_CONTENT.get(19);
	private static final byte[] TEXT_PART_BINARY_20 = BINARY_CONTENT.get(20);
	private static final byte[] TEXT_PART_BINARY_21 = BINARY_CONTENT.get(21);
	private static final byte[] TEXT_PART_BINARY_22 = BINARY_CONTENT.get(22);
	private static final byte[] TEXT_PART_BINARY_23 = BINARY_CONTENT.get(23);
	private static final byte[] TEXT_PART_BINARY_24 = BINARY_CONTENT.get(24);
	private static final byte[] TEXT_PART_BINARY_25 = BINARY_CONTENT.get(25);
	private static final byte[] TEXT_PART_BINARY_26 = BINARY_CONTENT.get(26);
	private static final byte[] TEXT_PART_BINARY_27 = BINARY_CONTENT.get(27);
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, Page<Todo> todos, Map<String, Object> pageInfo) {
		jteOutput.writeBinaryContent(TEXT_PART_BINARY_0);
		for (Todo todo : todos) {
			jteOutput.writeBinaryContent(TEXT_PART_BINARY_1);
			jteOutput.setContext("p", null);
			jteOutput.writeUserContent(todo.getContent());
			jteOutput.writeBinaryContent(TEXT_PART_BINARY_2);
		}
		jteOutput.writeBinaryContent(TEXT_PART_BINARY_3);
		var maxPage = 5;
		jteOutput.writeBinaryContent(TEXT_PART_BINARY_4);
		var start =  Math.floor (todos.getNumber() / maxPage) * maxPage + 1;
		jteOutput.writeBinaryContent(TEXT_PART_BINARY_5);
		var end = (start + maxPage -1 ) < todos.getTotalPages() ? start + maxPage -1 : todos.getTotalPages(); 
		jteOutput.writeBinaryContent(TEXT_PART_BINARY_6);
		if (todos.isFirst() ) {
			jteOutput.writeBinaryContent(TEXT_PART_BINARY_7);
		} else {
			jteOutput.writeBinaryContent(TEXT_PART_BINARY_8);
			jteOutput.setContext("button", "onclick");
			jteOutput.writeUserContent(todos.getNumber()-1);
				jteOutput.setContext("button", null);
			jteOutput.writeBinaryContent(TEXT_PART_BINARY_9);
		}
		jteOutput.writeBinaryContent(TEXT_PART_BINARY_10);
		for (int i = (int) start; i <= end;  i++ ) {
			jteOutput.writeBinaryContent(TEXT_PART_BINARY_11);
			if ( i == (todos.getNumber() + 1)) {
				jteOutput.writeBinaryContent(TEXT_PART_BINARY_12);
				if (gg.jte.runtime.TemplateUtils.isAttributeRendered(i)) {
					jteOutput.writeBinaryContent(TEXT_PART_BINARY_13);
					jteOutput.setContext("input", "aria-label");
					jteOutput.writeUserContent(i);
						jteOutput.setContext("input", null);
					jteOutput.writeBinaryContent(TEXT_PART_BINARY_14);
				}
				jteOutput.writeBinaryContent(TEXT_PART_BINARY_15);
				jteOutput.setContext("input", "onclick");
				jteOutput.writeUserContent(i -1);
					jteOutput.setContext("input", null);
				jteOutput.writeBinaryContent(TEXT_PART_BINARY_16);
			} else {
				jteOutput.writeBinaryContent(TEXT_PART_BINARY_17);
				if (gg.jte.runtime.TemplateUtils.isAttributeRendered(i)) {
					jteOutput.writeBinaryContent(TEXT_PART_BINARY_18);
					jteOutput.setContext("input", "aria-label");
					jteOutput.writeUserContent(i);
						jteOutput.setContext("input", null);
					jteOutput.writeBinaryContent(TEXT_PART_BINARY_19);
				}
				jteOutput.writeBinaryContent(TEXT_PART_BINARY_20);
				jteOutput.setContext("input", "onclick");
				jteOutput.writeUserContent(i - 1);
					jteOutput.setContext("input", null);
				jteOutput.writeBinaryContent(TEXT_PART_BINARY_21);
			}
			jteOutput.writeBinaryContent(TEXT_PART_BINARY_22);
		}
		jteOutput.writeBinaryContent(TEXT_PART_BINARY_23);
		if (todos.isLast() ) {
			jteOutput.writeBinaryContent(TEXT_PART_BINARY_24);
		} else {
			jteOutput.writeBinaryContent(TEXT_PART_BINARY_25);
			jteOutput.setContext("button", "onclick");
			jteOutput.writeUserContent(todos.getNumber()+1);
				jteOutput.setContext("button", null);
			jteOutput.writeBinaryContent(TEXT_PART_BINARY_26);
		}
		jteOutput.writeBinaryContent(TEXT_PART_BINARY_27);
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		Page<Todo> todos = (Page<Todo>)params.get("todos");
		Map<String, Object> pageInfo = (Map<String, Object>)params.get("pageInfo");
		render(jteOutput, jteHtmlInterceptor, todos, pageInfo);
	}
}
