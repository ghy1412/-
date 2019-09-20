package bit.thread_mutex;

/**
 * @Author: yuisama
 * @Date: 2019-05-24 20:22
 * @Description:
 */

class TicketTask implements Runnable{
    private int ticket = 20000;
    @Override
    public void run() {
        for (int i = 0;i < 20000;i++){
//            // 需要在判断处上"锁"
//            synchronized (this) {
//                // 在任意一个时刻只有一个线程能进入条件判断
//                if (ticket > 0) {
//                    try {
//                        Thread.sleep(20);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                    System.out.println(Thread.currentThread().getName()+
//                            "还剩下"+ticket--+"票");
//                }
//            }
            sellTicket();
        }
    }
    // 在任意时刻，只能有一个线程进入此方法
    public synchronized void sellTicket() {
        if (ticket > 0) {
            System.out.println(Thread.currentThread().getName()+
                    "还剩下"+ticket--+"票");
        }
    }
}

public class SellTicket {
    public static void main(String[] args) {
        TicketTask ticketTask = new TicketTask();
        Thread thread1 = new Thread(ticketTask,"黄牛A");
        Thread thread2 = new Thread(ticketTask,"黄牛B");
        Thread thread3 = new Thread(ticketTask,"黄牛C");
        thread1.start();
        thread2.start();
        thread3.start();
    }
}
