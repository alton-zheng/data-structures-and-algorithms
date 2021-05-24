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
 * [nullptr, nullptr, true, false, true, nullptr, true]
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

  private:
     vector<Trie*> chilren;
     bool isEnd;

     Trie* searchPrefix(string prefix) {
         Trie* cur = this;
         char curChar;

         for (int i = 0; i < prefix.size(); i++) {
             curChar = prefix[i];
             if (cur -> chilren[curChar - 'a'] == nullptr) {
                 return nullptr;
             }

             cur = cur -> chilren[curChar - 'a'];
         }

         return cur;
     }

  public:
      /** Initialize your data structure here. */
      Trie() : chilren(26), isEnd(false) {}

      /** Inserts a word into the trie. */
      void insert(string word) {
         Trie* cur = this;
         char curChar;

         for (int i = 0; i < word.size(); i++) {
             curChar = word[i];
             if (cur -> chilren[curChar - 'a'] == nullptr) {
                 cur -> chilren[curChar - 'a'] = new Trie();
             }

             cur = cur -> chilren[curChar - 'a'];
         }

         cur -> isEnd = true;
      }

      /** Returns if the word is in the trie. */
      bool search(string word) {
          Trie* searchNode = searchPrefix(word);
          return searchNode != nullptr && searchNode -> isEnd;
      }

      /** Returns if there is any word in the trie that starts with the given prefix. */
      bool startsWith(string prefix) {
         Trie* searchNode = searchPrefix(prefix);
         return searchNode != nullptr;
      }

  };

 /**
  * Your Trie object will be instantiated and called as such:
  * Trie* obj = new Trie();
  * obj->insert(word);
  * bool param_2 = obj->search(word);
  * bool param_3 = obj->startsWith(prefix);
  */