// Runtime: 8 ms, faster than 51.18% of C++ online submissions for Sign of the Product of an Array.
// Memory Usage: 10.2 MB, less than 84.22% of C++ online submissions for Sign of the Product of an Array.
class Solution {
 public:
     int arraySign(vector<int>& nums) {
         int sign = 1;
         for (int n : nums) {
             if (n == 0) return 0;
             if (n < 0) {
                sign *= -1;
             }
         }
         return sign;
     }
 };