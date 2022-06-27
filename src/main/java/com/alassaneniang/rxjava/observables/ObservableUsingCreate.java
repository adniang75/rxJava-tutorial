package com.alassaneniang.rxjava.observables;

import com.alassaneniang.rxjava.models.Shape;
import com.alassaneniang.rxjava.utils.RxUtils;
import io.reactivex.rxjava3.core.Observable;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j(topic = "ObservableUsingCreate")
public class ObservableUsingCreate {

    public static void main(String[] args) {

        List<Shape> shapes = RxUtils.shapes(5);
        Observable
                .create(emitter -> {
                    try {
                        shapes.forEach(emitter::onNext);
                    } catch (Exception exception) {
                        emitter.onError(exception);
                    }
                    emitter.onComplete();
                })
                .subscribe(new DemoObserver<>());

    }

}
