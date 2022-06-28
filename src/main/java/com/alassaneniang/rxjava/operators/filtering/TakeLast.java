package com.alassaneniang.rxjava.operators.filtering;

import com.alassaneniang.rxjava.observables.DemoObserver;
import com.alassaneniang.rxjava.utils.RxUtils;
import io.reactivex.rxjava3.core.Observable;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TakeLast {

    public static void main(String[] args) {

        log.info("Take Last Operator");
        Observable
                .fromIterable(RxUtils.positiveNumbers(10))
                .takeLast(5)
                .subscribe(new DemoObserver<>());

    }

}
