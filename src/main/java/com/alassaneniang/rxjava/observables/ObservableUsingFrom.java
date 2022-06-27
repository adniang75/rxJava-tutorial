package com.alassaneniang.rxjava.observables;

import io.reactivex.rxjava3.core.Observable;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Callable;

@Slf4j(topic = "ObservableUsingFrom")
public class ObservableUsingFrom {

    private static String doSomething() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException exception) {
            log.error(exception.getMessage());
        }
        return "Hello";
    }

    public static void main(String[] args) {

        // from Callable
        Callable<String> callable = ObservableUsingFrom::doSomething;
        Observable
                .fromCallable(callable)
                .subscribe(new DemoObserver<>());
    }

}
