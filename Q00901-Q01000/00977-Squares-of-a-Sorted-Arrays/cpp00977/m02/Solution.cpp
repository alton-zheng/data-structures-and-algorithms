// Runtime: 16 ms, faster than 99.69% of C++ online submissions for Squares of a Sorted Array.
// Memory Usage: 25.9 MB, less than 54.24% of C++ online submissions for Squares of a Sorted Array.
class Solution {
public:
    vector<int> sortedSquares(vector<int>& nums) {

        int len = nums.size();
        vector<int> res(len);

        int firstRes = 0, secondRes = 0;
        for (int first = 0, second = len - 1, resIndex = len - 1; resIndex >= 0; resIndex--) {
            firstRes = nums[first] * nums[first];
            secondRes = nums[second] * nums[second];

            if (firstRes >= secondRes) {
                res[resIndex] = firstRes;
                first++;
            } else {
                res[resIndex] = secondRes;
                second--;
            }
        }

        return res;
    }
};