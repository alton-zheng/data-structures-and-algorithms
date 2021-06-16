// Runtime: 28 ms, faster than 89.14% of C++ online submissions for Next Greater Element II.
// Memory Usage: 24 MB, less than 41.88% of C++ online submissions for Next Greater Element II.
class Solution {
public:
    vector<int> nextGreaterElements(vector<int>& nums) {

        int len = nums.size();
        vector<int> res(len, -1);
        stack<int> help;

        for (int i = 0; i < 2 * len - 1; i++) {
            while (!help.empty() && nums[help.top()] < nums[i % len]) {
                res[help.top()] = nums[i % len];
                help.pop();
            }
            help.push(i % len);
        }

        return res;

    }
};