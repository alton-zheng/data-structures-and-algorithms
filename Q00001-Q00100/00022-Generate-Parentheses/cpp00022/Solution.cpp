/*
 * Time Complexity: O(4^n/genN)
 * Space Complexity: O(n)
*/
class Solution {
public:
    vector<string> generateParenthesis(int n) {
        vector<string> res;
        string temp;
        generate(temp, 0, 0, n, res);

        return res;
    }

private:
    void generate(string& temp, int open, int close, int max, vector<string>& res) {
        if (temp.size() == (2 * max)) {
            res.push_back(temp);
            return;
        }

        if (open < max) {
            temp.push_back('(');
            generate(temp, open + 1, close, max, res);
            temp.pop_back();
        }

        if (open > close) {
            temp.push_back(')');
            generate(temp, open, close + 1, max, res);
            temp.pop_back();
        }
    }
};