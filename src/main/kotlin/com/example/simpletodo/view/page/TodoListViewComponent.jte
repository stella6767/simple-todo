<%--<!DOCTYPE html>--%>
<%--<html>--%>
<%--<head>--%>
<%--    <meta http-equiv="Content-Type" content="text/html" charset="UTF-8">--%>
<%--    <link href="/css/bootstrap.min.css" rel="stylesheet">--%>
<%--    <link rel="stylesheet" type="text/css" href="/css/comment.css" />--%>
<%--    <title>ToDo List</title>--%>
<%--</head>--%>
<%--<body>--%>

<%--<div view:component="sidebarViewComponent.render(sidebarActiveTab)"></div>--%>


<%--<div class="container" style="border-radius: 20px; border-color: gray; border-style: solid">--%>

<%--    <div class="form-group form-inline text-center" style="margin: auto">--%>
<%--        <div class="page-header"--%>
<%--             style="background: gray; color: white; padding: 20px; border-radius: 20px; width: 90%; margin: 15px auto">--%>
<%--            <h1 class="text-center">TO DO List</h1>--%>
<%--        </div>--%>
<%--        <hr>--%>

<%--        <button class="pull-right btn btn-default" onclick="location.href='/logout'" id="logout">logout</button>--%>
<%--        <br>--%>
<%--        <form onsubmit="return false">--%>
<%--            <input type="text" class="form-control" name="description" placeholder="오늘 할일" id="description"--%>
<%--                   style="width: 50%">--%>
<%--            <input type="submit" class="btn btn-default" id="btn_add_todo" value="등록">--%>
<%--        </form>--%>
<%--    </div>--%>

<%--    <br/><br/><br/>--%>

<%--    <div th:each="todo : ${todoList}" th:data-idx="${todo.idx}"--%>
<%--         style="width: 90%; height: auto; margin: 15px auto; padding: 20px; border-radius: 10px; background: gray; color: white">--%>
<%--        <div>--%>
<%--            <div>--%>
<%--                <h2 th:if="${todo.status}" th:text="${todo.description}"--%>
<%--                    style="font-size: 27px; text-decoration: line-through"></h2>--%>
<%--                <h2 th:if="!${todo.status}" th:text="${todo.description}" class="edit"--%>
<%--                    style="display: inline-block"></h2>--%>
<%--                <div style="float: right;">--%>
<%--                    <button th:if="!${todo.status}" data-toggle=false type="button" class="btn btn-primary btn_modify_description">수정</button>--%>
<%--                    <button type="button" class="btn btn-info btn_show_reply">댓글</button>--%>
<%--                    <button type="button" class="btn btn-success btn_complete">완료</button>--%>
<%--                    <button type="button" class="btn btn-danger btn_delete">삭제</button>--%>
<%--                </div>--%>
<%--            </div>--%>
<%--            <div>--%>
<%--                <em th:text="${todo.createdDate} ? ${#temporals.format(todo.createdDate,'yyyy-MM-dd')} : ${todo.createdDate}"></em>--%>
<%--            </div>--%>
<%--            <div class="replies" style="margin: auto; display: none;">--%>
<%--                <hr>--%>
<%--                <ul class="comment_list" data-test="test" style="font-size: 20px">--%>
<%--                    <li th:each="comment : ${todo.comments}" th:data-idx="${comment.idx}">--%>
<%--                        <p class="comment_content" th:text="${comment.content}" ></p>--%>
<%--                        <button type="button" class="btn btn-primary btn_reply_modify" data-is_editing="false" >수정</button>--%>
<%--                        <button type="button" class="btn btn-danger btn_reply_delete" >삭제</button>--%>
<%--                    </li>--%>
<%--                </ul>--%>
<%--                <div class="form-group form-inline" style="margin: auto;">--%>
<%--                    <form onsubmit="return false">--%>
<%--                        <input type="text" class="form-control input_reply" name="description" placeholder="댓글"--%>
<%--                               style="width: 35%">--%>
<%--                        <input type="submit" th:data-idx="${todo.idx}" class="btn btn-default list_insert" value="등록">--%>
<%--                    </form>--%>
<%--                </div>--%>
<%--            </div>--%>
<%--        </div>--%>
<%--    </div>--%>

<%--    <script th:src="@{/js/jquery.min.js}"></script>--%>
<%--    <script src="/js/comment.js"></script>--%>
<%--    <script src="/js/todo.js"></script>--%>
<%--    <script>--%>
<%--        $(document).ready(function () {--%>
<%--            $('#description').focus();--%>
<%--        });--%>
<%--    </script>--%>
<%--</div>--%>
<%--</body>--%>
<%--</html>--%>


@import de.tschuehly.spring.viewcomponent.jte.ViewContext
@import com.example.simpletodo.view.page.TodoListViewComponent



@param String name

Hello ${name}!
The current timestamp is ${System.currentTimeMillis()}.

