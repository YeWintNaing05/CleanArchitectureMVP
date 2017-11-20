package test.project.ywn.mvpcleanarchitecture.domain.repository;

import java.util.List;

import io.reactivex.Observable;
import test.project.ywn.mvpcleanarchitecture.data.entity.TodoEntity;
import test.project.ywn.mvpcleanarchitecture.domain.model.Todo;

/**
 * Created by root on 11/16/17.
 */

public interface TodoRepository {
    /**
     * Get an {@link Observable} which will emit a List of {@link Todo}.
     */
    Observable<List<Todo>> users();

    /**
     * Get an {@link Observable} which will emit a {@link Todo}.
     *
     * @param todoId The todo id used to retrieve todo data.
     */
    Observable<Todo> user(final int todoId);

    void add(TodoEntity todoEntity);


}
