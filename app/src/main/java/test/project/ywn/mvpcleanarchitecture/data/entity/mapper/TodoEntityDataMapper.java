package test.project.ywn.mvpcleanarchitecture.data.entity.mapper;

import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

import test.project.ywn.mvpcleanarchitecture.data.entity.TodoEntity;
import test.project.ywn.mvpcleanarchitecture.domain.model.Todo;
import test.project.ywn.mvpcleanarchitecture.presentation.model.TodoModel;

/**
 * Created by root on 11/16/17.
 */

public class TodoEntityDataMapper {
    @NonNull
    public static List<Todo> transformList(@NonNull List<TodoEntity> entities) {


        List<Todo> todoList = new ArrayList<>();

        for (TodoEntity entity : entities) {
            todoList.add(Todo.create(entity.getTitle(), entity.getDescription()));
        }

        return todoList;

    }

    public static Todo transformTodo(TodoEntity entity) {
        return Todo.create(entity.getTitle(), entity.getDescription());
    }


    public static TodoEntity transformTodoEntityFromTodo(Todo todo) {

        TodoEntity entity = new TodoEntity();
        entity.setTitle(todo.title());
        entity.setDescription(todo.description());
        return entity;
    }
}
