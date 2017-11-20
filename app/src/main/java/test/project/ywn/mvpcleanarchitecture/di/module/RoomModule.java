package test.project.ywn.mvpcleanarchitecture.di.module;

import android.app.Application;
import android.arch.persistence.room.Room;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import test.project.ywn.mvpcleanarchitecture.data.db.TodoDatabase;
import test.project.ywn.mvpcleanarchitecture.data.db.TodoEntityDao;
import test.project.ywn.mvpcleanarchitecture.data.repository.TodoDataRepository;
import test.project.ywn.mvpcleanarchitecture.domain.model.Todo;
import test.project.ywn.mvpcleanarchitecture.domain.repository.TodoRepository;

/**
 * Created by root on 11/20/17.
 */

@Module
public class RoomModule {

    private TodoDatabase demoDatabase;

    public RoomModule(Application mApplication) {
        demoDatabase = Room.databaseBuilder(mApplication, TodoDatabase.class, "todo-db").allowMainThreadQueries().build();
    }

    @Singleton
    @Provides
    TodoDatabase providesRoomDatabase() {
        return demoDatabase;
    }

    @Singleton
    @Provides
    TodoEntityDao providesProductDao(TodoDatabase demoDatabase) {
        return demoDatabase.todoDao();
    }

    @Singleton
    @Provides
    TodoRepository productRepository(TodoEntityDao productDao) {
        return new TodoDataRepository(productDao);
    }
}
