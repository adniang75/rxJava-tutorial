package com.alassaneniang.rxjava.observables;

import com.alassaneniang.rxjava.utils.RxUtils;
import lombok.extern.slf4j.Slf4j;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import java.util.concurrent.atomic.AtomicInteger;

@Slf4j(topic = "DemoSubscriber")
public class DemoSubscriber<T> implements Subscriber<T> {

    private Subscription subscription;
    private AtomicInteger counter = new AtomicInteger(0);

    @Override
    public void onSubscribe(Subscription subscription) {
        log.info("onSubscribe");
        this.subscription = subscription;
        subscription.request(5);
    }

    @Override
    public void onNext(T t) {
        log.info("onNext -> {}", t);
        RxUtils.sleep(1);
        if (counter.incrementAndGet() % 5 == 0) {
            subscription.request(5);
        }
    }

    @Override
    public void onError(Throwable throwable) {
        log.error("onError -> {}", throwable.getMessage());
    }

    @Override
    public void onComplete() {
        log.info("onComplete");
    }

}
