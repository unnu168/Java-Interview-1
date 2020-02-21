/**
 * @program JavaBooks
 * @description: 测试
 * @author: mf
 * @create: 2020/05/24 00:04
 */

package Test;

import java.util.concurrent.TimeUnit;

public class Test {
    private static Object res1 = new Object();
    private static Object res2 = new Object();

    public static void main(String[] args) {
        new Thread(() -> {
            synchronized (res1) {
                System.out.println(Thread.currentThread().getName() + " res1");
                // 延迟一下, 确保B拿到了res2
                try { TimeUnit.SECONDS.sleep(1); } catch (InterruptedException e) { e.printStackTrace(); }
                synchronized (res2) {
                    System.out.println(Thread.currentThread().getName() + " res2");
                }
            }
        }, "ThreadA").start();

        new Thread(() -> {
            synchronized (res2) {
                System.out.println(Thread.currentThread().getName() + " res2");
                // 延迟一下，确保A拿到了res1
                synchronized (res1) {
                    System.out.println(Thread.currentThread().getName() + " res1");
                }
            }
        }, "ThreadB").start();
    }
}
