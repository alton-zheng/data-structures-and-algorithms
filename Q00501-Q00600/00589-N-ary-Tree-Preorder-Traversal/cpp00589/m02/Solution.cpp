/*
// Definition for a Node.
class Node {
public:
    int val;
    vector<Node*> children;

    Node() {}

    Node(int _val) {
        val = _val;
    }

    Node(int _val, vector<Node*> _children) {
        val = _val;
        children = _children;
    }
};

Runtime: 20 ms, faster than 79.26% of C++ online submissions for N-ary Tree Preorder Traversal.
Memory Usage: 11.2 MB, less than 73.45% of C++ online submissions for N-ary Tree Preorder Traversal.
*/

class Solution {
public:
    vector<int> preorder(Node* root) {
        vector<int> res;
        stack<Node*> stk;

        if (root == nullptr) {
            return {};
        }

        stk.push(root);

        while (!stk.empty()) {

            Node* cur = stk.top();
            stk.pop();
            res.push_back(cur -> val);

            for (int i = cur -> children.size() - 1; i >= 0; i--) {
                   stk.push(cur -> children[i]);
            }
        }

        return res;
    }
};