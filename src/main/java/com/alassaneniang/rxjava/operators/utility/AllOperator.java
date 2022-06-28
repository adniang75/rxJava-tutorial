package com.alassaneniang.rxjava.operators.utility;

import com.alassaneniang.rxjava.utils.RxUtils;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AllOperator {

    public static void main(String[] args) {

        log.info("All Operator");
        Observable
                .fromIterable(RxUtils.positiveNumbers(10))
                .all(integer -> integer > 5)
                .subscribe(new SingleObserver<>() {

                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onSuccess(@NonNull Boolean result) {
                        log.info("Do all of the events are greater than 5 -> {}", result);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {

                    }
                });

    }

}
