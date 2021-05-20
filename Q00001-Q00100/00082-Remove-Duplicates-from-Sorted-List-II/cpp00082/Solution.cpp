/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
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

            int curValue = cur -> next -> val;
            if (cur -> next -> next -> val == curValue) {

                while (cur -> next && cur -> next -> val == curValue) {
                    cur -> next = cur -> next -> next;
                }

            } else {
                cur = cur -> next;
            }
        }

        return pre -> next;
   }
};