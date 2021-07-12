// Runtime: 4 ms, faster than 95.27% of C++ online submissions for Check If N and Its Double Exist.
// Memory Usage: 10 MB, less than 57.04% of C++ online submissions for Check If N and Its Double Exist.
class Solution {
public:
    bool checkIfExist(vector<int>& arr) {
        int cnt[4001] = {0};
        int* hash_set = cnt + 2000;
        for (int n : arr)
            ++hash_set[n];
        for (int n : arr)
            if (n != 0 && hash_set[2 * n] >= 1)
                return true;
            else if (n == 0 && hash_set[2 * n] >= 2)
                return true;
        return false;
    }
};