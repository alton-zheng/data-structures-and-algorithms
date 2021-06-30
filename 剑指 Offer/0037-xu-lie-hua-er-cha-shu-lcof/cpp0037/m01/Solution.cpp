// 执行用时： 52 ms , 在所有 C++ 提交中击败了 59.80% 的用户
// 内存消耗： 34.2 MB , 在所有 C++ 提交中击败了 20.44% 的用户
class Codec {

private:
    int curIdx;
    void preOrder(TreeNode* root, string& str) {
        if (root == nullptr) {
            str += "null,";
        } else {
            str += to_string(root -> val) + ",";
            preOrder(root -> left, str);
            preOrder(root -> right, str);
        }
    }

    TreeNode* preOrderDeserialize(vector<string>& l) {

        // 当前节点为 null, 返回 nullptr
        if (l[curIdx] == "null" || curIdx == l.size()) {
            curIdx++;
            return nullptr;
        }

        TreeNode* node = new TreeNode(stoi(l[curIdx]));
        curIdx++;
        node -> left = preOrderDeserialize(l);
        node -> right = preOrderDeserialize(l);
        return node;
    }

public:
    string serialize(TreeNode* root) {
        string ret;
        preOrder(root, ret);
        return ret;
    }

    TreeNode* deserialize(string data) {

        vector<string> l;
        string str;

        for (char ch : data) {
            if (ch == ',') {
                l.push_back(str);
                str.clear();
            } else {
                str.push_back(ch);
            }
        }
        if (!str.empty()) {
            l.push_back(str);
            str.clear();
        }

        curIdx = 0;
        return preOrderDeserialize(l);
    }
};