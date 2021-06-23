// Runtime: 0 ms, faster than 100.00% of C++ online submissions for Student Attendance Record I.
// Memory Usage: 6.2 MB, less than 25.59% of C++ online submissions for Student Attendance Record I.
class Solution {
public:
    bool checkRecord(string s) {

        int aN = 0, lN = 1;

        for (int i = 0; i < s.size(); i++) {
            if (s[i] == 'A') {
                aN++;
            }

            if (i > 0 && s[i - 1] == 'L' && s[i] == 'L') {
                lN++;
            } else {
                lN = 1;
            }

            if (aN > 1 || lN > 2) {
                return false;
            }
        }

        return true;
    }
};