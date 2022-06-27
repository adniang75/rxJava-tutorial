package com.alassaneniang.rxjava.observables;

import com.alassaneniang.rxjava.utils.RxUtils;
import io.reactivex.rxjava3.core.Observable;
import lombok.extern.slf4j.Slf4j;

@Slf4j(topic = "ObservableUsingDefer")
public class ObservableUsingDefer {

    public static void main(String[] args) {
        Observable<Integer> observableUsingDefer = Observable
                .defer(
                        () -> Observable.fromIterable(RxUtils.positiveNumbers(5))
                );
        observableUsingDefer.subscribe(new DemoObserver<>());
        observableUsingDefer.subscribe(new DemoObserver<>());
    }

}
