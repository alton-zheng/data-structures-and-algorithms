class Solution {
public:
    int compress(vector<char>& chars) {

        int len = chars.size();
        int write = 0, left = 0;
        for (int read = 0; read < len; read++) {
            if (read == len - 1 || chars[read] != chars[read + 1]) {
                chars[write++] = chars[read];
                int num = read - left + 1;
                if (num > 1) {
                    for (char t : to_string(num)) {
                        chars[write++] = t;
                    }
                }

                left = read + 1;
            }
        }
        return write;
    }
};