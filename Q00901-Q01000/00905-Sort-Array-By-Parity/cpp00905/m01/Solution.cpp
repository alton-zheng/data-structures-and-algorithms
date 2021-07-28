// Runtime: 4 ms, faster than 98.36% of C++ online submissions for Sort Array By Parity.
// Memory Usage: 16.1 MB, less than 81.90% of C++ online submissions for Sort Array By Parity.
class Solution {
public:
    vector<int> sortArrayByParity(vector<int>& nums) {

        // 定义数组长度
        int len = nums.size();

        // 定义双指针， left, right
        // left 用来指向奇数位置
        // right 用来指向偶数位置
        int left = 0, right = len - 1;
        do {
            // 交互奇偶位置
            swap(nums[left], nums[right]);
            // 找到奇数位置 left
            while (left < len && nums[left] %2 != 1) {
                left++;
            }

            // 找到偶数位置 right
            while (right > 0 && nums[right] %2 != 0) {
                right--;
            }

        } while (left < right);

        return nums;
    }
};