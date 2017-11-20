package test.project.ywn.mvpcleanarchitecture.presentation.view.main;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.ViewGroup;

import javax.inject.Inject;

import test.project.ywn.mvpcleanarchitecture.R;
import test.project.ywn.mvpcleanarchitecture.presentation.model.TodoModel;
import test.project.ywn.mvpcleanarchitecture.presentation.view.base.BaseRecyclerAdapter;

/**
 * Created by root on 11/16/17.
 */

public class MainListAdapter extends BaseRecyclerAdapter<MainListViewHolder, TodoModel> {


    private todoItemClick itemClick;

    @Inject
    public MainListAdapter(Context context) {
        super(context);
    }


    public void setItemClick(todoItemClick itemClick) {
        this.itemClick = itemClick;
    }

    @Override
    public MainListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MainListViewHolder(mLayoutInflater.inflate(R.layout.view_in_main, parent, false), itemClick);
    }

    @Override
    public void onBindViewHolder(@NonNull MainListViewHolder holder, int position) {

        holder.bind(mData.get(position));

    }

    interface todoItemClick {
        void itemClick(int adapterPosition);
    }
}
