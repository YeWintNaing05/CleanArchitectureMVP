package test.project.ywn.mvpcleanarchitecture.presentation.view.detail;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import javax.inject.Inject;

import butterknife.BindView;
import dagger.android.AndroidInjection;
import test.project.ywn.mvpcleanarchitecture.R;
import test.project.ywn.mvpcleanarchitecture.presentation.model.TodoModel;
import test.project.ywn.mvpcleanarchitecture.presentation.view.base.BaseActivity;

public class DetailActivity extends BaseActivity implements DetailView {

    @Inject
    DetailPresenter presenter;


    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.desc)
    TextView tvDesc;

    public static Intent getIntent(Activity activity) {
        return new Intent(activity, DetailActivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);

        init();


        presenter.setDetailView(this);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_detail;
    }


    void init() {
        //Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }


    @Override
    protected void onStart() {
        super.onStart();

        presenter.initial(getIntent().getExtras().getInt("id"));
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showRetry() {

    }

    @Override
    public void hideRetry() {

    }

    @Override
    public void showError(String message) {
    }

    @Override
    public Context context() {
        return this;
    }

    @Override
    public void showView(TodoModel model) {
        tvDesc.setText(model.description());
        toolbar.setTitle(model.title());
    }
}
