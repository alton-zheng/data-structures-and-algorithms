// Runtime: 4 ms, faster than 96.30% of C++ online submissions for Find First and Last Position of Element in Sorted Array.
// Memory Usage: 13.7 MB, less than 62.71% of C++ online submissions for Find First and Last Position of Element in Sorted Array.
class Solution {
public:
    vector<int> searchRange(vector<int>& nums, int target) {
        int len = nums.size();
        int left = 0, right = len;
        vector<int> res(2, -1);

        if (len == 0) {
            return res;
        }

        while (left < right) {
            int mid = left + ((right - left) >> 1);
            if (nums[mid] == target) {
                int pre = mid;
                res[0] = res[1] = mid;
                while (--pre >= 0 && nums[pre] == target) {
                    res[0] = pre;
                }

                pre = mid;
                while (++pre < len && nums[pre] == target) {
                    res[1] = pre;
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