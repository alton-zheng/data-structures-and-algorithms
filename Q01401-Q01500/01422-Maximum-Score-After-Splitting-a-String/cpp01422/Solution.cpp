class Solution {
public:
    int maxScore(string s) {

        int slen = s.size();

        // 初始化 l, r
        int l = s[0] == '0' ? 1 : 0, r = 0;

        // 初始化  max， 目前相当于只判断了首 char
        int res = l + r;

        // 接下来遍历剩余字符,从原理上来讲，是 l 往右移动，意味着遇到 '1' 时 r 要减去 1
        // 意味着，遍历后，其实统计的是 l 相对于 r 的最大优势数量
        for (int i = 1; i < slen; i++) {

            /**
             * 当遍历到最后一个字符时，跟 l 无关了
             * 也就是说,max 与 l 逻辑处理后，即为 max
             * 此时，也是返回结果的时机
             */
            if (i == slen - 1) {
                // max 减去 r;
               return res - (r - (s[slen - 1] == '1' ? 1 : 0));
            }

            // 遇到 '1' 时， r 减去 1， 由于没有统计过 1 的总数，所有，这里减去了多少
            // '1' 的数量就是多少
            if (s[i] == '1') {
                r--;
            } else {
                res = max(res, ++l + r);
            }
        }

        return res;
    }
};