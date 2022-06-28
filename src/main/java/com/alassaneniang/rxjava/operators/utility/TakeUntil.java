package com.alassaneniang.rxjava.operators.utility;

import com.alassaneniang.rxjava.observables.DemoObserver;
import com.alassaneniang.rxjava.utils.RxUtils;
import io.reactivex.rxjava3.core.Observable;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

@Slf4j
public class TakeUntil {

    public static void main(String[] args) {
        log.info("TakeUntil Operator");
        Observable<Long> singleSecond = Observable.interval(1, TimeUnit.SECONDS);
        Observable<Long> fiveSecond = Observable.interval(5, TimeUnit.SECONDS);
        singleSecond
                .takeUntil(fiveSecond)
                .subscribe(new DemoObserver<>());
        RxUtils.sleep(15);
    }

}
