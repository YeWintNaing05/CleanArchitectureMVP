package test.project.ywn.mvpcleanarchitecture.presentation.view.main;

import java.util.Collection;

import test.project.ywn.mvpcleanarchitecture.presentation.model.TodoModel;
import test.project.ywn.mvpcleanarchitecture.presentation.view.base.BaseView;

/**
 * Created by root on 11/16/17.
 */

public interface MainListView extends BaseView {

    void renderTodoList(Collection<TodoModel> todoModelCollection);

   // void viewTodoList(TodoModel todoModel);

}
