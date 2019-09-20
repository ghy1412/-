package bit.thread;

/**
 * @Author: yuisama
 * @Date: 2019-05-21 20:48
 * @Description:
 */
class NameThread implements Runnable {
    @Override
    public void run() {
        for (int i = 0;i < 10;i++) {
            System.out.println(Thread.currentThread().getName()
                    +",i = "+i);
        }
    }
}

public class ThreadName {
    public static void main(String[] args) {
        Runnable runnable = new NameThread();
        Thread thread1 = new Thread(runnable);
        Thread thread2 = new Thread(runnable);
        thread1.start();
        thread2.start();
    }
}
