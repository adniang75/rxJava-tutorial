package com.alassaneniang.rxjava.operators.transforming;

import com.alassaneniang.rxjava.observables.DemoObserver;
import com.alassaneniang.rxjava.utils.RxUtils;
import io.reactivex.rxjava3.core.Observable;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j(topic = "ScanOperator")
public class ScanOperator {

    public static void main(String[] args) {

        log.info("Scan Operator");
        List<Integer> numbers = RxUtils.positiveNumbers(10);
        Observable
                .fromIterable(numbers)
                .scan(Integer::sum)
                .subscribe(new DemoObserver<>());

    }

}
