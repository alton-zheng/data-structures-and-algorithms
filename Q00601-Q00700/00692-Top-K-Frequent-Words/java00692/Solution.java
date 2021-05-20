package java00692;

import java.util.*;

/**
 * @Author: alton
 * @Date: Created in 5/20/21 8:43 AM
 * @Description:
 * 692. Top K Frequent Words #22
 * Given a non-empty list of words, return the k most frequent elements.
 *
 * Your answer should be sorted by frequency from highest to lowest. If two words have the same frequency, then the word with the lower alphabetical order comes first.
 *
 * Example 1:
 * Input: ["i", "love", "leetcode", "i", "love", "coding"], k = 2
 * Output: ["i", "love"]
 * Explanation: "i" and "love" are the two most frequent words.
 *     Note that "i" comes before "love" due to a lower alphabetical order.
 * Example 2:
 * Input: ["the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"], k = 4
 * Output: ["the", "is", "sunny", "day"]
 * Explanation: "the", "is", "sunny" and "day" are the four most frequent words,
 *     with the number of occurrence being 4, 3, 2 and 1 respectively.
 * Note:
 * You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
 * Input words contain only lowercase letters.
 * Follow up:
 * Try to solve it in O(n log k) time and O(n) extra space.
 */

/**
 *  Hash Map 和  List 排序
 *  Time Complexity：O(l×n+l×mlogm)，其中 n 表示给定字符串序列的长度，l 表示字符串的平均长度，m 表示实际字符串种类数。我们需要 l×n 的时间将字符串插入到哈希表中，以及 l×mlogm 的时间完成字符串比较（最坏情况下所有字符串出现频率都相同，我们需要将它们两两比较）。
 *  Space Complexity：O(l×m)，其中 l 表示字符串的平均长度 m 表示实际字符串种类数。哈希表和生成的排序数组空间占用均为 O(l×m)。
 */
class Solution2 {
    public List<String> topKFrequent(String[] words, int k) {

        Map<String, Integer> wordsCount = new HashMap<>();

        for (String word : words) {
            wordsCount.put(word, wordsCount.getOrDefault(word, 0) + 1);
        }

        ArrayList<String> res = new ArrayList<>();

        for (String word : wordsCount.keySet()) {
            res.add(word);
        }

        Collections.sort(res,
                (s1, s2) ->
                        wordsCount.get(s1) == wordsCount.get(s2)
                                ? s1.compareTo(s2) :
                wordsCount.get(s2) - wordsCount.get(s1));

        return res.subList(0, k);
    }

    public static void main(String[] args) {
        String[] words = {"i", "love", "leetcode", "i", "love", "coding"};
        new Solution2().topKFrequent(words, 2);

    }
}

/**
 * 复杂度分析
 *
 * 时间复杂度：O(l×n+m×llogk)，其中 n 表示给定字符串序列的长度，m 表示实际字符串种类数，l 表示字符串的平均长度。我们需要 l×n 的时间将字符串插入到哈希表中，以及每次插入元素到优先队列中都需要 llogk 的时间，共需要插入 mm 次。
 * 空间复杂度：O(l×(m+k))，其中 l 表示字符串的平均长度，m 表示实际字符串种类数。哈希表空间占用为 O(l×m)，优先队列空间占用为 O(l×k)。
 */
class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> wordsCount = new HashMap<>();

        for (String word : words) {
            wordsCount.put(word, wordsCount.getOrDefault(word, 0) + 1);
        }


        PriorityQueue<Map.Entry<String, Integer>> queue = new PriorityQueue<>(
                (m1, m2) -> m1.getValue() == m2.getValue()
                        ? m1.getKey().compareTo(m2.getKey())
                        : m2.getValue() - m1.getValue()

        );

        for (Map.Entry<String, Integer> queueItem : wordsCount.entrySet()) {
            queue.offer(queueItem);
        }

        ArrayList<String> res = new ArrayList<>();

        for (int i = 0; i < k; i++) {
            res.add(queue.poll().getKey());
        }

        return res;
    }

    public static void main(String[] args) {
        String[] words = {"i", "love", "leetcode", "i", "love", "coding"};
        System.out.println(new Solution().topKFrequent(words, 2));
    }
}
