package bit.thread;

/**
 * @Author: yuisama
 * @Date: 2019-05-24 18:43
 * @Description:
 */
class ThreadShutDown implements Runnable {
    private boolean flag = true;
    public void setFlag(boolean flag) {
        this.flag = flag;
    }
    @Override
    public void run() {
        int i = 0;
        while (flag) {
//            try {
//                Thread.sleep(200);
//                boolean bool = Thread.currentThread().isInterrupted();
//                if (bool) {
//                    System.out.println("线程已被置为中断状态");
//                    return;
//                }
//                System.out.println("当前线程状态为"+bool);
//                System.out.println(Thread.currentThread().getName()
//                        +","+i++);
//            } catch (InterruptedException e) {
//                System.out.println("抛出中断异常");
//                return;
//            }
            try {
                Thread.sleep(1000000000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("线程停止");
    }
}
public class ThreadStop {
    public static void main(String[] args) throws InterruptedException {
        ThreadShutDown threadShutDown = new ThreadShutDown();
        Thread thread = new Thread(threadShutDown);
        thread.start();
        Thread.sleep(200);
        threadShutDown.setFlag(false);
    }
}
