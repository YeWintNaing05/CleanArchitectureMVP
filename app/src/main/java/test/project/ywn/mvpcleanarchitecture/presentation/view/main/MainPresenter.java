package test.project.ywn.mvpcleanarchitecture.presentation.view.main;

import android.support.annotation.NonNull;

import java.util.Collection;
import java.util.List;

import javax.inject.Inject;

import test.project.ywn.mvpcleanarchitecture.data.entity.mapper.TodoEntityDataMapper;
import test.project.ywn.mvpcleanarchitecture.domain.exception.DefaultErrorBundle;
import test.project.ywn.mvpcleanarchitecture.domain.exception.ErrorBundle;
import test.project.ywn.mvpcleanarchitecture.domain.interactor.AddTodoData;
import test.project.ywn.mvpcleanarchitecture.domain.interactor.DefaultObserver;
import test.project.ywn.mvpcleanarchitecture.domain.interactor.GetTodoList;
import test.project.ywn.mvpcleanarchitecture.domain.model.Todo;
import test.project.ywn.mvpcleanarchitecture.presentation.exception.ErrorMessageFactory;
import test.project.ywn.mvpcleanarchitecture.presentation.mapper.TodoModelDataMapper;
import test.project.ywn.mvpcleanarchitecture.presentation.model.TodoModel;
import test.project.ywn.mvpcleanarchitecture.presentation.view.base.BasePresenter;

/**
 * Created by root on 11/16/17.
 */

public class MainPresenter implements BasePresenter {


    private MainListView mainListView;
    private GetTodoList getTodoListUseCase;
    private AddTodoData addTodoDataUseCase;

    @Inject
    public MainPresenter(GetTodoList getTodoList, AddTodoData addTodoData) {

        this.getTodoListUseCase = getTodoList;
        this.addTodoDataUseCase = addTodoData;
    }


    @Override
    public void resume() {

    }

    @Override
    public void pause() {

    }


    public void addTodo(TodoModel model) {
        // getTodoListUseCase.addTodo(TodoModelDataMapper.transformTodoEntity(model));

        addTodoDataUseCase.execute(new DefaultObserver<Void>(), TodoModelDataMapper.transformTodoFromTodoModel(model));
        initialize();
    }

    @Override
    public void destroy() {
        this.getTodoListUseCase.dispose();
        this.mainListView = null;
    }

    public void initialize() {
        this.loadUserList();
    }

    private void loadUserList() {
        this.showViewLoading();
        this.getTodoList();
    }

    /*  public void onUserClicked(TodoModel userModel) {
          this.mainListView.viewTodoList(userModel);
      }
  */
    private void showViewLoading() {
        this.mainListView.showLoading();
    }

    private void hideViewLoading() {
        this.mainListView.hideLoading();
    }

    private void showViewRetry() {
        this.mainListView.showRetry();
    }


    private void showUsersCollectionInView(Collection<Todo> todoCollection) {
        final Collection<TodoModel> todoModelCollection =
                TodoModelDataMapper.transformList((List<Todo>) todoCollection);
        this.mainListView.renderTodoList(todoModelCollection);
    }

    private void showErrorMessage(ErrorBundle errorBundle) {
        String errorMessage = ErrorMessageFactory.create(
                errorBundle.getException());
        this.mainListView.showError(errorMessage);
    }

    private void getTodoList() {
        this.getTodoListUseCase.execute(new TodoListObserver(), null);
    }


    public void setView(@NonNull MainListView mainListView) {
        this.mainListView = mainListView;
    }

    private final class TodoListObserver extends DefaultObserver<List<Todo>> {

        @Override
        public void onComplete() {
            MainPresenter.this.hideViewLoading();
        }

        @Override
        public void onError(Throwable e) {
            MainPresenter.this.hideViewLoading();
            MainPresenter.this.showErrorMessage(new DefaultErrorBundle((Exception) e));
            MainPresenter.this.showViewRetry();
        }

        @Override
        public void onNext(List<Todo> todos) {
            MainPresenter.this.showUsersCollectionInView(todos);
        }
    }


}
