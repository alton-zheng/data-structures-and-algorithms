/*
Runtime: 628 ms, faster than 62.19% of C++ online submissions for Number of Submatrices That Sum to Target.
Memory Usage: 162.1 MB, less than 32.72% of C++ online submissions for Number of Submatrices That Sum to Target.
 */
class Solution {
public:
    int numSubmatrixSumTarget(vector<vector<int>>& matrix, int target) {

        int res = 0;
        int outer = matrix.size(), inner = matrix[0].size();

        // List the upper boundary with index i
        for (int upper = 0; upper < outer; upper++) {

            vector<int> subArr(inner);

            // List the lower boundary with index j
            for (int lower = upper; lower < outer; lower++) {

                // Update the sum of elements for each col
                for (int col = 0; col < inner; col++) {
                    subArr[col] += matrix[lower][col];
                }

               res += getSubArrWithTarget(subArr, target);

            }
        }

        return res;
    }

private:
 int getSubArrWithTarget(vector<int>& subArr, int target) {
        int count = 0, preSum = 0;
        unordered_map<int, int> help;
        help[0] = 1;
        for (int i = 0; i < subArr.size(); i++) {
            preSum += subArr[i];
            if (help.count(preSum - target)) {
                count += help[preSum - target];
            }

            help[preSum]++;
        }

        return count;
    }
};