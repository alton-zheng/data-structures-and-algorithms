// Runtime: 8 ms, faster than 56.08% of C++ online submissions for Find Numbers with Even Number of Digits.
// Memory Usage: 9.8 MB, less than 44.20% of C++ online submissions for Find Numbers with Even Number of Digits.k
class Solution {
public:
    int findNumbers(vector<int>& nums) {
        int res = 0;

        for (int num: nums) {
            if (judge(num)) {
                res++;
            }
        }

        return res;
    }

private:
    bool judge(int num) {
        if ((num > 9 && num < 100) || (num > 999 && num < 10000) || num == 100000) {
            return true;
        }

        return false;
     }
};

