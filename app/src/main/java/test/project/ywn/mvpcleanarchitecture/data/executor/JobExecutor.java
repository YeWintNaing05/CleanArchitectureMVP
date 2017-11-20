package test.project.ywn.mvpcleanarchitecture.data.executor;


import test.project.ywn.mvpcleanarchitecture.domain.executor.ThreadExecutor;

import android.support.annotation.NonNull;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import javax.inject.Inject;
import javax.inject.Singleton;


/**
 * Created by root on 11/16/17.
 */

@Singleton
public class JobExecutor implements ThreadExecutor {
    private final ThreadPoolExecutor threadPoolExecutor;

    @Inject
    JobExecutor() {
        this.threadPoolExecutor =
                new ThreadPoolExecutor(
                        3, 5, 10L, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>(), new JobThreadFactory());


    }


    @Override
    public void execute(@NonNull Runnable runnable) {
        this.threadPoolExecutor.execute(runnable);
    }

    private static class JobThreadFactory implements ThreadFactory {
        private int counter = 0;

        @Override
        public Thread newThread(@NonNull Runnable runnable) {
            return new Thread(runnable, "android_" + counter++);
        }
    }
}
