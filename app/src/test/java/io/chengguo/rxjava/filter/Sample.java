package io.chengguo.rxjava.filter;

import org.junit.Test;

import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.Scheduler;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * 定期发射Observable最近发射的数据项
 */
public class Sample {

    /**
     * Sample操作符定时查看一个Observable，然后发射自上次采样以来它最近发射的数据。
     *
     * @throws InterruptedException
     */
    @Test
    public void sample() throws InterruptedException {
        Observable
                .just(1, 2, 3, 4, 5)
                .sample(1, TimeUnit.MILLISECONDS)
                .subscribe(new Action1<Integer>() {
                    @Override
                    public void call(Integer integer) {
                        System.out.println("subscribe = [" + integer + "]");
                    }
                });
    }

    /**
     * sample的别名
     */
    @Test
    public void throttleLast() {
        Observable
                .just(1, 2, 3, 4, 5)
                .throttleLast(1, TimeUnit.MILLISECONDS)
                .subscribe(new Action1<Integer>() {
                    @Override
                    public void call(Integer integer) {
                        System.out.println("subscribe = [" + integer + "]");
                    }
                });
    }
}