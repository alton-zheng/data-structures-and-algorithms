// 执行用时： 12 ms , 在所有 C++ 提交中击败了 98.22% 的用户
// 内存消耗： 18.4 MB , 在所有 C++ 提交中击败了 21.72% 的用户
class Solution {
public:
    int majorityElement(vector<int>& nums) {
        int res = -1, flag = 0;

        // 根据摩尔定理，得出可能的结果值，此值在数组中出现的次数最多
        for (int num : nums) {
            if (flag == 0) {
                res = num;
            }
            flag += num == res ? 1 : -1;
        }

        // 接下来只要判断此数值出现的次数是否超过数组元素个数的一半
        flag = 0;
        for (int num: nums) {
            if (num == res) {
                flag++;
            }
        }

        return flag > nums.size() / 2 ? res : -1;
    }
};