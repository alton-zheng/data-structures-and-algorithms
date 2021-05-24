class Solution {
public:
    string sortSentence(string s) {

        vector<string> help(9);
        string tmp = "";
        int wordsNumber = 0;

        for (char c: s){
            if (c >= '0' && c <= '9'){
                help[c-'0'-1] = tmp;
                tmp.clear();
                wordsNumber++;
            }  else if (c != ' '){
                tmp.push_back(c);
            }
        }
        string res = help[0];
        for (int i = 1; i < wordsNumber; ++i){
            res += " " + help[i];
        }
        return res;
    }
};