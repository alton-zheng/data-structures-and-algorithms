class Solution {
public:
    vector<ListNode*> splitListToParts(ListNode* head, int k) {

        int n = 0;
        ListNode* temp = head;

        while (temp != nullptr) {
            n++;
            temp = temp -> next;
        }

        int quotient = n / k, remainder = n % k;

        vector<ListNode*> parts(k);
        ListNode* curr = head;

        for (int i = 0; i < k && curr != nullptr; i++) {
            parts[i] = curr;
            int partSize = quotient + (i < remainder ? 1 : 0);
            for (int j = 1; j < partSize; j++) {
                curr = curr -> next;
            }
            ListNode* next = curr -> next;
            curr -> next = nullptr;
            curr = next;
        }


        return parts;
    }
};