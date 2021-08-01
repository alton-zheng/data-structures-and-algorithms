package java00000.m2;

/**
 * @Author: alton
 * @Date: Created in 2021/8/1 12:34 下午
 * @Description:
 */
class Solution {
    public long minimumPerimeter(long neededApples) {

        long mid = 0;

        if (neededApples == 1) {
            return 8;
        }

        long left = 2, right = 300000;

        while (left < right) {
            mid = left + ((right - left) >> 1);
            mid = mid % 2 == 0 ? mid : mid - 1;
            long x = (mid/2 + 1)*(mid + 1) * mid;
            if (x > neededApples) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }

        }

        return mid * 4;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().minimumPerimeter(16));
    }
}
