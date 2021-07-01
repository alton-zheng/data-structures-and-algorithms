package java01758.m03;

/**
 * @Author: alton
 * @Date: Created in 7/1/21 10:58 PM
 * @Description:
 */
class Solution {

    public int minOperations(String s) {
        return Math.min(count(s,'0'),count(s,'1'));
    }

    private int count(String s,char status){

        int res=0;

        for(char c:s.toCharArray()){
            if(c!= status){
                res++;
            }
            status = status == '0' ? '1' : '0';
        }

        return res;

    }
}
