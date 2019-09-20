package bit.thread;

/**
 * @Author: yuisama
 * @Date: 2019-05-21 20:57
 * @Description:
 */
class Sleep implements Runnable {
    @Override
    public void run() {
        for (int i = 0;i < 10;i++) {
            try {
                Thread.yield();
                System.out.println(Thread.currentThread().getName()+
                        ",i = "+i);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
public class SleepTest {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("主线程开始");
        Runnable runnable = new Sleep();
        Thread th1 = new Thread(runnable);
        th1.start();
        th1.join();
        System.out.println("主线程执行完毕");
    }
}
