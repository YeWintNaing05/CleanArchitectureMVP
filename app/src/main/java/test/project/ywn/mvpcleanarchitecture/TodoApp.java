package test.project.ywn.mvpcleanarchitecture;

import android.app.Activity;
import android.app.Application;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;
import test.project.ywn.mvpcleanarchitecture.di.components.DaggerApplicationComponent;
import test.project.ywn.mvpcleanarchitecture.di.module.AppModule;
import test.project.ywn.mvpcleanarchitecture.di.module.RoomModule;

/**
 * Created by root on 11/16/17.
 */

public class TodoApp extends Application implements HasActivityInjector {

    @Inject
    DispatchingAndroidInjector<Activity> dispatchingActivityInjector;

    @Override
    public void onCreate() {
        super.onCreate();
        DaggerApplicationComponent.builder().appModule(new AppModule(this)).roomModule(new RoomModule(this)).build().inject(this);

    }


    @Override
    public AndroidInjector<Activity> activityInjector() {
        return dispatchingActivityInjector;
    }
}
