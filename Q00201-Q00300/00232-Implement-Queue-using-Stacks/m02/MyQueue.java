package m02;

import java.util.Stack;

/**
 * @Description:
 * @Author: alton_z
 * @Create Date Time: 2022-08-20 18:31
 * @Update Date Time: 2022-08-20 18:31
 * @Updated-By: alton_z
 * @Update-Location:
 *
 * 232. Implement Queue using Stacks #437
 * 232. 用栈实现队列
 * 请你仅使用两个栈实现先入先出队列。队列应当支持一般队列支持的所有操作（push、pop、peek、empty）：
 *
 * 实现 MyQueue 类：
 *
 * void push(int x) 将元素 x 推到队列的末尾
 * int pop() 从队列的开头移除并返回元素
 * int peek() 返回队列开头的元素
 * boolean empty() 如果队列为空，返回 true ；否则，返回 false
 * 说明：
 *
 * 你 只能 使用标准的栈操作 —— 也就是只有 push to top, peek/pop from top, size, 和 is empty 操作是合法的。
 * 你所使用的语言也许不支持栈。你可以使用 list 或者 deque（双端队列）来模拟一个栈，只要是标准的栈操作即可。
 *
 *
 * 示例 1：
 *
 * 输入：
 * ["MyQueue", "push", "push", "peek", "pop", "empty"]
 * [[], [1], [2], [], [], []]
 * 输出：
 * [null, null, null, 1, 1, false]
 *
 * 解释：
 * MyQueue myQueue = new MyQueue();
 * myQueue.push(1); // queue is: [1]
 * myQueue.push(2); // queue is: [1, 2] (leftmost is front of the queue)
 * myQueue.peek(); // return 1
 * myQueue.pop(); // return 1, queue is [2]
 * myQueue.empty(); // return false
 *
 *
 * 提示：
 *
 * 1 <= x <= 9
 * 最多调用 100 次 push、pop、peek 和 empty
 * 假设所有操作都是有效的 （例如，一个空的队列不会调用 pop 或者 peek 操作）
 *
 *
 * 进阶：
 *
 * 你能否实现每个操作均摊时间复杂度为 O(1) 的队列？换句话说，执行 n 个操作的总时间复杂度为 O(n) ，即使其中一个操作可能花费较长时间。
 */
class MyQueue {

    // 队列的 front, 首元素
    int front;
    private Stack<Integer> s1;
    private Stack<Integer> s2;

    /**
     * 构造方法
     * 初始化 2 个栈
     * s1 -> queue
     * s2 -> 辅助
     */
    public MyQueue() {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }

    /**
     * 入栈
     * 时间复杂度和空间复杂度都为 O(N)
     * @param x
     */
    public void push(int x) {

        if (s1.isEmpty()) {
            front = x;
        }
        // 直接压入到 s1
        s1.push(x);
    }

    /**
     * 出队
     * @return
     */
    public int pop() {

        // s2 为空，才会将 s1 的元素 push 到 s2 中
        if (s2.isEmpty()) {
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }
        }

        // s2 pop
        return s2.pop();
    }

    public int peek() {

        if (!s2.isEmpty()) {
            return s2.peek();
        }

        return front;
    }


    /**
     * 判断队列是否为空
     * 时间和空间复杂度都为 O(1)
     * @return
     */
    public boolean empty() {
        return s1.isEmpty() && s2.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
