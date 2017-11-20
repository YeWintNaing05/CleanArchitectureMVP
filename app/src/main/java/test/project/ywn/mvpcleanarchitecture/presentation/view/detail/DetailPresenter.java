package test.project.ywn.mvpcleanarchitecture.presentation.view.detail;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import java.util.List;

import javax.inject.Inject;

import test.project.ywn.mvpcleanarchitecture.domain.exception.DefaultErrorBundle;
import test.project.ywn.mvpcleanarchitecture.domain.exception.ErrorBundle;
import test.project.ywn.mvpcleanarchitecture.domain.interactor.DefaultObserver;
import test.project.ywn.mvpcleanarchitecture.domain.interactor.GetTodoData;
import test.project.ywn.mvpcleanarchitecture.domain.model.Todo;
import test.project.ywn.mvpcleanarchitecture.presentation.exception.ErrorMessageFactory;
import test.project.ywn.mvpcleanarchitecture.presentation.mapper.TodoModelDataMapper;
import test.project.ywn.mvpcleanarchitecture.presentation.view.base.BasePresenter;
import test.project.ywn.mvpcleanarchitecture.presentation.view.main.MainPresenter;

/**
 * Created by root on 11/20/17.
 */

public class DetailPresenter implements BasePresenter {


    private final GetTodoData getTodoDataUseCase;
    private DetailView detailView;


    @Inject
    public DetailPresenter(GetTodoData getTodoDataUseCase) {
        this.getTodoDataUseCase = getTodoDataUseCase;
    }

    @Override
    public void resume() {

    }


    public void setDetailView(DetailView detailView) {
        this.detailView = detailView;
    }

    @Override
    public void pause() {

    }

    @Override
    public void destroy() {
        getTodoDataUseCase.dispose();
        detailView = null;
    }


    public void initial(@NonNull int id) {
        loadData(GetTodoData.Param.create(id));
    }

    private void loadData(GetTodoData.Param param) {
        getTodoDataUseCase.execute(new TodoDataObserver(), param);
    }


    private final class TodoDataObserver extends DefaultObserver<Todo> {

        @Override
        public void onComplete() {
            DetailPresenter.this.hideViewLoading();
        }

        @Override
        public void onError(Throwable e) {
            DetailPresenter.this.hideViewLoading();
            DetailPresenter.this.showErrorMessage(new DefaultErrorBundle((Exception) e));
            DetailPresenter.this.showViewRetry();
        }

        @Override
        public void onNext(Todo todos) {
            DetailPresenter.this.showUserData(todos);
        }
    }

    private void showViewRetry() {

    }

    private void showErrorMessage(ErrorBundle errorBundle) {
        String errorMessage = ErrorMessageFactory.create(
                errorBundle.getException());
        this.detailView.showError(errorMessage);
    }

    private void hideViewLoading() {

    }

    private void showUserData(Todo todos) {
        detailView.showView(TodoModelDataMapper.transformTodo(todos));
    }
}
