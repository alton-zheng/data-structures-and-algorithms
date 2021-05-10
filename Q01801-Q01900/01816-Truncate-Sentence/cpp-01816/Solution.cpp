class Solution {
public:
    string truncateSentence(string s, int k) {
        int n = s.size();
        int cnt = 0;
        int r = 0;
        while (r < n)
        {
            if (s[r] == ' ')
                cnt ++;
                if (cnt == k)
                    break;
            r++;
        }
        if (cnt == k-1)
            return s;
        return s.substr(0, r);
    }
};