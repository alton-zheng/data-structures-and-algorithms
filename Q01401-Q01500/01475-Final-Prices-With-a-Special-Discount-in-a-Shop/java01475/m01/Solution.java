package java01475.m01;

/**
 * @Description:
 * @Author: alton_z
 * @Create Date Time: 2022-09-01 20:32
 * @Update Date Time: 2022-09-01 20:32
 * @Updated-By: alton_z
 * @Update-Location:
 * 1475. Final Prices With a Special Discount in a Shop #456
 * https://leetcode.cn/problems/final-prices-with-a-special-discount-in-a-shop/
 */
class Solution {
    public int[] finalPrices(int[] prices) {

        for(int i = 0; i < prices.length; i++) {

            for (int j = i + 1; j < prices.length; j++) {
                if (prices[j] <= prices[i]) {
                    prices[i] = prices[i] - prices[j];
                    break;
                }
            }
        }

        return prices;
    }
}
