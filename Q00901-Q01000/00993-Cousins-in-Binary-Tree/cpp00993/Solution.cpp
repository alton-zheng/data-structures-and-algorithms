class Solution {

private:
    // x 的信息
    int x;
    TreeNode* x_parent;
    int x_depth;
    bool x_found = false;

    // y 的信息
    int y;
    TreeNode* y_parent;
    int y_depth;
    bool y_found = false;

    void depthFirstTraversal(TreeNode* node, TreeNode* left, TreeNode* right, int depth) {

        if (x_found && y_found || node == nullptr) {
            return;
        }

        depth++;

        if (left != nullptr) {
            update(left, node, depth);
            depthFirstTraversal(left, left -> left, left -> right, depth);
        }

        if (right != nullptr) {
            update(right, node, depth);
            depthFirstTraversal(right, right -> left, right -> right, depth);
        }

    }

public:
    bool isCousins(TreeNode* root, int x, int y) {

        this -> x = x;
        this -> y = y;

        if (root -> val == x || root -> val == y) {
            return false;
        }

        depthFirstTraversal(root, root -> left, root -> right, 0);

        return x_found && y_found && x_depth == y_depth && x_parent != y_parent;

    }

    void update (TreeNode* node, TreeNode* parent, int depth) {
        if (node -> val == x) {
            tie(x_parent, x_depth, x_found) = tuple{parent, depth, true};
        }

        if (node -> val == y) {
            tie(y_parent, y_depth, y_found) = tuple{parent, depth, true};
        }
    }
};