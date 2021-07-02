package java01116.m02;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.util.function.IntConsumer;

/**
 * @Author: alton
 * @Date: Created in 7/2/21 6:23 PM
 * @Description:
 * Runtime: 7 ms, faster than 99.86% of Java online submissions for Print Zero Even Odd.
 * Memory Usage: 38.2 MB, less than 55.52% of Java online submissions for Print Zero Even Odd.
 */
class ZeroEvenOdd {
    private int n;

    // 方法二： 不用锁，直接用 volatile
    private volatile int curValue = 0;

    public ZeroEvenOdd(int n) {
        this.n = n;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {

        for (int i = 1; i <= n; i++) {
            while (curValue != 0) {
                Thread.yield();
            }

            printNumber.accept(0);

            if (i % 2 == 1) {
                curValue = 1;
            } else {
                curValue = 2;
            }

        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        for (int i = 2; i <= n; i += 2) {
            while (curValue != 2) {
                Thread.yield();
            }

            printNumber.accept(i);
            curValue = 0;
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i += 2) {
            while (curValue != 1) {
                Thread.yield();
            }

            printNumber.accept(i);
            curValue = 0;
        }
    }

    public static void main(String[] args) {
        java01116.m02.ZeroEvenOdd zeroEvenOdd = new java01116.m02.ZeroEvenOdd(5);
        new Thread(
                () -> {
                    try {
                        zeroEvenOdd.zero(System.out::print);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
        ).start();
        new Thread(
                () -> {
                    try {
                        zeroEvenOdd.even(System.out::print);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
        ).start();
        new Thread(
                () -> {
                    try {
                        zeroEvenOdd.odd(System.out::print);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
        ).start();
    }
}
