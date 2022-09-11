/**
 * @Description:
 * @Author: alton_z
 * @Create Date Time: 2022-09-11 12:51
 * @Update Date Time: 2022-09-11 12:51
 * @Updated-By: alton_z
 * @Update-Location:
 */
public class KMP {

    public int getIndexOf(String source, String target) {

        /**
         * 边界条件：
         * 1. source, target 为 null
         * 2. source 的长度小于 target 的长度
         * 返回  -1
         */
        if (source == null
                || target == null
                || target.length() < 1
                || source.length() < target.length()
        ) {
            return -1;
        }

        // sourceC 和 targetC char 数组化
        char[] sourceC = source.toCharArray();
        char[] targetC = target.toCharArray();

        // 初始化 source, target 开始处理位置变量
        int sIndex = 0;
        int tIndex = 0;
        // O(M) m <= n
        int[] help = getHelp(targetC);
        // O(N)

        // 索引不越界的场景下，处理逻辑
        while (sIndex < sourceC.length && tIndex < targetC.length) {

            // 当source 和 target 字符匹配
            if (sourceC[sIndex] == targetC[tIndex]) {

                // sIndex, tIndex 向下移一位
                sIndex++;
                tIndex++;

            } else if (help[tIndex] == -1) {
                // 字符不匹配，且 target 还在 0 位置时，sIndex++
                // 这时候， target 首字符都未被匹配上
                sIndex++;
            } else {

                // 其它场景，如果字符不匹配， tIndex 切换到 tIndex 位置能匹配的最长左边位置上
                // 下一次循环， tIndex 和 sIndex 进行字符匹配
                tIndex = help[tIndex];
            }
        }

        // 当 tIndex 越界了，说明 target 全部匹配完成 -> 返回 sIndex - tIndex
        // 否则返回 -1
        return tIndex == targetC.length ? sIndex - tIndex : -1;
    }

    /**
     * 获得 targetC 字符， help 数组
     * 特性：
     * 1. 求 target 位置 i  targetC 的每个位置获得它前面 n 位和后面 n 位字符一致
     * 2. 不能将 i 位置前面所有的字符都选择完（这样没有任何意义，无法做到加速匹配的目标）
     * 2. 没有字符匹配的上，返回 0
     * 3. 初始化 help[0] = -1, help[1] = 0
     *
     * 要求：
     * 1. 求 target 位置 i
     * 降低时间复杂度到 O(N)
     * @param targetC
     * @return
     */
    public int[] getHelp(char[] targetC) {

        int[] help = new int[targetC.length];
        help[0] = -1;

        // base case , 如果 targetC 长度为 1， 返回 help
        if (help.length == 1) {
            return help;
        }

        //  长度大于 1 ， 将 help[1] = 0
        // 符合 help 预设
        help[1] = 0;

        // 从 2 位置开始求 help 数组的值
        int index = 2;

        // 当前是哪个位置的 targetC 字符再和 index - 1 位置的字符比较
        int compareI = 0;

        // index 不越界的前提下
        while (index < help.length) {
            // 首次处理时， index = 2, 这时候与 1 位置进行比较就是 compareI 为 0 的字符位
            if (targetC[index - 1] == targetC[compareI]) {

                // 匹配的上，直接更新 help[index] 位为 compareI 的值加上 1
                // 代表着有 compareI + 1 个字符符合要求
                // index++ 到下一次处理的位置
                help[index++] = ++compareI;

            } else if (compareI > 0) {
                // 此分支代表字符不匹配，且 compareI 大于 0 时，代表着当前 compareI 不匹配
                // 将 compareI 位置更新到 help[compare] 位置上
                // 什么含义呢？ help[compreI] 位置是下一次进行字符匹配的点。
                // 它的数量代表着上一个 compareI 有多少字符是匹配上的。
                compareI = help[compareI];
            } else {

                // 说明无法找到与 index - 1 能匹配上的字符，将 help[index] -> 0
                // index 切换到下一次比较的位置， index++
                help[index++] = 0;
            }
        }

        // 返回 help 数组
        return help;
    }

    // for test
    public static String getRandomString(int possibilities, int size) {
        char[] ans = new char[(int) (Math.random() * size) + 1];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = (char) ((int) (Math.random() * possibilities) + 'a');
        }
        return String.valueOf(ans);
    }

    public static void main(String[] args) {
        int possibilities = 5;
        int strSize = 20;
        int matchSize = 5;
        int testTimes = 5000000;
        System.out.println("test begin");
        for (int i = 0; i < testTimes; i++) {
            String str = getRandomString(possibilities, strSize);
            String match = getRandomString(possibilities, matchSize);
            if (new KMP().getIndexOf(str, match) != str.indexOf(match)) {
                System.out.println("Oops!");
            }
        }
        System.out.println("test finish");
    }

}

