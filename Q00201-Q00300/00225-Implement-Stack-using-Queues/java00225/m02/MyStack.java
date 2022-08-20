package java00225.m02;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Description:
 * @Author: alton_z
 * @Create Date Time: 2022-08-20 20:42
 * @Update Date Time: 2022-08-20 20:42
 * @Updated-By: alton_z
 * @Update-Location:
 */
class MyStack {
    Queue<Integer> queue;

    /**
     * 初始化两个队列
     */
    public MyStack() {
        queue = new LinkedList<>();
    }

    /**
     * 入栈
     * 目的： 保证 queue 中的元素符合 queue 特性，后进先出
     * queue 内部进行元素重写
     * @param x
     */
    public void push(int x) {

        int len = queue.size();

        // 将元素 x 放入到 queue
        queue.offer(x);

        for (int i = 0; i < len; i++) {
            queue.offer(queue.poll());
        }

    }

    /**
     * 出栈，取出 queue 头元素并返回
     * 从 queue 中取出元素
     * @return
     */
    public int pop() {
        return queue.poll();
    }

    /**
     * 返回头元素
     * @return
     */
    public int top() {
        return queue.peek();
    }

    /**
     * 判断 queue 是否为空
     * 判断 queue 是否为空，并返回
     * @return
     */
    public boolean empty() {
        return queue.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
