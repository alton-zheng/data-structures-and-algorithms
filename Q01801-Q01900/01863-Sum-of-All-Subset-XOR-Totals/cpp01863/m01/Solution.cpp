// Runtime: 0 ms, faster than 100.00% of C++ online submissions for Sum of All Subset XOR Totals.
// Memory Usage: 7.2 MB, less than 52.99% of C++ online submissions for Sum of All Subset XOR Totals.
class Solution {
public:
    int subsetXORSum(vector<int>& nums) {
        int res = 0;
        int len = nums.size();
        for (auto num: nums){
            res |= num;
        }
        return res << (len - 1);
    }
};