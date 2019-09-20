package bit.thread;

/**
 * @Author: yuisama
 * @Date: 2019-05-21 18:51
 * @Description:
 */
class MyThread implements Runnable {
    private int ticket = 20;
    @Override
    // 此方法为每个线程都需要执行的任务
    public void run() {
        while (ticket > 0) {
            System.out.println("当前线程为:"+Thread.currentThread().getName()+",还剩下"+ticket--+"票");
        }
    }
}
public class ThreadTest {
    public static void main(String[] args) {
        MyThread mt1 = new MyThread();
        Thread thread1 = new Thread(mt1);
        Thread thread2 = new Thread(mt1);
        Thread thread3 = new Thread(mt1);
        thread1.start();
        thread2.start();
        thread3.start();
    }
}
