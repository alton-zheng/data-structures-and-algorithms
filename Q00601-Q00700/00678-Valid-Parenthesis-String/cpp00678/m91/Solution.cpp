class Solution {
public:
    bool checkValidString(string s) {
        int minLeft = 0, maxLeft = 0;

        int len = s.size();

        for (char c : s) {
           if (c == '(') {
               minLeft++;
               maxLeft++;
           } else if (c == ')') {
               minLeft =  minLeft - 1 > 0 ? minLeft - 1 : 0;
               maxLeft--;

               if (maxLeft < 0) {
                   return false;
               }
           } else {
               minLeft = minLeft - 1 > 0 ? minLeft - 1 : 0;
               maxLeft++;
           }
        }

        return minLeft == 0;
    }
};