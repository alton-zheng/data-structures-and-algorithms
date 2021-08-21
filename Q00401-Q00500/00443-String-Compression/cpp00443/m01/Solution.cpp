class Solution {
public:
    int compress(vector<char>& chars) {

        int idx = 0;

        int cnt = 1;
        char com = chars[0];
        for (int i = 1; i < chars.size(); i++) {
            if (chars[i] == com) {
                cnt++;
            } else {

                chars[idx++] = com;
                if (cnt > 1) {
                    for (char t : to_string(cnt)) {
                        chars[idx++] = t;
                    }
                }
                cnt = 1;

            }

            com = chars[i];
        }

        chars[idx++] = com;
        if (cnt > 1) {
            for (char t : to_string(cnt)) {
                chars[idx++] = t;
            }
        }

        return idx;
    }
};