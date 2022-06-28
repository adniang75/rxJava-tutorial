package com.alassaneniang.rxjava.operators.utility;

import com.alassaneniang.rxjava.observables.DemoObserver;
import com.alassaneniang.rxjava.utils.RxUtils;
import io.reactivex.rxjava3.core.Observable;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

@Slf4j
public class DelayOperator {

    public static void main(String[] args) {

        log.info("Delay Operator");
        Observable
                .fromIterable(RxUtils.positiveNumbers(10))
                .delay(3, TimeUnit.SECONDS)
                .subscribe(new DemoObserver<>());
        RxUtils.sleep(5);

    }

}
