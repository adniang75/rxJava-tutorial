package com.alassaneniang.rxjava.operators.transforming;

import com.alassaneniang.rxjava.observables.DemoObserver;
import com.alassaneniang.rxjava.utils.RxUtils;
import io.reactivex.rxjava3.core.Observable;
import lombok.extern.slf4j.Slf4j;

@Slf4j(topic = "MapOperator")
public class MapOperator {

    public static void main(String[] args) {

        Observable
                .fromIterable(RxUtils.positiveNumbers(10))
                .map(integer -> integer * 2)
                .subscribe(new DemoObserver<>());

    }

}
