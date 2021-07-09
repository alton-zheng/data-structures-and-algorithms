// Runtime: 20 ms, faster than 49.30% of C++ online submissions for Ransom Note.
// Memory Usage: 8.6 MB, less than 86.90% of C++ online submissions for Ransom Note.
class Solution {
public:
    bool canConstruct(string ransomNote, string magazine) {
        // 由于 ransomNote 和 magazine 都仅仅有小写字母，公用一份 help
        vector<int> help(26);

        // 杂志加数量
        for(char c : magazine){
            ++help[c - 'a'];
        }

        // 赎金信减去数量
        for(char c: ransomNote){

            // 杂志字符数量不够时，返回 false
            if(--help[c - 'a'] < 0) {
                return false;
            }
        }

        return true;
    }
};