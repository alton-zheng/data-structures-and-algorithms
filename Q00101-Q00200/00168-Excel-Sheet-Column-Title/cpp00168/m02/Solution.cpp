// Runtime: 0 ms, faster than 100.00% of C++ online submissions for Excel Sheet Column Title.
// Memory Usage: 6 MB, less than 31.48% of C++ online submissions for Excel Sheet Column Title.
class Solution {
public:
    string convertToTitle(int columnNumber) {
         stack<char> stk;

         while (columnNumber-- > 0) {
             stk.push((columnNumber % 26) + 'A');
             columnNumber /= 26;
         }

         string res;

         while (!stk.empty()) {
            res += stk.top();
            stk.pop();
         }

         return res;
    }
};