package com.alassaneniang.rxjava.observables;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import lombok.extern.slf4j.Slf4j;

@Slf4j(topic = "DemoObserver")
public class DemoObserver<T> implements Observer<T> {

    @Override
    public void onSubscribe(@NonNull Disposable disposable) {
        log.info("onSubscribe");
    }

    @Override
    public void onNext(@NonNull T object) {
        log.info("onNext -> {}", object);
    }

    @Override
    public void onError(@NonNull Throwable throwable) {
        log.info("onError {}", throwable.getMessage());
    }

    @Override
    public void onComplete() {
        log.info("onComplete");
    }

}
