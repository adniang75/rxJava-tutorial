package com.alassaneniang.rxjava.operators.filtering;

import com.alassaneniang.rxjava.utils.RxUtils;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.disposables.Disposable;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class IgnoreElementsOperator {

    public static void main(String[] args) {

        log.info("IgnoreElements Operator");
        Observable
                .fromIterable(RxUtils.primeNumbers(10))
                .ignoreElements()
                .subscribe(new CompletableObserver() {

                    @Override
                    public void onSubscribe(@NonNull Disposable disposable) {
                        log.info("onSubscribe");
                    }

                    @Override
                    public void onComplete() {
                        log.info("onComplete");
                    }

                    @Override
                    public void onError(@NonNull Throwable throwable) {
                        log.info("onError -> {}", throwable.getMessage());
                    }
                });


    }

}
