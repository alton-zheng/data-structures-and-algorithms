package java01115.m02;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: alton
 * @Date: Created in 2021/8/12 下午12:18
 * @Description:
 *
 * 1115. Print FooBar Alternately #300
 *
 * Suppose you are given the following code:
 *
 * class FooBar {
 *   public void foo() {
 *     for (int i = 0; i < n; i++) {
 *       print("foo");
 *     }
 *   }
 *
 *   public void bar() {
 *     for (int i = 0; i < n; i++) {
 *       print("bar");
 *     }
 *   }
 * }
 * The same instance of FooBar will be passed to two different threads:
 *
 * thread A will call foo(), while
 * thread B will call bar().
 * Modify the given program to output "foobar" n times.
 *
 *
 *
 * Example 1:
 *
 * Input: n = 1
 * Output: "foobar"
 * Explanation: There are two threads being fired asynchronously. One of them calls foo(), while the other calls bar().
 * "foobar" is being output 1 time.
 * Example 2:
 *
 * Input: n = 2
 * Output: "foobarfoobar"
 * Explanation: "foobar" is being output 2 times.
 *
 *
 * Constraints:
 *
 * 1 <= n <= 1000
 *
 * Runtime: 17 ms, faster than 98.62% of Java online submissions for Print FooBar Alternately.
 * Memory Usage: 39.3 MB, less than 29.12% of Java online submissions for Print FooBar Alternately.
 */
class FooBar {
    private int n;

    private static final Lock lock = new ReentrantLock();
    private static final Condition foo = lock.newCondition();
    private static final Condition bar = lock.newCondition();
    private boolean flag = false;

    public FooBar(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {

            lock.lock();
            while (flag) {
                foo.await();
            }

            // printFoo.run() outputs "foo". Do not change or remove this line.
            printFoo.run();
            bar.signal();
            flag = true;
            lock.unlock();
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {

            lock.lock();
            while (!flag) {
                bar.await();
            }

            // printBar.run() outputs "bar". Do not change or remove this line.
            printBar.run();
            foo.signal();
            flag = false;
            lock.unlock();
        }
    }
}
