package test.project.ywn.mvpcleanarchitecture.domain.interactor;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.Observer;
import test.project.ywn.mvpcleanarchitecture.data.entity.mapper.TodoEntityDataMapper;
import test.project.ywn.mvpcleanarchitecture.domain.executor.PostExecutionThread;
import test.project.ywn.mvpcleanarchitecture.domain.executor.ThreadExecutor;
import test.project.ywn.mvpcleanarchitecture.domain.model.Todo;
import test.project.ywn.mvpcleanarchitecture.domain.repository.TodoRepository;

/**
 * Created by root on 11/20/17.
 */

public class AddTodoData extends UseCase<Void, Todo> {


    TodoRepository repository;

    @Inject
    AddTodoData(TodoRepository repository, ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread) {
        super(threadExecutor, postExecutionThread);
        this.repository = repository;
    }

    @Override
    Observable<Void> buildUseCaseObservable(Todo todo) {
        repository.add(TodoEntityDataMapper.transformTodoEntityFromTodo(todo));

        return new Observable<Void>() {
            @Override
            protected void subscribeActual(Observer<? super Void> observer) {

            }
        };
    }


}
