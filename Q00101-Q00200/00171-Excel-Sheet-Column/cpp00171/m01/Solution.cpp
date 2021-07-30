// Runtime: 0 ms, faster than 100.00% of C++ online submissions for Excel Sheet Column Number.
// Memory Usage: 5.9 MB, less than 90.38% of C++ online submissions for Excel Sheet Column Number.
class Solution {
public:
    int titleToNumber(string columnTitle) {
      	int res = 0;
      	for (char c: columnTitle) {
          res = (long)res * 26 + c - 'A' + 1;
        }

      	return res;
    }
};