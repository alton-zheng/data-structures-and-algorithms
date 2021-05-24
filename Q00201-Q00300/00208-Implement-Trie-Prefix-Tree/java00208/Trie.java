package java00208;

/**
 * @Author: alton
 * @Date: Created in 5/24/21 9:32 AM
 * @Description:
 * 208. Implement Trie (Prefix Tree) #37
 *
 * A trie (pronounced as "try") or prefix tree is a tree data structure used to efficiently store and retrieve keys in a dataset of strings. There are various applications of this data structure, such as autocomplete and spellchecker.
 *
 * Implement the Trie class:
 *
 * Trie() Initializes the trie object.
 * void insert(String word) Inserts the string word into the trie.
 * boolean search(String word) Returns true if the string word is in the trie (i.e., was inserted before), and false otherwise.
 * boolean startsWith(String prefix) Returns true if there is a previously inserted string word that has the prefix prefix, and false otherwise.
 *
 *
 * Example 1:
 *
 * Input
 * ["Trie", "insert", "search", "search", "startsWith", "insert", "search"]
 * [[], ["apple"], ["apple"], ["app"], ["app"], ["app"], ["app"]]
 * Output
 * [null, null, true, false, true, null, true]
 *
 * Explanation
 * Trie trie = new Trie();
 * trie.insert("apple");
 * trie.search("apple");   // return True
 * trie.search("app");     // return False
 * trie.startsWith("app"); // return True
 * trie.insert("app");
 * trie.search("app");     // return True
 *
 *
 * Constraints:
 *
 * 1 <= word.length, prefix.length <= 2000
 * word and prefix consist only of lowercase English letters.
 * At most 3 * 104 calls in total will be made to insert, search, and startsWith.
 *
 * 字典树方法实现 Trie, 可以理解为有 26 个子节点的一颗大树， 也可以理解为 对象中，存储了 26 颗大树
 * Time Complexity : 初始化为 O(1)，其余操作为 O(∣S∣)，其中 ∣S∣ 是每次插入或查询的字符串的长度。
 * Space Complexity: O(∣T∣⋅Σ)，其中 ∣T∣ 为所有插入字符串的长度之和，Σ 为字符集的大小，本题 Σ=26。
 */
class Trie {

    private Trie[] children;
    private boolean isEnd;

    /** Initialize your data structure here. */
    public Trie() {
        children = new Trie[26];
        isEnd = false;
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {

        Trie cur = this;
        char curChar;

        for (int i = 0; i < word.length(); i++) {
            curChar = word.charAt(i);

            if (cur.children[curChar - 'a'] == null) {
                cur.children[curChar - 'a'] = new Trie();
            }

            cur = cur.children[curChar - 'a'];
        }

        cur.isEnd = true;

    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {

        Trie searchNode = searchPrefix(word);
        return searchNode != null && searchNode.isEnd;

    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {

        Trie searchNode = searchPrefix(prefix);
        return searchNode != null;

    }

    private Trie searchPrefix(String prefix) {

        Trie cur = this;

        char curChar;

        for (int i = 0; i < prefix.length(); i++) {

            curChar = prefix.charAt(i);
            if (cur.children[curChar - 'a'] == null) {
                return null;
            }

            cur = cur.children[curChar - 'a'];
        }

        return cur;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
