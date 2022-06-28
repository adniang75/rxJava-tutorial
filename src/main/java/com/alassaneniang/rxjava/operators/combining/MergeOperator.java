package com.alassaneniang.rxjava.operators.combining;

import com.alassaneniang.rxjava.models.Shape;
import com.alassaneniang.rxjava.observables.DemoObserver;
import com.alassaneniang.rxjava.utils.RxUtils;
import io.reactivex.rxjava3.core.Observable;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MergeOperator {

    public static void main(String[] args) {

        log.info("Merge Operator");
        Observable<Shape> observableShapes = Observable
                .fromIterable(RxUtils.shapes(5));
        Observable<Integer> observablePositiveNumbers = Observable
                .fromIterable(RxUtils.positiveNumbers(5));
        Observable
                .merge(observableShapes, observablePositiveNumbers)
                .subscribe(new DemoObserver<>());
    }

}
