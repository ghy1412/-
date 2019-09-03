package com.cn;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

public class Test {
    public static void main(String[] args) {
        FutureTask<String> stringFutureTask1 = new FutureTask<>(new Task2());
        FutureTask<String> stringFutureTask = new FutureTask<>(new Task1(stringFutureTask1));


        new Thread(stringFutureTask).start();

    }
}

class Task1 implements Callable<String>{
    FutureTask<String> futureTask ;

    public Task1(FutureTask<String> futureTask) {
        this.futureTask = futureTask;
    }

    @Override
    public String call() throws Exception {
        System.out.println("洗茶壶...");
        Thread.sleep(100);
        System.out.println("烧开水...");
        TimeUnit.SECONDS.sleep(1);
        return "拿到"+"泡茶" ;
    }
}

class Task2 implements Callable<String>{
    @Override
    public String call() throws Exception {
        System.out.println("买茶叶...");
Thread.sleep(300);
        System.out.println("买到龙井茶叶....");
        return "龙井茶叶";
    }
}
