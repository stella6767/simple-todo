@import com.example.simpletodo.entity.Todo
@import com.example.simpletodo.util.CustomPaginator
@import org.springframework.data.domain.Page
@import java.util.*

@param Page<Todo> todos
@param Map<String, Object> pageInfo


<div class="h-100 w-full flex items-center justify-center bg-teal-lightest font-sans">
    <div class="bg-white rounded shadow p-6 m-4 w-full lg:w-3/4 lg:max-w-lg">
        <div class="mb-4">
            <h1 class="text-5xl font-bold">Todo List</h1>
            <div class="flex mt-4">
                <input class="shadow appearance-none border rounded w-full py-2 px-3 mr-4 text-grey-darker"
                       autofocus="autofocus"
                       id="new-todo"
                       name="newTodo"
                       placeholder="To do..."
                       required type="text"
                       >
                <button class="flex-no-shrink p-2 border-2 rounded text-teal border-teal hover:text-white hover:bg-teal"

                        hx-include="#new-todo"
                        hx-trigger="click"
                        hx-post="/todo"
                        hx-target="#todo-list"
                        hx-swap="afterbegin"

                >Add
                </button>
            </div>
        </div>


        <div id="todo-list">



            @for(Todo todo : todos)
                <div class="flex mb-4 items-center" id="todo-box">

                    <p class="w-full text-grey-darkest">${todo.getContent()}</p>
                    <button class="flex-no-shrink p-2 ml-4 mr-2 border-2 rounded hover:text-white text-green border-green hover:bg-green">
                        Done
                    </button>
                    <button class="flex-no-shrink p-2 ml-2 border-2 rounded text-red border-red hover:text-white hover:bg-red">
                        Remove
                    </button>
                </div>
            @endfor
        </div>
    </div>



</div>

<div class="flex justify-center">

    <div class="join ">

        @if(!todos.isFirst())
            <button class="join-item btn">«</button>
        @endif


        @for(int i = (Integer) pageInfo.get("blockFirstPageNum") ; i <= (Integer) pageInfo.get("blockLastPageNum"); ++i)

            @if((Integer)pageInfo.get("currentPageNum") == i)
                <input class="join-item btn btn-square"
                       type="radio"
                       name="options"
                       aria-label="${i}"
                       onclick="window.location.href='/todos?page=${i}'"
                       checked
                />

            @else
                <input class="join-item btn btn-square"
                       type="radio"
                       name="options"
                       aria-label="${i}"
                       onclick="window.location.href='/todos?page=${i}'"
                />

            @endif
        @endfor

<%--        <input class="join-item btn btn-square"--%>
<%--               type="radio"--%>
<%--               name="options"--%>
<%--               aria-label="1"--%>

<%--               checked />--%>
<%--        <input class="join-item btn btn-square" type="radio" name="options" aria-label="2"--%>
<%--               onclick="window.location.href='/todos?page=2'"--%>
<%--        />--%>
<%--        <input class="join-item btn btn-square" type="radio" name="options" aria-label="3" />--%>
<%--        <input class="join-item btn btn-square" type="radio" name="options" aria-label="4" />--%>

        <button class="join-item btn">»</button>
    </div>

</div>

