// Runtime: 32 ms, faster than 100.00% of C++ online submissions for Count the Number of Consistent Strings.
// Memory Usage: 30.2 MB, less than 53.61% of C++ online submissions for Count the Number of Consistent Strings.
class Solution {
public:
    int countConsistentStrings(string allowed, vector<string>& words) {

        vector<int> help(26,0);

        int res=0;

        for(int i=0; i<allowed.length(); i++) help[allowed[i]-'a'] = 1;

        for(int i=0; i<words.size(); i++){
            int flag=0;
            for(char c: words[i]){
                if(help[c-'a'] != 1){
                    flag=1;
                    break;
                }
            }

            if(flag==0) res++;
        }

        return res;
    }
};