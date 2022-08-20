package java00225.m01;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Description:
 * @Author: alton_z
 * @Create Date Time: 2022-08-20 20:42
 * @Update Date Time: 2022-08-20 20:42
 * @Updated-By: alton_z
 * @Update-Location:
 * 225. Implement Stack using Queues #438
 *
 * 请你仅使用两个队列实现一个后入先出（LIFO）的栈，并支持普通栈的全部四种操作（push、top、pop 和 empty）。
 *
 * 实现 MyStack 类：
 *
 * void push(int x) 将元素 x 压入栈顶。
 * int pop() 移除并返回栈顶元素。
 * int top() 返回栈顶元素。
 * boolean empty() 如果栈是空的，返回 true ；否则，返回 false 。
 *  
 *
 * 注意：
 *
 * 你只能使用队列的基本操作 —— 也就是 push to back、peek/pop from front、size 和 is empty 这些操作。
 * 你所使用的语言也许不支持队列。 你可以使用 list （列表）或者 deque（双端队列）来模拟一个队列 , 只要是标准的队列操作即可。
 *  
 *
 * 示例：
 *
 * 输入：
 * ["MyStack", "push", "push", "top", "pop", "empty"]
 * [[], [1], [2], [], [], []]
 * 输出：
 * [null, null, null, 2, 2, false]
 *
 * 解释：
 * MyStack myStack = new MyStack();
 * myStack.push(1);
 * myStack.push(2);
 * myStack.top(); // 返回 2
 * myStack.pop(); // 返回 2
 * myStack.empty(); // 返回 False
 *  
 *
 * 提示：
 *
 * 1 <= x <= 9
 * 最多调用100 次 push、pop、top 和 empty
 * 每次调用 pop 和 top 都保证栈不为空
 *  
 *
 * 进阶：你能否仅用一个队列来实现栈。

 */
class MyStack {
    Queue<Integer> queue;
    Queue<Integer> helpQ;

    /**
     * 初始化两个队列
     */
    public MyStack() {
        queue = new LinkedList<>();
        helpQ = new LinkedList<>();
    }

    /**
     * 入栈
     * 目的： 保证 queue 中的元素符合 queue 特性，后进先出
     * @param x
     */
    public void push(int x) {

        // 将元素 x 放入到 helpQ
        helpQ.offer(x);

        // queue 不为空时，将它的元素一一取出，放入到 helpQ 中
        // 执行完后，queue 为空，元素全部到了 helpQ 中
        while (!queue.isEmpty()) {
            helpQ.offer(queue.poll());
        }

        // 2 个队列互换，queue 满， helpQ 空
        // 保证 queue 队列符合 queue 特性 LIFO
        Queue<Integer> temp = queue;
        queue = helpQ;
        helpQ = temp;
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
     * 返回头元素， queue.top()
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
