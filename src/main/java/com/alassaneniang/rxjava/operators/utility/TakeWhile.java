package com.alassaneniang.rxjava.operators.utility;

import com.alassaneniang.rxjava.observables.DemoObserver;
import com.alassaneniang.rxjava.utils.RxUtils;
import io.reactivex.rxjava3.core.Observable;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TakeWhile {

    public static void main(String[] args) {
        log.info("TakeWhile Operator");
        Observable
                .fromIterable(RxUtils.positiveNumbers(10))
                .takeWhile(integer -> integer < 4)
                .subscribe(new DemoObserver<>());
    }

}
