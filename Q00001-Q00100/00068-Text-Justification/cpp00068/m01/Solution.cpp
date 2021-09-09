class Solution {

private:
    // blank 返回长度为 spaces 的由空格组成的字符串
    string blank(int spaces) {
        return string(spaces, ' ');
    }

    // join 返回用 sep 拼接 [left, right) 范围内 words 组成的字符串
    string join(vector<string>& words, int left, int right, string seq) {
        string s = words[left];
        for (int i = left + 1; i < right; i++) {
            s += seq + words[i];
        }
        return s;
    }


public:
    vector<string> fullJustify(vector<string>& words, int maxWidth) {

        vector<string> res;
        int right = 0, len = words.size();

        while(true) {
            // 当前行的第一个单词在 words 的位置
            int left = right;

            // 统计这一行单词长度之和
            int sumLen = 0;

            // 判断当前行可以放多少个 word
            // right - left ， 可以算出应该至少放多少个 space
            while (right < len && sumLen + words[right].size() + right - left <= maxWidth) {
                sumLen += words[right++].length();
            }

            // 当前行为最后一行时， 单词需要左对齐，且单词之间应只有一个空格，在行后面填充空格，以达到 maxWidth 的要求
            if (right == len) {
                string s = join(words, left, len, " ");
                res.emplace_back(s + blank(maxWidth - s.length()));
                return res;
            }

            int numWords = right - left;
            int numSpaces = maxWidth - sumLen;

            // 当前行只有一个单词： 该单词左对齐， 在行尾填充剩余空格
            if(numWords == 1) {
                res.emplace_back(words[left] + blank(numSpaces));
                continue;
            }

            // 当前行不只一个单词
            int avgSpaces = numSpaces / (numWords - 1);
            int extraSpaces = numSpaces % (numWords - 1);

            // 在 前extraSpaces 个数单词中间添加 avgSpaces + 1 个空格
            string s1 = join(words, left, left + extraSpaces + 1, blank(avgSpaces + 1));

            // 在 extraSpaces 个单词后个单词中间，添加 avgSpaces 个空格
            string s2 = join(words, left + extraSpaces + 1, right, blank(avgSpaces));

            // 两段中间，再添加 avgSpace 个空格
            res.emplace_back(s1 + blank(avgSpaces) + s2);

        }
    }
};