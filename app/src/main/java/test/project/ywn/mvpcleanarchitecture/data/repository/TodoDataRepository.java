package test.project.ywn.mvpcleanarchitecture.data.repository;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Observable;
import io.reactivex.functions.Function;
import test.project.ywn.mvpcleanarchitecture.data.db.TodoDatabase;
import test.project.ywn.mvpcleanarchitecture.data.db.TodoEntityDao;
import test.project.ywn.mvpcleanarchitecture.data.entity.TodoEntity;
import test.project.ywn.mvpcleanarchitecture.data.entity.mapper.TodoEntityDataMapper;
import test.project.ywn.mvpcleanarchitecture.domain.model.Todo;
import test.project.ywn.mvpcleanarchitecture.domain.repository.TodoRepository;

/**
 * Created by root on 11/16/17.
 */
@Singleton
public class TodoDataRepository implements TodoRepository {


    @Inject
    TodoEntityDao todoEntityDao;

    @Inject
    public TodoDataRepository(TodoEntityDao todoEntityDao) {
        this.todoEntityDao = todoEntityDao;
    }


    @Override
    public Observable<List<Todo>> users() {
        return todoEntityDao.getTodoEntityList().toObservable().map(new Function<List<TodoEntity>, List<Todo>>() {
            @Override
            public List<Todo> apply(List<TodoEntity> entities) throws Exception {
                return TodoEntityDataMapper.transformList(entities);
            }
        });
    }

    @Override
    public Observable<Todo> user(int todoId) {
        return todoEntityDao.getTodoById(todoId).toObservable().map(new Function<TodoEntity, Todo>() {
            @Override
            public Todo apply(TodoEntity todoEntity) throws Exception {
                return TodoEntityDataMapper.transformTodo(todoEntity);
            }
        });
    }

    @Override
    public void add(TodoEntity todoEntity) {
         todoEntityDao.addTodoEntity(todoEntity);
    }
}
