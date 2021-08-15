// Runtime: 232 ms, faster than 15.38% of C++ online submissions for Array With Elements Not Equal to Average of Neighbors.
// Memory Usage: 121.7 MB, less than 7.69% of C++ online submissions for Array With Elements Not Equal to Average of Neighbors.

class Solution {
public:
    vector<int> rearrangeArray(vector<int>& nums) {
        int len = nums.size();

        vector<int> res(len);

        sort(nums.begin(), nums.end());

        int left = 0 , right = len - 1;

        int ix = 0;
        while (left <= right) {
            if (ix < len)  {
               res[ix++] = nums[left];
            }

            if (ix < len) {
              res[ix++] = nums[right];
            }

            left++;
            right--;

        }

        return res;
    }
};