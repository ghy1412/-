package com.cn;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


class Goods{
    //商品名称
    private String name;
    //当前商品数量
    private int count;
    //最大商品数量
    private int maxCount;
    public Goods(int maxCount){
        this.maxCount = maxCount;
    }
    private Lock lock = new ReentrantLock();
    private Condition consumer = lock.newCondition();

    private Condition producer = lock.newCondition();

    /*
    * 生产方法
    * @param name 生产商品的名称
    * */
    public void setGoods(String name){
        lock.lock();
        try {
            while (maxCount == count){
                System.out.println(Thread.currentThread().getName()+"商品制造已经达到最大,等待消费者消费");
                producer.await();
            }
            Thread.sleep(200);
            //生产商品
            this.name = name;
            count++;
            System.out.println(Thread.currentThread().getName()+"生产"+toString());
            //唤醒消费者线程
            consumer.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }


    public void getGoods(){
        lock.lock();
        try {
            //商品为0时阻塞消费者线程
            while (count == 0){
                System.out.println(Thread.currentThread().getName()+"商品已经被消费完,等待生产者生产");
                consumer.await();
            }
            Thread.sleep(200);
            count--;
            System.out.println(Thread.currentThread().getName()+"消费"+toString());
            //唤醒生产者
            producer.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    @Override
    public String toString() {
        return "Goods{" +
                "name='" + name + '\'' +
                ", count=" + count +
                '}';
    }
}

class Producer implements Runnable{

    private Goods goods;

    public Producer(Goods goods) {
        this.goods = goods;
    }

    @Override
    public void run() {
        while (true){
            this.goods.setGoods("纪梵希限量版圣诞套装口红");
        }
    }
}

class Consumer implements Runnable{
    private Goods goods;

    public Consumer(Goods goods) {
        this.goods = goods;
    }

    @Override
    public void run() {
        while (true){
            this.goods.getGoods();
        }
    }
}

public class Test1{
    public static void main(String[] args) {
         List<Thread> lists = new ArrayList<>();
        Goods goods = new Goods(10);
        Producer producer = new Producer(goods);
        Consumer consumer = new Consumer(goods);

        //创建十个消费者线程

        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(consumer, "消费者" + i);
            lists.add(thread);
        }

        //创建五个生产者线程

        for (int i = 0; i < 5; i++) {
            Thread thread = new Thread(producer, "生产者" + i);
            lists.add(thread);
        }

        for (Thread th : lists){
            th.start();
        }
    }
}