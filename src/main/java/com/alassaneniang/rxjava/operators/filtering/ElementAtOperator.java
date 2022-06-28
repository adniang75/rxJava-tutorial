package com.alassaneniang.rxjava.operators.filtering;

import com.alassaneniang.rxjava.utils.RxUtils;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.disposables.Disposable;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ElementAtOperator {

    public static void main(String[] args) {

        log.info("ElementAt Operator");
        Observable
                .fromIterable(RxUtils.positiveNumbers(10))
                .elementAt(5)
                .subscribe(new MaybeObserver<>() {

                    @Override
                    public void onSubscribe(@NonNull Disposable disposable) {
                        log.info("onSubscribe");
                    }

                    @Override
                    public void onSuccess(@NonNull Integer integer) {
                        log.info("onSuccess -> {}", integer);
                    }

                    @Override
                    public void onError(@NonNull Throwable throwable) {
                        log.info("onError -> {}", throwable.getMessage());
                    }

                    @Override
                    public void onComplete() {
                        log.info("onComplete");
                    }
                });

    }

}
