package java00705;

import java00278.m01.Solution;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * @Author: alton
 * @Date: Created in 7/2/21 10:03 PM
 * @Description:
 * 705. Design HashSet #169
 *
 *Design a HashSet without using any built-in hash table libraries.
 *
 * Implement MyHashSet class:
 *
 * void add(key) Inserts the value key into the HashSet.
 * bool contains(key) Returns whether the value key exists in the HashSet or not.
 * void remove(key) Removes the value key in the HashSet. If key does not exist in the HashSet, do nothing.
 *
 *
 * Example 1:
 *
 * Input
 * ["MyHashSet", "add", "add", "contains", "contains", "add", "contains", "remove", "contains"]
 * [[], [1], [2], [1], [3], [2], [2], [2], [2]]
 * Output
 * [null, null, null, true, false, null, true, null, false]
 *
 * Explanation
 * MyHashSet myHashSet = new MyHashSet();
 * myHashSet.add(1);      // set = [1]
 * myHashSet.add(2);      // set = [1, 2]
 * myHashSet.contains(1); // return True
 * myHashSet.contains(3); // return False, (not found)
 * myHashSet.add(2);      // set = [1, 2]
 * myHashSet.contains(2); // return True
 * myHashSet.remove(2);   // set = [1]
 * myHashSet.contains(2); // return False, (already removed)
 *
 *
 * Constraints:
 *
 * 0 <= key <= 10^6
 * At most 10^4 calls will be made to add, remove, and contains.
 *
 *
 */
class MyHashSet {

    // 769 为解决冲突二设置的一个质数
    private static final int BASE = 769;
    private LinkedList[] set;

    /** Initialize your data structure here. */
    public MyHashSet() {
        set = new LinkedList[BASE];
        for (int i = 0; i < BASE; i++) {
            set[i] = new LinkedList<Integer>();
        }
    }

    public void add(int key) {
        if (!contains(key)) {
            int h = hash(key);
            set[h].offerLast(key);
        }
    }

    public void remove(int key) {
        if (contains(key)) {
            int h = hash(key);
            set[h].remove((Integer)key);
        }
    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int h = hash(key);
        Iterator<Integer> iter = set[h].iterator();

        while (iter.hasNext()) {
            if (iter.next() == key) {
                return true;
            }
        }

        return false;

    }

    public static int hash(int key) {
        return key % BASE;
    }

    public static void main(String[] args) {
        MyHashSet myHashSet = new MyHashSet();
        myHashSet.add(1);
        myHashSet.add(2);
        myHashSet.contains(1);
        myHashSet.contains(3);
        myHashSet.add(2);
        myHashSet.contains(2);
        myHashSet.remove(2);
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
