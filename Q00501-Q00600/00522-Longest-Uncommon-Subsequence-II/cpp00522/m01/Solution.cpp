class Solution {
public:
    int findLUSlength(vector<string>& strs) {

     // C++ 倒序
     sort(strs.begin(), strs.end(), [](string a, string b) {return a.size() > b.size(); });

        for (int i = 0; i < strs.size(); i++) {
            char flag = '1';

            for (int j = 0; j < strs.size(); j++) {
                if (i == j) {
                    continue;
                }

                if (isSubquence(strs[i], strs[j])) {
                    flag = '0';
                    break;
               }
            }

            if (flag == '1') {
                return strs[i].size();
            }
        }

        return -1;

    }

private:
    bool isSubquence(string a, string b) {

        int i = 0;
        for (int j = 0; j < b.size() && i < a.size(); j++) {
            if (a[i] == b[j]) {
                i++;
            }
        }

        return i == a.size();
    }
};