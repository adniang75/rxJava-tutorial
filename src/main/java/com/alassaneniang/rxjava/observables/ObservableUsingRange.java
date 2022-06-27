package com.alassaneniang.rxjava.observables;

import io.reactivex.rxjava3.core.Observable;
import lombok.extern.slf4j.Slf4j;

@Slf4j(topic = "ObservableUsingRange")
public class ObservableUsingRange {

    public static void main(String[] args) {

        Observable
                .range(1, 10)
                .subscribe(new DemoObserver<>());

    }

}
