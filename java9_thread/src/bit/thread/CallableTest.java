package bit.thread;

import java.util.concurrent.*;

/**
 * @Author: yuisama
 * @Date: 2019-05-21 19:51
 * @Description:
 */
class CallableThread implements Callable<String> {
    private int ticket = 20;
    @Override
    // 线程需要执行的任务
    public String call() throws Exception {
        while (ticket > 0) {
            System.out.println("当前线程为:"+Thread.currentThread().getName()+
                    "还剩下"+ticket--+"票");
        }
        return "票卖完了～客官明天再来～";
    }
}
public class CallableTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // 产生Callable对象
        CallableThread callableThread = new CallableThread();
        // 产生FutureTask对象
        FutureTask<String> futureTask = new FutureTask<>(callableThread);
        Thread thread = new Thread(futureTask);
        Thread thread1 = new Thread(futureTask);
        thread.start();
        thread1.start();
        System.out.println(futureTask.get());
    }
}
