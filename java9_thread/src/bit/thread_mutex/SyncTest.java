package bit.thread_mutex;

/**
 * @Author: yuisama
 * @Date: 2019-05-24 21:13
 * @Description:
 */
class Sync {
    public static synchronized void test() throws InterruptedException {
        System.out.println(Thread.currentThread().getName()+"正在打印...");
        Thread.sleep(1000);
        System.out.println(Thread.currentThread().getName()+"执行结束...");
    }
}
class Task implements Runnable {
    @Override
    public void run() {
        try {
            Sync sync = new Sync();
            sync.test();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
public class SyncTest {
    public static void main(String[] args) {
        Task task = new Task();
        new Thread(task).start();
        new Thread(task).start();
        new Thread(task).start();
    }
}
