package com.alassaneniang.rxjava.observables;

import com.alassaneniang.rxjava.utils.RxUtils;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;
import lombok.extern.slf4j.Slf4j;

@Slf4j(topic = "ObservableWithoutBackpressure")
public class ObservableWithoutBackpressure {

    public static void main(String[] args) {

        Observable<Integer> positiveNumberEvents = Observable
                .fromIterable(RxUtils.positiveNumbers(1000000))
                .repeat()
                .observeOn(Schedulers.newThread())
                .subscribeOn(Schedulers.newThread());
        positiveNumberEvents
                .subscribe(new DemoObserver<>());
        RxUtils.sleep(50);
    }

}
