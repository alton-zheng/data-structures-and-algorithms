class Solution {
public:
    int findMaximumXOR(vector<int>& nums) {

        // 找到有效最高位 HIGH_BIT， 不需要官方题解中 31 位那么多
        int HIGH_BIT = 0;
        int max = nums[0] - 1;

        for (int num: nums) {


            int temp = 0;
            int compare = num;
            while (compare > 0 && num > max) {
                compare /= 2;
                temp++;
            }
            HIGH_BIT = (HIGH_BIT >= temp) ? HIGH_BIT : temp;


            if (num > max) {
                max = num;
            }

        }

        int x = 0;
        for (int k = HIGH_BIT; k >= 0; --k) {
            unordered_set<int> seen;
            // 将所有的 pre^k(a_j) 放入哈希表中
            for (int num: nums) {
                // 如果只想保留从最高位开始到第 k 个二进制位为止的部分
                // 只需将其右移 k 位
                seen.insert(num >> k);
            }

            // 目前 x 包含从最高位开始到第 k+1 个二进制位为止的部分
            // 我们将 x 的第 k 个二进制位置为 1，即为 x = x*2+1
            int x_next = x * 2 + 1;
            bool found = false;

            // 枚举 i
            for (int num: nums) {
                if (seen.count(x_next ^ (num >> k))) {
                    found = true;
                    break;
                }
            }

            if (found) {
                x = x_next;
            }
            else {
                // 如果没有找到满足等式的 a_i 和 a_j，那么 x 的第 k 个二进制位只能为 0
                // 即为 x = x*2
                x = x_next - 1;
            }
        }
        return x;
    }
};