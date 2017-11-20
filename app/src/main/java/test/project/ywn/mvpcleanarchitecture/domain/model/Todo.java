package test.project.ywn.mvpcleanarchitecture.domain.model;

import com.google.auto.value.AutoValue;

/**
 * Created by root on 11/16/17.
 */
@AutoValue
public abstract class Todo {


    public abstract String title();

    public abstract String description();
    public static Todo create(String title,String description) {
        return new AutoValue_Todo(title,description);
    }
}
