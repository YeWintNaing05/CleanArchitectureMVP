package test.project.ywn.mvpcleanarchitecture.data.db;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.Observable;
import io.reactivex.Single;
import test.project.ywn.mvpcleanarchitecture.data.entity.TodoEntity;

import static android.arch.persistence.room.OnConflictStrategy.REPLACE;

/**
 * Created by root on 11/16/17.
 */
@Dao
public interface TodoEntityDao {

    @Query("SELECT * FROM todo")
    Single<List<TodoEntity>> getTodoEntityList();


    @Query("SELECT * FROM todo WHERE id =:id")
    Single<TodoEntity> getTodoById(int id);


    @Insert(onConflict = REPLACE)
    void addTodoEntity(TodoEntity todo);

    @Delete
    void deleteTodoEntity(TodoEntity todo);

    @Update(onConflict = REPLACE)
    void updateTodoEntity(TodoEntity todo);
}
