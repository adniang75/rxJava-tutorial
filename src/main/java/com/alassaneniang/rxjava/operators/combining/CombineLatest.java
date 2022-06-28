package com.alassaneniang.rxjava.operators.combining;

import com.alassaneniang.rxjava.observables.DemoObserver;
import com.alassaneniang.rxjava.utils.RxUtils;
import io.reactivex.rxjava3.core.Observable;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Slf4j
public class CombineLatest {

    private static List<Character> changeIt = new ArrayList<>();

    public static void main(String[] args) {

        log.info("Combine Latest Operator");
        Observable observable1 = Observable
                .interval(1, TimeUnit.SECONDS);
        Observable observable2 = Observable
                .interval(2, TimeUnit.SECONDS);
        Observable
                .combineLatest(
                        observable1,
                        observable2,
                        (o1, o2) -> "first: " + o1.toString() + ", second: " + o2.toString())
                .take(6)
                .subscribe(new DemoObserver<>());
        RxUtils.sleep(10);
    }

}
