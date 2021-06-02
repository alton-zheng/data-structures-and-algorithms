// Runtime: 4 ms, faster than 89.48% of C++ online submissions for Move Zeroes.
// Memory Usage: 8.9 MB, less than 54.95% of C++ online submissions for Move Zeroes.

class Solution {
public:
    void moveZeroes(vector<int>& nums) {
        int left = 0, right = 0, numsLen = nums.size();

        for (int i = 0; i < numsLen; i++) {

            if (nums[i] != 0) {
                if (left != right) {
                    swap(nums, left, right);
                }
                left++;
            }

            right++;
        }
    }

private:
   void swap(vector<int>& nums, int left, int right) {
        int swap = nums[right];
        nums[right] = nums[left];
        nums[left] = swap;
    }
};