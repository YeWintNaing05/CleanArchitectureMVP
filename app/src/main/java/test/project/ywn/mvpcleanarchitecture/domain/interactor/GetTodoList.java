package test.project.ywn.mvpcleanarchitecture.domain.interactor;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import test.project.ywn.mvpcleanarchitecture.data.entity.TodoEntity;
import test.project.ywn.mvpcleanarchitecture.domain.executor.PostExecutionThread;
import test.project.ywn.mvpcleanarchitecture.domain.executor.ThreadExecutor;
import test.project.ywn.mvpcleanarchitecture.domain.model.Todo;
import test.project.ywn.mvpcleanarchitecture.domain.repository.TodoRepository;

/**
 * Created by root on 11/16/17.
 */

public class GetTodoList extends UseCase<List<Todo>, Void> {


    private final TodoRepository repository;


    @Inject
    GetTodoList(TodoRepository repository, ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread) {
        super(threadExecutor, postExecutionThread);
        this.repository = repository;
    }

    @Override
    Observable<List<Todo>> buildUseCaseObservable(Void aVoid) {

        return repository.users();
    }


}
