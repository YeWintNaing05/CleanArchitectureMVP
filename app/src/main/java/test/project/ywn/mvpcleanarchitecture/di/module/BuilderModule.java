package test.project.ywn.mvpcleanarchitecture.di.module;

import android.app.Activity;

import dagger.Binds;
import dagger.Module;
import dagger.android.ActivityKey;
import dagger.android.AndroidInjector;
import dagger.multibindings.IntoMap;
import test.project.ywn.mvpcleanarchitecture.di.subcomponent.TodoActivitySubComponent;
import test.project.ywn.mvpcleanarchitecture.di.subcomponent.TodoDetailActivitySubCompnent;
import test.project.ywn.mvpcleanarchitecture.presentation.view.detail.DetailActivity;
import test.project.ywn.mvpcleanarchitecture.presentation.view.main.MainActivity;

/**
 * Created by root on 11/20/17.
 */
@Module
public abstract class BuilderModule {
    @Binds
    @IntoMap
    @ActivityKey(MainActivity.class)
    abstract AndroidInjector.Factory<? extends Activity>
    bindYourMainActivityInjectorFactory(TodoActivitySubComponent.Builder builder);


    @Binds
    @IntoMap
    @ActivityKey(DetailActivity.class)
    abstract AndroidInjector.Factory<? extends Activity>
    bindYourDetailActivityInjectorFactory(TodoDetailActivitySubCompnent.Builder builder);


}



