package test.project.ywn.mvpcleanarchitecture.domain.executor;

import io.reactivex.Scheduler;

/**
 * Created by root on 11/16/17.
 */
public interface PostExecutionThread {
    Scheduler getScheduler();
}
