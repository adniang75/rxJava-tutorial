package com.alassaneniang.rxjava.observables;

import com.alassaneniang.rxjava.utils.RxUtils;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.schedulers.Schedulers;
import lombok.extern.slf4j.Slf4j;

@Slf4j(topic = "FlowableWithBackPressure")
public class FlowableWithBackPressure {

    public static void main(String[] args) {

        Flowable<Integer> flowablePositiveNumbers = Flowable
                .fromIterable(RxUtils.positiveNumbers(1000000))
                .repeat()
                .observeOn(Schedulers.newThread(), false, 5)
                .subscribeOn(Schedulers.newThread())
                .doOnNext(integer -> log.info("emitting integer -> {}", integer));
        flowablePositiveNumbers
                .subscribe(new DemoSubscriber<>());
        RxUtils.sleep(10);

    }

}
