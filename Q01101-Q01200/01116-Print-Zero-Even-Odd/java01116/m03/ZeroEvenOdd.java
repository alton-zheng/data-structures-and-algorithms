package java01116.m03;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.IntConsumer;

/**
 * @Author: alton
 * @Date: Created in 7/2/21 6:23 PM
 * @Description:
 * 可重入锁
 */
class ZeroEvenOdd {
    private int n;

    private volatile int curValue = 0;

    private Lock l = new ReentrantLock();
    private Condition z = l.newCondition();
    private Condition o = l.newCondition();
    private Condition e = l.newCondition();

    public ZeroEvenOdd(int n) {
        this.n = n;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        l.lock();
        try {
            for (int i = 1; i <= n; i++) {

                if (curValue != 0) {
                    z.await();
                }
                printNumber.accept(0);

                if (i % 2 == 1) {
                    curValue = 1;
                    o.signal();
                } else {
                    curValue = 2;
                    e.signal();
                }
            }
        } finally {
            l.unlock();
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {

        l.lock();
        try {
            for (int i = 2; i <= n; i += 2) {
                if (curValue != 2) {
                    e.await();
                }
                printNumber.accept(i);
                curValue = 0;
                z.signal();
            }
        } finally {
            l.unlock();
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        l.lock();
        try {
            for (int i = 1; i <= n; i += 2) {

                if (curValue != 1) {
                    o.await();
                }

                printNumber.accept(i);
                curValue = 0;
                z.signal();
            }
        }finally {
            l.unlock();
        }
    }

}
