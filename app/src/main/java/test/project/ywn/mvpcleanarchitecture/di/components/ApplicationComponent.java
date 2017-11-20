package test.project.ywn.mvpcleanarchitecture.di.components;


import android.app.Application;
import android.content.Context;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.support.AndroidSupportInjectionModule;
import test.project.ywn.mvpcleanarchitecture.TodoApp;
import test.project.ywn.mvpcleanarchitecture.data.db.TodoDatabase;
import test.project.ywn.mvpcleanarchitecture.data.db.TodoEntityDao;
import test.project.ywn.mvpcleanarchitecture.di.module.AppModule;
import test.project.ywn.mvpcleanarchitecture.di.module.BuilderModule;
import test.project.ywn.mvpcleanarchitecture.di.module.RoomModule;
import test.project.ywn.mvpcleanarchitecture.domain.repository.TodoRepository;

/**
 * Created by root on 11/16/17.
 */

@Singleton
@Component(modules = {AndroidSupportInjectionModule.class,
        AppModule.class,
        RoomModule.class,
        BuilderModule.class})
public interface ApplicationComponent {


    TodoEntityDao productDao();

    TodoDatabase demoDatabase();

    TodoRepository productRepository();

    Context application();

    void inject(TodoApp app);


}
