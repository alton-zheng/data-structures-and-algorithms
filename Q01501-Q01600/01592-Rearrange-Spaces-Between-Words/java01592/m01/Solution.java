package java01592.m01;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Author: alton_z
 * @Create Date Time: 2022-09-07 09:01
 * @Update Date Time: 2022-09-07 09:01
 * @Updated-By: alton_z
 * @Update-Location:
 */
class Solution {
    public String reorderSpaces(String text) {
        StringBuilder sb = new StringBuilder();
        char[] charT = text.toCharArray();
        int spaceNum = 0;
        List<String> words = new ArrayList<>();

        for (char c: charT) {
            if (c == ' ') {
                if (sb.length() != 0) {
                    words.add(sb.toString());
                    sb.delete(0, sb.length());
                }
                spaceNum++;
                continue;
            }

            sb.append(c);
        }

        if (sb.length() != 0) {
            words.add(sb.toString());
        }

        sb.delete(0, sb.length());
        int s = words.size() == 1 ? spaceNum : spaceNum / (words.size() - 1);


        System.out.println(words.size());
        for (int i = 0; i < words.size(); i++) {
            sb.append(words.get(i));
            for (int i1 = 0; i1 < s && spaceNum > 0; i1++) {
                sb.append(' ');
                spaceNum--;
            }
        }

        for (int num = spaceNum; num > 0; num--) {
            sb.append(' ');
        }

        return sb.toString();
    }
}
