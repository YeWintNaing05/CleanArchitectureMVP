package test.project.ywn.mvpcleanarchitecture.presentation.view.detail;

import test.project.ywn.mvpcleanarchitecture.presentation.model.TodoModel;
import test.project.ywn.mvpcleanarchitecture.presentation.view.base.BaseView;

/**
 * Created by root on 11/20/17.
 */

interface DetailView extends BaseView {
    void showView(TodoModel model);
}
