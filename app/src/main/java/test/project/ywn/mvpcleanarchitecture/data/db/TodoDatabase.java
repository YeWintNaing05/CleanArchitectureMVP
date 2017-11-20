package test.project.ywn.mvpcleanarchitecture.data.db;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;


import test.project.ywn.mvpcleanarchitecture.data.entity.TodoEntity;

/**
 * Created by root on 11/16/17.
 */


@Database(entities = {TodoEntity.class}, version = 1)
public abstract class TodoDatabase extends RoomDatabase {


    public abstract TodoEntityDao todoDao();


}
