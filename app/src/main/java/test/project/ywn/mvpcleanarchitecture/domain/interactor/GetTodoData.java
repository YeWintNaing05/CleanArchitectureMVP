package test.project.ywn.mvpcleanarchitecture.domain.interactor;

import com.google.auto.value.AutoValue;

import javax.inject.Inject;

import io.reactivex.Observable;
import test.project.ywn.mvpcleanarchitecture.domain.executor.PostExecutionThread;
import test.project.ywn.mvpcleanarchitecture.domain.executor.ThreadExecutor;
import test.project.ywn.mvpcleanarchitecture.domain.model.Todo;
import test.project.ywn.mvpcleanarchitecture.domain.repository.TodoRepository;

/**
 * Created by root on 11/20/17.
 */

public class GetTodoData extends UseCase<Todo, GetTodoData.Param> {


    private TodoRepository repository;

    @Inject
    GetTodoData(TodoRepository repository, ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread) {
        super(threadExecutor, postExecutionThread);
        this.repository = repository;
    }


    @Override
    Observable<Todo> buildUseCaseObservable(Param param) {
        return repository.user(param.id());
    }


    @AutoValue
    public abstract static class Param {
        public abstract int id();

        public static Param create(int id) {
            return new AutoValue_GetTodoData_Param(id);
        }

    }
}
