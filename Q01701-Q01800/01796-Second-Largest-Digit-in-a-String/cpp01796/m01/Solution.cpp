// Runtime: 4 ms, faster than 78.55% of C++ online submissions for Second Largest Digit in a String.
// Memory Usage: 6.5 MB, less than 96.96% of C++ online submissions for Second Largest Digit in a String.
class Solution {
public:
    int secondHighest(string s) {
        int firstMax = -1, secondMax = -1;

        for (int i = 0; i < s.length(); i++) {
            int temp = s[i] - '0';
            if (temp <= 9 && temp >= 0) {
                if (temp > firstMax) {
                    secondMax = firstMax;
                    firstMax = temp;
                    continue;
                }

                if (temp > secondMax && temp < firstMax) {
                    secondMax = temp;
                }
            }
        }

        return secondMax;
    }
};