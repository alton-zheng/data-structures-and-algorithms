class Solution {
public:
    int lengthOfLastWord(string s) {
        int end = s.size() - 1;
        while(end >= 0 && s[end] == ' ') end--;
        int res = 0;
        while(end >= 0 && s[end] != ' ')  {
            end--;
            res++;
        }
        return res;
    }
};