package java00641.m02;

/**
 * 双向指针的链表作为底层数据结构
 * 时间复杂度和空间复杂度和数组差不多
 */
class MyCircularDeque {
    private class DLinkListNode {
        int val;
        DLinkListNode prev, next;

        DLinkListNode(int val) {
            this.val = val;
        }
    }

    private DLinkListNode head, tail;
    private int capacity;
    private int size;

    public MyCircularDeque(int k) {
        capacity = k;
        size = 0;
    }

    public boolean insertFront(int value) {
        if (size == capacity) {
            return false;
        }

        DLinkListNode node = new DLinkListNode(value);
        if (size == 0) {

            // 只有一个节点时，那么它既是头节点，也是尾节点
            head = tail = node;
        } else {

            // 不然新建的节点， next 指向之前的 head 节点
            node.next = head;

            // 之前的头节点 prev 指向新建的 node
            head.prev = node;

            // head 节点引用指向 node 节点
            head = node;
        }
        size++;
        return true;
    }

    public boolean insertLast(int value) {
        if (size == capacity) {
            return false;
        }
        DLinkListNode node = new DLinkListNode(value);
        if (size == 0) {
            head = tail = node;
        } else {
            tail.next = node;

            // 新建的尾结点 prev 指向前 tail 节点
            node.prev = tail;

            // tail 节点引用指向 node 节点
            tail = node;
        }
        size++;
        return true;
    }

    public boolean deleteFront() {
        if (size == 0) {
            return false;
        }
        head = head.next;
        if (head != null) {
            head.prev = null;
        }
        size--;
        return true;
    }

    public boolean deleteLast() {
        if (size == 0) {
            return false;
        }
        tail = tail.prev;
        if (tail != null) {
            tail.next = null;
        }
        size--;
        return true;
    }

    public int getFront() {
        if (size == 0) {
            return -1;
        }
        return head.val;
    }

    public int getRear() {
        if (size == 0) {
            return -1;
        }
        return tail.val;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == capacity;
    }
}