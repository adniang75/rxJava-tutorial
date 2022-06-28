package com.alassaneniang.rxjava.operators.utility;

import com.alassaneniang.rxjava.observables.DemoObserver;
import com.alassaneniang.rxjava.utils.RxUtils;
import io.reactivex.rxjava3.core.Observable;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TimestampOperator {

    public static void main(String[] args) {

        log.info("Timestamp Operator");
        Observable
                .fromIterable(RxUtils.shapes(10))
                .timestamp()
                .subscribe(new DemoObserver<>());

    }

}
