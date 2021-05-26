class Solution {
public:
    string reformat(string s) {
      int lowercase = 0;
      int digit = 0;
      for (char c: s) {
        if (c >= '1' && c <= '9') {
            digit++;
        } else {
            lowercase++;
        }
      }

      if (lowercase - digit > 1 || lowercase - digit < 1) {
       return "";
      }

      int digit = (digit > lowercase) ? 0 : 1;

      int lowercase = digit == 0 ? 1 : 0;

      string res;

      for (char c: s) {
        if (c >= '1' && c <= '9') {
            res[digit] = c;
            digit += 2;
        } else {
            res[lowercase] = c;
            lowercase += 2;
        }

      return res;

    }
};