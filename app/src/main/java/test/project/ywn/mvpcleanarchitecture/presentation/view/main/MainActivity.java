package test.project.ywn.mvpcleanarchitecture.presentation.view.main;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.Collection;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.OnClick;
import dagger.android.AndroidInjection;
import test.project.ywn.mvpcleanarchitecture.R;
import test.project.ywn.mvpcleanarchitecture.presentation.model.TodoModel;
import test.project.ywn.mvpcleanarchitecture.presentation.view.base.BaseActivity;
import test.project.ywn.mvpcleanarchitecture.presentation.view.base.DialogUtil;
import test.project.ywn.mvpcleanarchitecture.presentation.view.detail.DetailActivity;

public class MainActivity extends BaseActivity implements MainListView, MainListAdapter.todoItemClick {


    @BindView(R.id.rvView)
    RecyclerView rvView;


    @Inject
    MainPresenter presenter;

    @Inject
    MainListAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        presenter.setView(this);
    }


    @Override
    protected void onStart() {
        super.onStart();
        presenter.initialize();

    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }


    @OnClick(R.id.fbBtn)
    void add() {
        //TODO: save Todo

        DialogUtil.insertData(this, new DialogUtil.confirmDelegate() {
            @Override
            public void confirmOk(String title, String desc) {
                presenter.addTodo(TodoModel.create(title, desc));
            }
        });
//        presenter.addTodo(TodoModel.create("test", "dkfjdkjfdf"));
    }

    @Override
    public void showLoading() {
        //TODO Show Loading
    }

    @Override
    public void hideLoading() {
        //TODO hide loading
    }

    @Override
    public void showRetry() {
        //TODO show retry view
    }

    @Override
    public void hideRetry() {
        //TODO hide retry view
    }

    @Override
    public void showError(String message) {
        //TODO show error
    }

    @Override
    public Context context() {
        return this;
    }

    @Override
    public void renderTodoList(Collection<TodoModel> todoModelCollection) {
        adapter.setNewData((List<TodoModel>) todoModelCollection);
        rvView.setAdapter(adapter);
        adapter.setItemClick(this);
        rvView.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false));
    }

    /*@Override
    public void viewTodoList(TodoModel todoModel) {

    }*/

    @Override
    public void itemClick(int adapterPosition) {
        Intent intent = DetailActivity.getIntent(this);
        intent.putExtra("id", adapterPosition + 1);
        startActivity(intent);
    }


}
