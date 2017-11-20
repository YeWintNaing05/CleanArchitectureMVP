package test.project.ywn.mvpcleanarchitecture.di.subcomponent;

import javax.inject.Singleton;

import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import test.project.ywn.mvpcleanarchitecture.presentation.view.main.MainActivity;

/**
 * Created by root on 11/20/17.
 */

@Subcomponent
public interface TodoActivitySubComponent extends AndroidInjector<MainActivity> {
    @Subcomponent.Builder
    public abstract class Builder extends AndroidInjector.Builder<MainActivity> {}



}
