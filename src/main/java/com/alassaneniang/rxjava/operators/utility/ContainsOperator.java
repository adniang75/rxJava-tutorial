package com.alassaneniang.rxjava.operators.utility;

import com.alassaneniang.rxjava.utils.RxUtils;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ContainsOperator {

    public static void main(String[] args) {

        log.info("Contains Operator");
        Observable
                .fromIterable(RxUtils.positiveNumbers(10))
                .contains(10)
                .subscribe(new SingleObserver<>() {

                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onSuccess(@NonNull Boolean result) {
                        log.info("element present -> {}", result);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {

                    }
                });
    }

}
