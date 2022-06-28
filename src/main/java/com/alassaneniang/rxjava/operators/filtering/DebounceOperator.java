package com.alassaneniang.rxjava.operators.filtering;

import com.alassaneniang.rxjava.observables.DemoObserver;
import com.alassaneniang.rxjava.utils.RxUtils;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

@Slf4j
public class DebounceOperator {

    private static List<Character> changeIt = new ArrayList<>();

    public static void main(String[] args) {

        log.info("Debounce Operator");
        Random random = new Random();
        Observable
                .interval(2, TimeUnit.SECONDS)
                .map(c -> {
                    changeIt.add((char) (random.nextInt(26) + 'a'));
                    return changeIt;
                })
                .doOnEach(notification -> log.info("Current Value -> {}", notification))
                .debounce(1, TimeUnit.SECONDS)
                .subscribeOn(Schedulers.newThread())
                .observeOn(Schedulers.newThread())
                .subscribe(new DemoObserver<>());
        RxUtils.sleep(30);

    }

}
