// Time Complexity: O(n)
// Space Complexity: O(1)
// 在性能上比 Java 差很多倍
class Solution {
public:
   vector<int> countBits(int nums) {
        vector<int> res(nums + 1);

        for (int i = 1; i <= nums; i++){
            res[i] = res[i & (i - 1)] + 1;
        }

        return res;
   }
};