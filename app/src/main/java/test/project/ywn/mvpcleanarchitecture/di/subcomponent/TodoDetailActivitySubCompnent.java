package test.project.ywn.mvpcleanarchitecture.di.subcomponent;

import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import test.project.ywn.mvpcleanarchitecture.presentation.view.detail.DetailActivity;

/**
 * Created by root on 11/20/17.
 */

@Subcomponent
public interface TodoDetailActivitySubCompnent extends AndroidInjector<DetailActivity> {
    @Subcomponent.Builder
    public abstract class Builder extends AndroidInjector.Builder<DetailActivity> {}



}