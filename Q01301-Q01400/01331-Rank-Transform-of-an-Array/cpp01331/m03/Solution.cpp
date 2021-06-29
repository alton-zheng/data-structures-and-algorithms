// Runtime: 48 ms, faster than 99.73% of C++ online submissions for Rank Transform of an Array.
// Memory Usage: 40.2 MB, less than 50.71% of C++ online submissions for Rank Transform of an Array.
class Solution {
public:
    vector<int> arrayRankTransform(vector<int>& arr) {

        if (arr.size() == 0) {
            return {};
        }

        int min = INT_MAX, max = INT_MIN;

        // 遍历一遍数组获取 min 和 max
        for (int num: arr) {
            if (num < min) {
                min = num;
            }

            if (num > max) {
                max = num;
            }
        }

        // 存在的元素置为 1 标记
        vector<int> count(max - min + 1, 0);
        for (int num: arr) {
            count[num - min] = 1;
        }

        // 统计出前缀和
        vector<int> preSum(count.size() + 1);
        for (int i = 1; i < preSum.size(); i++) {
            preSum[i] = preSum[i - 1] + count[i - 1];
        }

        vector<int> res(arr.size());
        for (int i = 0; i < arr.size(); i++) {
            res[i] = preSum[arr[i] - min] + 1;
        }

        return res;

    }
};