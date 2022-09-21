package java00854.m01;

import javafx.util.Pair;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

/**
 * @Description:
 * @Author: alton_z
 * @Create Date Time: 2022-09-21 10:39
 * @Update Date Time: 2022-09-21 10:39
 * @Updated-By: alton_z
 * @Update-Location:
 */
class Solution {
    public int kSimilarity(String s1, String s2) {
        int len = s1.length();

        // bfs 考虑队列来作为存储结构
        Queue<Pair<String, Integer>> queue = new ArrayDeque<>();

        // visit ， 是否被访问
        Set<String> visit = new HashSet<>();

        // 将 s1, 0 pair 对放入 queue
        queue.offer(new Pair<>(s1, 0));

        // s1 -> visit
        visit.add(s1);

        // 定义结果 k 值
        int k = 0;

        // 队列不为空，进入循环
        // 直接 queue 为空为止
        while (!queue.isEmpty()) {

            // 队列当前长度 size
            int size = queue.size();

            // 将当前在队列中的元素全部遍历一遍
            for (int i = 0; i < size; i++) {

                // 取出元素对
                Pair<String, Integer> pair = queue.poll();

                // cur -> pair key
                String cur = pair.getKey();

                // 取出 pair ， 字符的位置
                int offset = pair.getValue();

                // 如果 cur 直接等于 k, 相当于不再需要步骤，他们已经相等了，不需要处理
                // 那为啥可以直接返回呢？ 因为如果继续处理， k 只会变大。 当前已经相等，意味着 k 就是最小的
                //
                if (cur.equals(s2)) {
                    return k;
                }

                // offset 没越界且 cur 等于 s2 相同位置的 char 时， 仅 offset++
                // 不做别的操作, 直到尾部或者相同位置的字符不相等为止
                while (offset < len && cur.charAt(offset) == s2.charAt(offset)) {
                    offset++;
                }

                /**
                 * 遍历 [offset + 1, len)
                 * 相同位置相等时， 继续下一位置判断
                 * 字符不相等时：
                 * 还要保证 offset 位置的字符和 j 位置的字符一致时， 找到一种切换位置的场景：
                 * swap(cur, offset, j)
                 * 开始剪枝, r如果 next 之前没处理过
                 * 1.  放入  visit
                 * 2.  并且将之放入到队列中，等待下一次循环处理
                 *
                 * 到这里可以发现每次进入队列的字符串，偏移量都是 offset + 1
                 * 也就是每次处理完后， 偏移量都在一直向右边移动。
                 */
                for (int j = offset + 1; j < len; j++) {
                    if (s2.charAt(j) == cur.charAt(j)) {
                        continue;
                    }
                    if (s2.charAt(offset) == cur.charAt(j)) {
                        // 进入到这里，就是一种可能性，满足条件就加到 queue
                        String next = swap(cur, offset, j);
                        if (!visit.contains(next)) {
                            visit.add(next);
                            queue.offer(new Pair<>(next, offset + 1));
                        }
                    }
                }
            }

            // 每进入一次循环， k++
            // 每次循环， 队列中的所有 pair ， 都是当前可操作的一种可能性
            k++;
        }

        // 返回 k
        return k;
    }

    /**
     * swap (cur, i, j)
     * @param cur
     * @param i
     * @param j
     * @return
     */
    public String swap(String cur, int i, int j) {
        char[] arr = cur.toCharArray();
        char c = arr[i];
        arr[i] = arr[j];
        arr[j] = c;
        return new String(arr);
    }
}
