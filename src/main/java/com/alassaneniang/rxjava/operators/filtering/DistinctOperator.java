package com.alassaneniang.rxjava.operators.filtering;

import com.alassaneniang.rxjava.observables.DemoObserver;
import io.reactivex.rxjava3.core.Observable;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DistinctOperator {

    public static void main(String[] args) {

        log.info("Distinct Operator");
        Observable
                .just(1, 2, 3, 2, 4, 1, 2, 3, 4, 5)
                .distinct()
                .subscribe(new DemoObserver<>());

    }

}
