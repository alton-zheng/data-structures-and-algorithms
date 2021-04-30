/**
 * @Author: alton
 * @Date: Created in 4/30/21 9:00 PM
 * @Description:
 */
public class Solution {

    public int reverse(int x) {

        /**
         * 思路：
         * 1. 将 int 字符化
         * 2. 构建一个临时变量，去掉 int 值的负数标记
         * 3. 构建正负标记变量, 如 int 为负数， 将负数标记置为 -1
         * 4. 用临时变量构建出 StringBuild, 反转，再转化成 String
         * 5. 转化成 int
         * 6. 加上正负标记
         */
/*        String s = Integer.toString(x);
        String temp = s;
        int flag = 1;

        if (x < 0) {
            flag = -1;
            temp = s.substring(1);
        }

        try {
            return Integer.valueOf(new StringBuilder(temp).reverse().toString()) * flag;
        } catch (NumberFormatException e) {
            return 0;
        }*/

        /**
         * 创建 long 值变量， 存储结果值
         * 逻辑如下：
         * 1. 首先将结果值置为0
         * 2. 以 待处理 int 除以 10 不为0 为条件 循环，通俗点说就是当待处理的数值为个位数时，就停止循环，也就是所有数值都处理完了
         * 3. 每次进入循环将 当前结果值（上一次循环得到的结果值或默认值0）加上待处理值余10，得到的余数（也就是当前待处理值最后一个数值），赋值给结果值
         * 4. 将待处理数值的当前个位数移除（用除10的方式），当前个位数已在第三步被用了，所以此处需要将它清理掉，将结果值置为下一次循环的待处理值
         * 5. 所有位处理完后，long 转化为 int, 成功则用，不成功置为0；
         *
         */
        long res = 0;

        while (x != 0) {
            res = res * 10 + x % 10;
            x = x / 10;
        }

        return (int) res == res ? (int) res : 0;

    }

}
