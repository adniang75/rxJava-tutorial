package com.alassaneniang.rxjava.operators.transforming;

import com.alassaneniang.rxjava.observables.DemoObserver;
import com.alassaneniang.rxjava.utils.RxUtils;
import io.reactivex.rxjava3.core.Observable;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j(topic = "FlatMapOperator")
public class FlatMapOperator {

    public static void main(String[] args) {

        List<Integer> positiveIntegers = RxUtils.positiveNumbers(10);
        Observable
                .fromIterable(positiveIntegers)
                .flatMap(FlatMapOperator::twice)
                .subscribe(new DemoObserver<>());
        RxUtils.sleep(10);

    }

    public static Observable<Integer> twice(Integer integer) {
        return Observable.create(emitter -> {
            if (!emitter.isDisposed()) {
                emitter.onNext(integer * 2);
            } else {
                emitter.onComplete();
            }
        });
    }

}
