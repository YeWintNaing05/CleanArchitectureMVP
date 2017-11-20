package test.project.ywn.mvpcleanarchitecture;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import test.project.ywn.mvpcleanarchitecture.domain.executor.PostExecutionThread;

/**
 * Created by root on 11/16/17.
 */

@Singleton
public class UiThread implements PostExecutionThread {

    @Inject
    UiThread() {}

    @Override public Scheduler getScheduler() {
        return AndroidSchedulers.mainThread();
    }
}