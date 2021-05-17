// Time Complexity: O(n^3)
// accumulate 用来计算起点是 i, 长度是 odd 的子数组的和。
// leetcode cost: 4ms
class Solution {
public:
    int sumOddLengthSubarrays(vector<int>& arr) {

        int res = 0;
        for(int i = 0; i < arr.size(); i ++)
            for(int odd = 1; i + odd - 1 < arr.size(); odd += 2)
                res += accumulate(arr.begin() + i, arr.begin() + i + odd, 0);
        return res;
    }
};

// Time Complexity: O(n^2)
// 处理方法和上面基本一致， 只是将连续子数组的和进行缓存，不再需要现算， 前缀和 （Prefix Sum) 的方法
// 使用 O(n) 的时间预处理前缀和数组，之后使用 O(1) 的时间即可计算出一个连续子数组的和。
// leetcode cost: 4ms  速度上来说和上一个解答方案效率快些，从 leetcode 的测试来看差不多，实则这一种方法稍微快些

class Solution  {
public:
    int sumOddLengthSubarrays(vector<int>& arr) {
        vector<int> presum = {0};

        // 初始化 presum
        for (int e: arr) {
            presum.push_back(presum.back() + e);
        }

        int res = 0;
        for (int i = 0; i < arr.size(); i++) {
            for(int odd = 1; i + odd - 1 < arr.size(); odd += 2) {
                res += presum[i + odd] - presum[i];
            }
        }

        return res;
    }
};

/*
Time Complexity: O(n)
Space Complexity: O(1)
下面的方法比较取巧，也可以说是一种找规律解题的一种方法
遍历一遍所有的元素，然后查看这个元素会在多少个长度为奇数的数组中出现过
然后数组中的每个元素都乘以出现的次数，即可计算出总和
重难点是如何找到元素在多少个长度为奇数的数组中出现过
对于一个数字它所在的数组，
  left: left = i + 1 种选择；
  right: right = n - i 中选择
意味着如果在数字前面有偶数个数字，后面也必须要有偶数个数字，才能够构成奇数长度的数组；
如果在前面选择了奇数个数字，那么在后面，也必须选择奇数个数字，这样加上它自身，才构成奇数长度的数组；
leetcode cost: 0 ms (超过 100% 的 C++ 提交者)
*/
class Solution {
public:
    int sumOddLengthSubarrays(vector<int>& arr) {
        int res = 0;
        for (int i = 0; i < arr.size(); i++) {
            int left = i + 1, right = arr.size() - i,
            left_even = (left + 1) / 2,right_even = (right + 1) / 2,
            left_odd = left / 2, right_odd = right / 2;
            res += (left_odd * right_odd + left_even * right_even) * arr[i];
        }

        return res;
    }
};