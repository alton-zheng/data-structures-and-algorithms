package java00600.m01;

/**
 * @Author: alton
 * @Date: Created in 2021/9/11 7:27 下午
 * @Description:
 *
600. 不含连续1的非负整数
给定一个正整数 n，找出小于或等于 n 的非负整数中，其二进制表示不包含 连续的1 的个数。

示例 1:

输入: 5
输出: 5
解释:
下面是带有相应二进制表示的非负整数<= 5：
0 : 0
1 : 1
2 : 10
3 : 11
4 : 100
5 : 101
其中，只有整数3违反规则（有两个连续的1），其他5个满足规则。

 Time Complexity: O(log(nmax))
 Space Complexity: O(log(nMax))
 *
 */
class Solution {
    public int findIntegers(int n) {

        int[] help = new int[31];
        help[0] = help[1] = 1;
        for (int i = 2; i < 31; i++) {
            help[i] = help[i - 1] + help[i - 2];
        }

        int pre = 0, res = 0;

        for (int i = 29; i >= 0; i--){
            int val = 1 << i;
            if ((n & val) != 0) {
               res += help[i + 1];
               if (pre == 1) {
                   break;
               }
               pre = 1;
            } else {
                pre = 0;
            }

            if (i == 0) {
                res++;
            }
        }

        return res;
    }
}
