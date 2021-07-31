/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 Runtime: 96 ms, faster than 54.62% of C++ online submissions for Sort List.
 Memory Usage: 48.7 MB, less than 23.29% of C++ online submissions for Sort List.
 */
class Solution {
public:
    ListNode* sortList(ListNode* head) {
        // 进入归并
        return  cut(head);
    }

private:
    ListNode* cut(ListNode* cutNode) {
        // 处理归并排序的边界问题,下面两种场景都不需要进行分合操作
        if (cutNode == nullptr || cutNode-> next == nullptr) {
            return cutNode;
        }

        // 下面将他们分割开来
        ListNode* s = cutNode;
        ListNode* f = cutNode -> next;
        while (f != nullptr && f -> next != nullptr) {
            s = s -> next;
            f = f -> next -> next;
        }

        // 这时候，f 指针已经指向 null, 已经到链表的尾部了，这时候 s 指针在链表的中部
        // 接下来开始链表进行分
        ListNode* rightNode =  s -> next;
        // 这里将 cutNode 从 s 位置切割了， cutNode 就剩下前部分不
        s -> next = nullptr;

        ListNode* left = sortList(cutNode);
        ListNode* right = sortList(rightNode);

        // 分割完后，进行合并部分操作
        return merge(left, right);
    }

    ListNode* merge (ListNode* left, ListNode* right) {

        // 构建虚拟头结点
        ListNode* dummyHead = new ListNode(-1);

        // 构建， t, l, r 分别指向， dummyHead, left, right
        ListNode* t = dummyHead;
        ListNode* l = left;
        ListNode* r = right;

        // 开始合并操作
        while (l != nullptr && r != nullptr) {

            // l 在前， r 在后
            if (l -> val >= r -> val) {
                t -> next = r;
                r = r -> next;
            } else {
                t -> next = l;
                l = l -> next;
            }
            t = t -> next;
        }

        // 如 l， r 还存在不为空的链表，将剩余部分赋值给 t.next
        // 这时候，只会有其中之一不为 null
        t -> next = l != nullptr ? l : r;

        return dummyHead -> next;
    }
};