/*
// Definition for a Node.
class Node {
public:
    int val;
    Node* next;
    Node* random;

    Node(int _val) {
        val = _val;
        next = NULL;
        random = NULL;
    }
};

Runtime: 8 ms, faster than 78.22% of C++ online submissions for Copy List with Random Pointer.
Memory Usage: 11.6 MB, less than 8.02% of C++ online submissions for Copy List with Random Pointer.

*/

class Solution {

private:
    unordered_map<Node*, Node*> help;
public:
    Node* copyRandomList(Node* head) {

        if (head == nullptr) {
            return nullptr;
        }

        if (!help.count(head)) {
            Node* newNode = new Node(head -> val);
            help[head] = newNode;
            newNode -> next = copyRandomList(head -> next);
            newNode -> random = copyRandomList(head -> random);
        }

        return help[head];
    }
};