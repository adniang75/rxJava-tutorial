package com.alassaneniang.rxjava.operators.transforming;

import com.alassaneniang.rxjava.models.Shape;
import com.alassaneniang.rxjava.observables.DemoObserver;
import com.alassaneniang.rxjava.utils.RxUtils;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.observables.GroupedObservable;
import io.reactivex.rxjava3.schedulers.Schedulers;
import lombok.extern.slf4j.Slf4j;

@Slf4j(topic = "GroupByOperator")
public class GroupByOperator {

    public static void main(String[] args) {

        Observable
                .fromIterable(RxUtils.shapes(20))
                .groupBy(Shape::getShape)
                .observeOn(Schedulers.newThread())
                .subscribe(new Observer<>() {

                    @Override
                    public void onSubscribe(@NonNull Disposable disposable) {
                    }

                    @Override
                    public void onNext(@NonNull GroupedObservable<String, Shape> stringShapeGroupedObservable) {
                        log.info("key {}", stringShapeGroupedObservable.getKey());
                        stringShapeGroupedObservable.subscribe(new DemoObserver<>());
                    }

                    @Override
                    public void onError(@NonNull Throwable throwable) {
                    }

                    @Override
                    public void onComplete() {
                    }
                });
        RxUtils.sleep(10);

    }

}
