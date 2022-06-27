package com.alassaneniang.rxjava.observables;

import io.reactivex.rxjava3.core.Observable;
import lombok.extern.slf4j.Slf4j;

@Slf4j(topic = "ObservableUsingJust")
public class ObservableUsingJust {

    public static void main(String[] args) {

        Observable
                .just("a", "b", "c", "d", "e", "f", "g", "h", "i", "j")
                .subscribe(new DemoObserver<>());

    }

}
