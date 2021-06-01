// Runtime: 0 ms, faster than 100.00% of C++ online submissions for Find N Unique Integers Sum up to Zero.
// Memory Usage: 6.6 MB, less than 90.08% of C++ online submissions for Find N Unique Integers Sum up to Zero.
class Solution {
public:
    vector<int> sumZero(int n) {
    
        vector<int> res(n);
        int count = 0;
        for (int i = 0; i < n - 1; i++) {
            int temp = i - n / 2;
            res[i] = temp;
            count += temp;
        }

        res[n - 1] = -count;
        return res;
    }
};