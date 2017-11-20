package test.project.ywn.mvpcleanarchitecture.data.entity;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;

import com.google.auto.value.AutoValue;

/**
 * Created by root on 11/16/17.
 */
@Entity(tableName = "todo")
public class TodoEntity {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String title;
    private String description;


    @Ignore
    public TodoEntity(int id, String title, String description) {
        this.id = id;
        this.title = title;
        this.description = description;
    }

    public TodoEntity() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}