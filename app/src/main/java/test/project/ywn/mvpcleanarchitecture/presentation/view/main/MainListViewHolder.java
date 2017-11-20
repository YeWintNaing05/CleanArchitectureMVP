package test.project.ywn.mvpcleanarchitecture.presentation.view.main;

import android.view.View;
import android.widget.TextView;

import butterknife.BindView;
import test.project.ywn.mvpcleanarchitecture.R;
import test.project.ywn.mvpcleanarchitecture.presentation.model.TodoModel;
import test.project.ywn.mvpcleanarchitecture.presentation.view.base.BaseViewHolder;

/**
 * Created by root on 11/16/17.
 */

public class MainListViewHolder extends BaseViewHolder<TodoModel> {


    private final MainListAdapter.todoItemClick itemClick;
    @BindView(R.id.tvView)
    TextView tvDesc;

    public MainListViewHolder(View itemView) {
        this(itemView, null);
    }

    public MainListViewHolder(View inflate, MainListAdapter.todoItemClick itemClick) {
        super(inflate);
        this.itemClick = itemClick;
    }

    @Override
    public void bind(TodoModel data) {
        tvDesc.setText(data.title());
    }

    @Override
    public void onClick(View v) {
        itemClick.itemClick(getAdapterPosition());
    }
}
