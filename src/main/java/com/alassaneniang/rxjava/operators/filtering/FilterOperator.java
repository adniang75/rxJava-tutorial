package com.alassaneniang.rxjava.operators.filtering;

import com.alassaneniang.rxjava.models.Shape;
import com.alassaneniang.rxjava.observables.DemoObserver;
import com.alassaneniang.rxjava.utils.RxUtils;
import io.reactivex.rxjava3.core.Observable;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public class FilterOperator {

    public static void main(String[] args) {

        log.info("Filter Operator");
        List<Shape> shapes = RxUtils.shapes(10);
        shapes
                .stream()
                .filter(shape -> shape.getColor().equals("blue"))
                .forEach(shape -> log.info("shape -> {}", shape));
        log.info("");
        Observable
                .fromIterable(shapes)
                .filter(shape -> shape.getColor().equals("blue"))
                .subscribe(new DemoObserver<>());


    }

}
