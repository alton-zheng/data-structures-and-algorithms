package java00946.m01;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Description:
 * @Author: alton_z
 * @Create Date Time: 2022-08-31 17:55
 * @Update Date Time: 2022-08-31 17:55
 * @Updated-By: alton_z
 * @Update-Location:
 * 946. Validate Stack Sequences #451
 */
class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {

        // 定义 help 结构来完成此题
        Deque<Integer> help = new ArrayDeque<>();

        // 找到 pushed 里元素个数
        int len = pushed.length;

        // 开始遍历
        for (int i = 0, j = 0; i < len; i++) {

            // 压栈
            help.push(pushed[i]);

            // 遍历 popped ， 当 popped 当前 j 位置刚好为 help 栈顶元素时，出栈
            // 边界：
            // 1. help 栈变空
            // 2. popped 当前 j 位置不为 help 栈顶元素
            // 以上两个条件不满足时，结束 while 进入下一个元素压栈
            while (!help.isEmpty() && help.peek() == popped[j]) {
                help.pop();
                j++;
            }
        }

        // 当 help 压入元素全部出栈后，返回 true, 否则 false
        return help.isEmpty();
    }
}
