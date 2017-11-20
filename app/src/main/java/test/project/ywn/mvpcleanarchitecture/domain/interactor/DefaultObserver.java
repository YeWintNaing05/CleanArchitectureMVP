package test.project.ywn.mvpcleanarchitecture.domain.interactor;

import io.reactivex.observers.DisposableObserver;

/**
 * Created by root on 11/16/17.
 */

public class DefaultObserver<T> extends DisposableObserver<T> {
    @Override
    public void onNext(T t) {

    }

    @Override
    public void onError(Throwable e) {

    }

    @Override
    public void onComplete() {

    }
}
