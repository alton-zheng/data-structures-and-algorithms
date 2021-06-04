/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 * Runtime: 40 ms, faster than 82.93% of C++ online submissions for Intersection of Two Linked Lists.
   Memory Usage: 14.6 MB, less than 20.48% of C++ online submissions for Intersection of Two Linked Lists.
 */
class Solution {
public:
    ListNode *getIntersectionNode(ListNode *headA, ListNode *headB) {

        ListNode* a = headA;
        ListNode* b = headB;
        while (a != b) {
            a = a != nullptr ? a -> next : headB;
            b = b != nullptr ? b -> next : headA;
        }

        return a;
    }
};