package java00000;

class Solution {
    public int sumFourDivisors(int[] nums) {
        int fsum = 0, sum = 0, count = 0;
        for (int i = 0; i < nums.length; i++) {
            sum = 0;
            for (int j = 1; j < Math.sqrt(nums[i]); j++) {
                if (nums[i] % j == 0) {
                    count += 2;
                    sum = sum + j + nums[i] / j;
                }
            }
            int x = (int) Math.sqrt(nums[i]);
            if (x * x == nums[i]) {
                count++;
                sum += nums[i];
            }
            if (count == 4) {
                fsum = fsum + sum;
            }
            count = 0;
        }
        return fsum;
    }

}