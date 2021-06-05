/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 * Runtime: 0 ms, faster than 100.00% of C++ online submissions for Same Tree.
   Memory Usage: 10.2 MB, less than 5.81% of C++ online submissions for Same Tree.

   Time Complexity: O(min(M, N))
   Space Complexity: O(min(M, N))
 */
class Solution {
public:
    bool isSameTree(TreeNode* p, TreeNode* q) {
        if (p == nullptr && q == nullptr) {
            return true;
        }

        if (p == nullptr || q == nullptr) {
            return false;
        }

        queue<TreeNode*> q1;
        queue<TreeNode*> q2;
        q1.push(p);
        q2.push(q);

        while (!q1.empty() && !q2.empty()) {
            auto node1 = q1.front();
            q1.pop();
            auto node2 = q2.front();
            q2.pop();

            if (node1 -> val != node2 -> val) {
                return false;
            }

            auto l1 = node1 -> left, r1 = node1 -> right, l2 = node2 -> left, r2 = node2 -> right;

            if (l1 == nullptr ^ l2 == nullptr) {
                return false;
            }

            if (r1 == nullptr ^ r2 == nullptr) {
                return false;
            }

            if (l1 != nullptr) {
                q1.push(l1);
            }

            if (r1 != nullptr) {
                q1.push(r1);
            }

            if (l2 != nullptr) {
                q2.push(l2);
            }

            if (r2 != nullptr) {
                q2.push(r2);
            }
        }

        return q1.empty() && q2.empty();
    }
};