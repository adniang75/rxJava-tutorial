package com.alassaneniang.rxjava.operators.utility;

import com.alassaneniang.rxjava.observables.DemoObserver;
import com.alassaneniang.rxjava.utils.RxUtils;
import io.reactivex.rxjava3.core.Observable;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DoOperator {

    public static void main(String[] args) {

        log.info("Do Operator");
        Observable
                .fromIterable(RxUtils.shapes(10))
                .doOnSubscribe(disposable -> log.info("Stream is subscribed"))
                .doOnEach(notification -> log.info("Current Value is {}", notification.getValue()))
                .doOnNext(shape -> log.info("Shape is {}", shape))
                .doOnComplete(() -> log.info("Completed"))
                .subscribe(new DemoObserver<>());
        RxUtils.sleep(5);

    }

}
