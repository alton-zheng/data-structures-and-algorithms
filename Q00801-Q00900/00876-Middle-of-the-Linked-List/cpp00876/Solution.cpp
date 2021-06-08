/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 Runtime: 4 ms, faster than 7.62% of C++ online submissions for Middle of the Linked List.
 Memory Usage: 6.7 MB, less than 18.22% of C++ online submissions for Middle of the Linked List.
 */
class Solution {
public:
    ListNode* middleNode(ListNode* head) {

        ListNode* slow = head;
        ListNode* quick = head;

        while (quick != nullptr && quick -> next != nullptr) {
            slow = slow -> next;
            quick = quick -> next -> next;
        }

        return slow;
    }
};