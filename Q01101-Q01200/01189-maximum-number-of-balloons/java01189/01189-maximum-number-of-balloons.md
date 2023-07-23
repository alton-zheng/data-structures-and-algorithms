# 1189. “气球” 的最大数量

> [leetcode](](https://leetcode.cn/problems/maximum-number-of-balloons/))

给你一个字符串 `text`，你需要使用 `text` 中的字母来拼凑尽可能多的单词 **"balloon"（气球）**。

字符串 `text` 中的每个字母最多只能被使用一次。请你返回最多可以拼凑出多少个单词 **"balloon"**。

 

**示例 1：**

**![img](../../01189-maximum-number-of-balloons/1536_ex1_upd.jpeg)**

```
输入：text = "nlaebolko"
输出：1
```

**示例 2：**

**![img](../../01189-maximum-number-of-balloons/1536_ex2_upd.jpeg)**

```
输入：text = "loonbalxballpoon"
输出：2
```

**示例 3：**

```
输入：text = "leetcode"
输出：0
```

 

**提示：**

- `1 <= text.length <= 10^4`
- `text` 全部由小写英文字母组成

&nbsp;

方法一：统计
思路

构成单词 
"balloon"
"balloon" 需要 
1
1 个字母 
‘b’
‘b’ 、
1
1 个字母 
‘a’
‘a’ 、
2
2 个字母 
‘l’
‘l’ 、
2
2 个字母 
‘o’
‘o’ 、
1
1 个字母 
‘n’
‘n’，因此只需要统计字符串中字母 
‘a’,‘b’,‘l’,‘o’,‘n’
‘a’,‘b’,‘l’,‘o’,‘n’ 的数量即可。其中每个字母 
"balloon"
"balloon" 需要两个 
‘l’,‘o’
‘l’,‘o’，可以将字母 
‘l’,‘o’
‘l’,‘o’ 的数量除以 
2
2，返回字母 
‘a’,‘b’,‘l’,‘o’,‘n’
‘a’,‘b’,‘l’,‘o’,‘n’ 中数量最小值即为可以构成的单词数量。

代码

Python3C++JavaC#CGolangJavaScript

class Solution:
    def maxNumberOfBalloons(self, text: str) -> int:
        cnt = Counter(ch for ch in text if ch in "balon")
        cnt['l'] //= 2
        cnt['o'] //= 2
        return min(cnt.values()) if len(cnt) == 5 else 0
复杂度分析

时间复杂度：
�
(
�
+
�
)
O(n+C)，其中 
�
n 为字符串的长度，
�
C 表示单词中字符的种类数，在本题中 
�
=
5
C=5。需要遍历一遍字符串，并求出单词中字符的最小数目。

空间复杂度：
�
(
�
)
O(C)，
�
C 表示单词中字符的种类数，在本题中 
�
=
5
C=5。需要 
�
(
�
)
O(C) 的空间存储字符的统计数目。

## 解法一

### python

```python
class Solution:
    def maxNumberOfBalloons(self, text: str) -> int:
        cnt = Counter(ch for ch in text if ch in "balon")
        cnt['l'] //= 2
        cnt['o'] //= 2
        return min(cnt.values()) if len(cnt) == 5 else 0
```

&nbsp;

### java

```java
class Solution {
    public int maxNumberOfBalloons(String text) {

        int[] count = new int[5];

        for(int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (c == 'b') {
                count[0]++;
            } else if (c == 'a') {
                count[1]++;
            } else if (c == 'l') {
                count[2]++;
            } else if (c == 'o') {
                count[3]++;
            } else if (c == 'n') {
                count[4]++;
            }
        }

        count[2] /= 2;
        count[3] /= 2;

        int result = count[0];
        for (int i = 0; i < 5; i++) {
            result = Math.min(result, count[i]);
        }

        return result;
    }
}

class Solution {
    public int maxNumberOfBalloons(String text) {
        int[] cnt = new int[5];
        for (int i = 0; i < text.length(); ++i) {
            char ch = text.charAt(i);
            if (ch == 'b') {
                cnt[0]++;
            } else if (ch == 'a') {
                cnt[1]++;
            } else if (ch == 'l') {
                cnt[2]++;
            } else if (ch == 'o') {
                cnt[3]++;
            } else if (ch == 'n') {
                cnt[4]++;
            }
        }
        cnt[2] /= 2;
        cnt[3] /= 2;
      	return Arrays.stream(cnt).min().getAsInt();
      
    }
}
```

&nbsp;

### C++

```java
class Solution {
    public:
        int maxNumberOfBalloons(string text) {
            vector<int> count(5);

            for (auto & c: text) {
                if (c == 'b') {
                    count[0]++;
                } else if (c == 'a') {
                    count[1]++;
                } else if (c == 'l') {
                    count[2]++;
                } else if (c == 'o') {
                    count[3]++;
                } else if (c == 'n') {
                    count[4]++;
                }
            }

            count[2] /= 2;
            count[3] /= 2;

            return *min_element(count.begin(), count.end());
        }
};
```



