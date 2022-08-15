package java00641.m01;

/**
 * @Description:
 * @Author: alton_z
 * @Create Date Time: 2022-08-15 08:51
 * @Update Date Time: 2022-08-15 08:51
 * @Updated-By: alton_z
 * @Update-Location:
 *641. Design Circular Deque #427
 *
 *
 * 时间复杂度：初始化和每项操作的时间复杂度均为 O(1)O(1)。
 * 空间复杂度：O(k)O(k)，其中 kk 为给定的队列元素数目。
 */
class MyCircularDeque {
    private int[] elements;
    private int rear, front;
    private int capacity;

    // 构造函数， capacity 为 k + 1, 为什么是 k + 1 呢？ 后面揭晓
    // 使用数组作为队列底层数据结构
    public MyCircularDeque(int k) {
        capacity = k + 1;
        rear = front = 0;
        elements = new int[k + 1];
    }

    public boolean insertFront(int value) {
        // 如果队列满了，不能对它进行 insert 操作
        if (isFull()) {
            return false;
        }

        // 在队列的最前边插入元素
        // 但在底层 array 写入时，则不同，从数组索引大到小进行写入操作
        // 到队列满，写入操作复杂度依然为 O(1)
        // 当然了这是在只有 insertFront 的理想状态下实现的，要保证它永远这么操作，需要其它方法的配合
        // 后面一一解答
        // 这里简单解释下为什么要加 capacity 再 %
        // 避免负 index 出现， 永远只会在容量范围内操作
        // 从数组索引大到小插入 front
        front = (front - 1 + capacity) % capacity;

        // 赋值操作
        elements[front] = value;

        // 返回成功
        return true;

    }

    /**
     * 从队列后边插入, 从数组索引小到大插入后边
     * @param value
     * @return
     */
    public boolean insertLast(int value) {

        // 如果队列满了，不能对它进行 insert 操作
        if (isFull()) {
            return false;
        }

        // 从数组最前面开始写入元素
        elements[rear] = value;

        // 写完后 rear 往后移动一位
        rear = (rear + 1) % capacity;

        // 返回 true
        return true;
    }

    /**
     * 删除首元素
     * @return
     */
    public boolean deleteFront() {

        if (isEmpty()) {
            return false;
        }
        // front 后移
        front = (front + 1) % capacity;
        return true;
    }

    /**
     * 删除尾元素
     * @return
     */
    public boolean deleteLast() {

        if (isEmpty()) {
            return false;
        }
        // rear 指针前移
        rear = (rear - 1 + capacity) % capacity;
        return true;
    }

    /**
     * 获取首元素
     * @return
     */
    public int getFront() {
        if (isEmpty()) {
            return -1;
        }
        return elements[front];
    }

    /**
     * 获取尾元素
     * @return
     */
    public int getRear() {
        if (isEmpty()) {
            return -1;
        }
        return elements[(rear - 1 + capacity) % capacity];
    }

    /**
     * 判空
     * @return
     */
    public boolean isEmpty() {

        // 当 rear 等于 front 时，就为空
        return rear == front;
    }


    /**
     * 判断队列是否满了
     * @return
     */
    public boolean isFull() {
        return (rear + 1) % capacity == front;
    }
}
