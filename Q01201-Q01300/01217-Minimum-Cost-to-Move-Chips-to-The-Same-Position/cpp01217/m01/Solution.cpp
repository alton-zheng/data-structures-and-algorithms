// Runtime: 0 ms, faster than 100.00% of C++ online submissions for Minimum Cost to Move Chips to The Same Position.
// Memory Usage: 7.4 MB, less than 11.30% of C++ online submissions for Minimum Cost to Move Chips to The Same Position.
class Solution {
public:
    int minCostToMoveChips(vector<int>& position) {
        int firstP = 0, secondP = 0;
        for (int p : position) {
            // 筹码所在位置 p, 如在奇数位，二进制的最低位为 1
            // & 1
            if ((p & 1) == 0) {
                secondP++;
            } else {
                firstP++;
            }
        }

        return min(firstP, secondP);
    }
};