package com.alassaneniang.rxjava.operators.combining;

import com.alassaneniang.rxjava.models.Shape;
import com.alassaneniang.rxjava.observables.DemoObserver;
import com.alassaneniang.rxjava.utils.RxUtils;
import io.reactivex.rxjava3.core.Observable;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ZipOperator {

    public static void main(String[] args) {

        log.info("Zip Operator");
        Observable<Shape> shapes = Observable.fromIterable(RxUtils.shapes(5));
        Observable<Integer> numbers = Observable.fromIterable(RxUtils.positiveNumbers(3));
        numbers
                .zipWith(
                        shapes,
                        (o1, o2) -> o1.toString() + ": " + o2.toString())
                .subscribe(new DemoObserver<>());
    }

}
