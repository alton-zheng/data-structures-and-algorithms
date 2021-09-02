/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };

 执行用时： 0 ms , 在所有 C++ 提交中击败了 100.00% 的用户
 内存消耗： 10.3 MB , 在所有 C++ 提交中击败了 65.72% 的用户

 */
class Solution {
public:
    ListNode* getKthFromEnd(ListNode* head, int k) {

        int len = 0;

        ListNode* temp = head;
        while (temp != nullptr) {
            len++;
            temp = temp -> next;
        }

        temp = head;

        int i = 0;
        while (temp != nullptr) {
            if (k + i >= len) {
                return temp;
            }

            temp = temp -> next;
            i++;
        }

        return temp;
    }
};