

// 1588. Sum of All Odd Length Subarrays #352
/**
Time Complexity: O(N^3)
Space Complexity: O(1)

Runtime: 0 ms, faster than 100.00% of C++ online submissions for Sum of All Odd Length Subarrays.
Memory Usage: 8.3 MB, less than 78.62% of C++ online submissions for Sum of All Odd Length Subarrays.
*/

class Solution {
    int sumOddLengthSubarrays(vector<int>& arr) {
        int res = 0;

        for (int i = 0; i < arr.size(); i++){
            for (int odd = 1; i + odd - 1 < arr.size(); odd += 2) {
                res += accumulate(arr.begin() + i, arr.end() + i + odd, 0);
            }
        }

        return res;

    }
}