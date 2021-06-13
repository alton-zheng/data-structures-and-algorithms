// Runtime: 1416 ms, faster than 40.03% of C++ online submissions for Bitwise ORs of Subarrays.
// Memory Usage: 318.9 MB, less than 34.70% of C++ online submissions for Bitwise ORs of Subarrays.
class Solution {
public:
    int subarrayBitwiseORs(vector<int>& arr) {
        unordered_set<int> res;
        unordered_set<int> cur;


        for (int item: arr) {
            unordered_set<int> help;
            for (int c : cur) {
                help.insert(item | c);
            }

            help.insert(item);
            cur = help;

            for (int c : cur) {
                res.insert(c);
            }
        }

        return res.size();
    }
};