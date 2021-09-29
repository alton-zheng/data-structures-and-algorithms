class Solution {
public:
    int findMinMoves(vector<int> &machines) {

        // 统计
        int cnt = accumulate(machines.begin(), machines.end(), 0);

        // 数量
        int len = machines.size();

        // 如果不可以整除， 返回  -1
        if (cnt % len) {
            return -1;
        }

        // 平均值
        int avg = cnt / len;

        // 定位 res, sum
        int res = 0, sum = 0;

        // 遍历
        for (int num: machines) {
            num -= avg;
            sum += num;
            res = max(res, max(abs(sum), num));
        }

        // 返回 res
        return res;
    }
};
