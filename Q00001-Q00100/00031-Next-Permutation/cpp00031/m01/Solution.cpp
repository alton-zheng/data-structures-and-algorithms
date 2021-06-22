// Runtime: 4 ms, faster than 79.36% of C++ online submissions for Next Permutation.
// Memory Usage: 12.1 MB, less than 34.25% of C++ online submissions for Next Permutation.
class Solution {
public:
    void nextPermutation(vector<int>& nums) {

        int len = nums.size();

        int left = len - 2;

        while (left >= 0 && nums[left] >= nums[left + 1]){
            left--;
        }

        if (left > -1){

            int right = len - 1;
            while (right >= 0 && nums[left] >= nums[right]) {
                right--;
            }

            swap(nums[left], nums[right]);
        }

        reverse(nums.begin() + left + 1, nums.end());

    }
};