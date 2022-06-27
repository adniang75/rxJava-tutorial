package com.alassaneniang.rxjava.observables;

import com.alassaneniang.rxjava.utils.RxUtils;
import io.reactivex.rxjava3.core.Observable;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

@Slf4j(topic = "ObservableUsingTimer")
public class ObservableUsingTimer {

    public static void main(String[] args) {

        Observable.timer(5, TimeUnit.SECONDS)
                .subscribe(new DemoObserver<>());
        RxUtils.sleep(10);
    }

}
