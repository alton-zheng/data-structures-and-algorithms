package java1002.m02;

import java.util.*;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        Map<String, List<String>> help = new HashMap<>();

        for (String str: strs) {
            char[] cnt = new char[26];

            for (char c : str.toCharArray()) {
                cnt[c - 'a']++;
            }

            StringBuilder temp = new StringBuilder();

            for (int i = 0; i < 26; i++) {
                if (cnt[i] != 0) {
                    temp.append(i + 'a');
                    temp.append(cnt[i]);
                }
            }

            String key = temp.toString();
            List<String> value = help.getOrDefault(key, new ArrayList<>());
            value.add(str);
            help.put(key, value);
        }

        return new ArrayList<>(help.values());
    }
}