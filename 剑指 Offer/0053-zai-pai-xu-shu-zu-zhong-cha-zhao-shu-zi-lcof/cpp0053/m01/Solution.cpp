// 执行用时： 4 ms , 在所有 C++ 提交中击败了 97.57% 的用户
// 内存消耗： 12.8 MB , 在所有 C++ 提交中击败了 79.65% 的用户
class Solution {
public:
    int search(vector<int>& nums, int target) {

        int len = nums.size();
        int left = 0, right = len;
        int res = 0;

        if (len == 1 && nums[0] == target) {
            return 1;
        }
        while (left < right) {
            int mid = left + ((right - left) >> 1);
            if (nums[mid] == target) {
                res++;
                int pre = mid;
                while (--pre >= 0 && nums[pre] == target) {
                    res++;
                }

                pre = mid;
                while (++pre < len && nums[pre] == target) {
                    res++;
                }

                return res;
            }

            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return res;
    }
};
