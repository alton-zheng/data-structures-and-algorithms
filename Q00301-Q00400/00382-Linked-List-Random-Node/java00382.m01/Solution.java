package java00382.m01;

/**
 * @Author: alton
 * @Date: Created in 7/5/21 8:50 PM
 * @Description:
 *
 * 382. Linked List Random Node #177
 *
 * Given a singly linked list, return a random node's value from the linked list. Each node must have the same probability of being chosen.
 *
 *
 *
 * Example 1:
 *
 *
 * Input
 * ["Solution", "getRandom", "getRandom", "getRandom", "getRandom", "getRandom"]
 * [[[1, 2, 3]], [], [], [], [], []]
 * Output
 * [null, 1, 3, 2, 2, 3]
 *
 * Explanation
 * Solution solution = new Solution([1, 2, 3]);
 * solution.getRandom(); // return 1
 * solution.getRandom(); // return 3
 * solution.getRandom(); // return 2
 * solution.getRandom(); // return 2
 * solution.getRandom(); // return 3
 * // getRandom() should return either 1, 2, or 3 randomly. Each element should have equal probability of returning.
 *
 *
 * Constraints:
 *
 * The number of nodes in the linked list will be in the range [1, 104].
 * -104 <= Node.val <= 104
 * At most 104 calls will be made to getRandom.
 *
 *
 * Follow up:
 *
 * What if the linked list is extremely large and its length is unknown to you?
 * Could you solve this efficiently without using extra space?
 *
 * Time Complexity : O(1)
 * Space Complexity : O(1)
 * Runtime: 10 ms, faster than 93.02% of Java online submissions for Linked List Random Node.
 * Memory Usage: 41 MB, less than 40.67% of Java online submissions for Linked List Random Node.
 */

import java.util.Random;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {

    private ListNode head;
    private int number;
    private int[] arr;
    private final Random random;

    /** @param head The linked list's head.
    Note that the head is guaranteed to be not null, so it contains at least one node. */
    public Solution(ListNode head) {
        updateListNodeNumber(head);
        random = new Random();
    }

    private void updateListNodeNumber(ListNode head) {

        ListNode temp = head;
        while (temp != null) {
            temp = temp.next;
            number++;
        }

        arr = new int[number];
        int cur = 0;
        temp = head;
        while (temp != null) {
            arr[cur++] = temp.val;
            temp = temp.next;
        }

    }

    /** Returns a random node's value. */
    public int getRandom() {
        return arr[random.nextInt(number)];
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */

