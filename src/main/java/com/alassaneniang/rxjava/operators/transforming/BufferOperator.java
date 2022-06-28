package com.alassaneniang.rxjava.operators.transforming;

import com.alassaneniang.rxjava.observables.DemoObserver;
import com.alassaneniang.rxjava.utils.RxUtils;
import io.reactivex.rxjava3.core.Observable;
import lombok.extern.slf4j.Slf4j;

@Slf4j(topic = "BufferOperator")
public class BufferOperator {

    public static void main(String[] args) {

        Observable
                .fromIterable(RxUtils.shapes(10))
                .buffer(3)
                .subscribe(new DemoObserver<>());
    }

}
