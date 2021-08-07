// 457. Circular Array Loop #280

// Runtime: 0 ms, faster than 100.00% of C++ online submissions for Circular Array Loop.
// Memory Usage: 7.3 MB, less than 71.91% of C++ online submissions for Circular Array Loop.
class Solution {
public:
    bool circularArrayLoop(vector<int>& nums) {

        int len = nums.size();

        auto next = [&](int cur) {
            // 保证返回值在 [0, len) 中
            return ((cur + nums[cur]) % len + len) % len;
        };

        for (int i = 0; i < len; i++) {

            // 也可以写成 !nums[i]
            if (nums[i] == 0) {
                continue;
            }

            int slow = i, fast = next(i);

            // 判断非零且方向相同
            while (nums[slow] * nums[fast] > 0 && nums[slow] * nums[next(fast)] > 0) {
                if (slow == fast) {
                    if (slow != next(slow)) {
                        return true;
                    } else {
                        break;
                    }
                }
                slow = next(slow);
                fast = next(next(fast));
            }

            int add = i;

            while (nums[add] * nums[next(add)] > 0)  {
                int temp = add;
                add = next(add);
                nums[temp] = 0;
            }
        }

        return false;
    }
};