package java00470.m01;

/**
 * @Author: alton
 * @Date: Created in 2021/9/5 10:20 上午
 * @Description:
 */
class Solution extends SolBase {
    public int rand10() {
        int first , second;
        while ((first = rand7()) > 6);
        while((second = rand7()) > 5);

        return  (first & 1) == 1 ? second : 5 + second;
    }
}

class SolBase {
    public int rand7() {
        return 1;
    }
}
