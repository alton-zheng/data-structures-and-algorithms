// Runtime: 12 ms, faster than 22.84% of C++ online submissions for Arranging Coins.
// Memory Usage: 5.9 MB, less than 23.14% of C++ online submissions for Arranging Coins.
class Solution {
public:
    int arrangeCoins(int n) {
         int level = 0;
         int temp = 1;
         while (n >= temp) {
             n -= temp;
             temp++;
             level++;
         }

         return level;
    }
};