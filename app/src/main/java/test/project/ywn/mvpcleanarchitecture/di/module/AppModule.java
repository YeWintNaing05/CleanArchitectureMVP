package test.project.ywn.mvpcleanarchitecture.di.module;

import android.app.Application;
import android.app.job.JobService;
import android.arch.persistence.room.Room;
import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import test.project.ywn.mvpcleanarchitecture.TodoApp;
import test.project.ywn.mvpcleanarchitecture.UiThread;
import test.project.ywn.mvpcleanarchitecture.data.db.TodoDatabase;
import test.project.ywn.mvpcleanarchitecture.data.executor.JobExecutor;
import test.project.ywn.mvpcleanarchitecture.data.repository.TodoDataRepository;
import test.project.ywn.mvpcleanarchitecture.di.subcomponent.TodoActivitySubComponent;
import test.project.ywn.mvpcleanarchitecture.di.subcomponent.TodoDetailActivitySubCompnent;
import test.project.ywn.mvpcleanarchitecture.domain.executor.PostExecutionThread;
import test.project.ywn.mvpcleanarchitecture.domain.executor.ThreadExecutor;
import test.project.ywn.mvpcleanarchitecture.domain.repository.TodoRepository;

/**
 * Created by root on 11/20/17.
 */

@Module(subcomponents = {TodoActivitySubComponent.class, TodoDetailActivitySubCompnent.class})
public class AppModule {


    private TodoApp mApplication;

    public AppModule(TodoApp application) {
        mApplication = application;
    }

    @Provides
    Context provideContext() {
        return mApplication.getApplicationContext();
    }

    @Singleton
    @Provides
    ThreadExecutor provideExecutor(JobExecutor executor) {
        return executor;
    }

    @Singleton
    @Provides
    PostExecutionThread providePostExecutionThread(UiThread thread) {
        return thread;
    }


}