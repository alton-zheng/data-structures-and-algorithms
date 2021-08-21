package java00443.m02;

/**
 * @Author: alton
 * @Date: Created in 2021/8/21 下午4:18
 * @Description:
 *
 * Runtime: 1 ms, faster than 91.48% of Java online submissions for String Compression.
 * Memory Usage: 38.6 MB, less than 68.11% of Java online submissions for String Compression.
 */
class Solution {
    public int compress(char[] chars) {

        int idx = 0, left = 0;

        int len = chars.length;

        for (int r = 0; r < len; r++) {
            if ( r == len - 1 || chars[r] != chars[r + 1]) {
                chars[idx++] = chars[r];

                int cnt = r - left + 1;

                if (cnt > 1) {
                    for (char c : String.valueOf(cnt).toCharArray()) {
                        chars[idx++] = c;
                    }
                }

                left = r + 1;
            }
        }

        return idx;
    }
}
