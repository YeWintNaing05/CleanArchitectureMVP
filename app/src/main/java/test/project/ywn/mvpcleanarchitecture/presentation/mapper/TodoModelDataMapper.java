package test.project.ywn.mvpcleanarchitecture.presentation.mapper;

import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

import test.project.ywn.mvpcleanarchitecture.data.entity.TodoEntity;
import test.project.ywn.mvpcleanarchitecture.domain.model.Todo;
import test.project.ywn.mvpcleanarchitecture.presentation.model.TodoModel;

/**
 * Created by root on 11/16/17.
 */

public class TodoModelDataMapper {

    @NonNull
    public static List<TodoModel> transformList(@NonNull List<Todo> entities) {


        List<TodoModel> todoList = new ArrayList<>();

        for (Todo entity : entities) {

            todoList.add(TodoModel.create(entity.title(), entity.description()));
        }

        return todoList;

    }

    public static TodoModel transformTodo(Todo entity) {
        return TodoModel.create(entity.title(), entity.description());
    }

    public static Todo transformTodoFromTodoModel(TodoModel entity) {
        return Todo.create(entity.title(), entity.description());
    }

    public static TodoEntity transformTodoEntity(TodoModel entity) {
        TodoEntity todoEntity = new TodoEntity();
        todoEntity.setTitle(entity.title());
        todoEntity.setDescription(entity.description());
        return todoEntity;
    }
}
