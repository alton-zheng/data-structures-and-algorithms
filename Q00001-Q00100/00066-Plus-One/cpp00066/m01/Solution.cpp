class Solution {
public:
    vector<int> plusOne(vector<int>& digits) {

        int len = digits.size();
        for (int i = len - 1; i >= 0; i--) {
            if (digits[i] == 9) {
                digits[i] = 0;
                continue;
            }
            digits[i]++;
            return digits;
        }

        vector<int> res(len + 1);
        res[0] = 1;
        return res;
    }
};



