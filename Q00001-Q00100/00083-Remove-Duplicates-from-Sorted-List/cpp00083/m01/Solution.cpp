/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 Runtime: 12 ms, faster than 49.06% of C++ online submissions for Remove Duplicates from Sorted List.
 Memory Usage: 11.6 MB, less than 28.67% of C++ online submissions for Remove Duplicates from Sorted List.
 */
class Solution {
public:
    ListNode* deleteDuplicates(ListNode* head) {
        if (!head) {
            return head;
        }

        ListNode* pre = new ListNode(-1, head);
        ListNode* cur = pre;

        while (cur -> next && cur -> next -> next) {
            if (cur -> next -> val == cur -> next -> next -> val) {
                cur -> next = cur -> next -> next;
            } else {
                cur = cur -> next;
            }
        }

        return pre -> next;
    }
};