package test.project.ywn.mvpcleanarchitecture.presentation.model;

import com.google.auto.value.AutoValue;

import test.project.ywn.mvpcleanarchitecture.domain.model.Todo;

/**
 * Created by root on 11/16/17.
 */
@AutoValue
public abstract class TodoModel {


    public abstract String title();

    public abstract String description();

    public static TodoModel create(String title, String description) {
        return new AutoValue_TodoModel(title,description);
    }


}
