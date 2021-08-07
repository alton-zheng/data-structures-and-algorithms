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
*/

class Solution {

private:
    vector<vector<int>> res;
    void bfs(Node* node, int level) {
        if (node == nullptr) {
            return;
        }

        if (res.size() <= level) {
            res.push_back({});
        }

        res[level].push_back(node -> val);
        for (Node* n: node -> children) {
            bfs(n, level + 1);
        }
    }

public:
    vector<vector<int>> levelOrder(Node* root) {
        if (root != nullptr) {
            bfs(root, 0);
        }
        return res;
    }
};