package java00707.m01;

/**
 * @Description:
 * @Author: alton_z
 * @Create Date Time: 2022-09-23 09:23
 * @Update Date Time: 2022-09-23 09:23
 * @Updated-By: alton_z
 * @Update-Location:
 */
class MyLinkedList {

    private Node root;
    private int size;
    class Node {
        int val;
        Node next;

        private Node() {}
        private Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }
    }

    public MyLinkedList() {
        root = new Node(-1, null);
        size = 0;
    }

    public int get(int index) {

        if (index + 1 > size) {
            return -1;
        }

        Node cur = root;
        for (int i = 1; i <= index + 1; i++) {
            cur = cur.next;
        }

        return cur.val;
    }

    public void addAtHead(int val) {
        addAtIndex(0, val);
    }

    public void addAtTail(int val) {
        addAtIndex(size, val);
    }

    public void addAtIndex(int index, int val) {

        if (size < index) {
            return;
        }

        Node cur = root;

        for (int i = 1; i < index + 1; i++) {
            cur = cur.next;
        }

        cur.next = new Node(val, cur.next);
        size++;

    }

    public void deleteAtIndex(int index) {

        if (size < index + 1) {
            return;
        }

        Node cur = root;

        for (int i = 1; i < index + 1; i++) {
            cur = cur.next;
        }

        cur.next = cur.next.next;
        size--;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < size; i++) {
            sb.append(i).append(":").append(get(i)).append(", ");
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        MyLinkedList list = new MyLinkedList();
        list.addAtIndex(0, 100);
        list.addAtIndex(0, 200);
        list.addAtIndex(1, 300);
        System.out.println(list.get(0));


        System.out.println(list);
    }

}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
