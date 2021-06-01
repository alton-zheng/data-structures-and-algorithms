package java01744;

/**
 * @Author: alton
 * @Date: Created in 6/1/21 3:08 PM
 * @Description:
 * 1744. Can You Eat Your Favorite Candy on Your Favorite Day? #63
 * You are given a (0-indexed) array of positive integers candiesCount where candiesCount[i] represents the number of candies of the ith type you have. You are also given a 2D array queries where queries[i] = [favoriteTypei, favoriteDayi, dailyCapi].
 *
 * You play a game with the following rules:
 *
 * You start eating candies on day 0.
 * You cannot eat any candy of type i unless you have eaten all candies of type i - 1.
 * You must eat at least one candy per day until you have eaten all the candies.
 * Construct a boolean array answer such that answer.length == queries.length and answer[i] is true if you can eat a candy of type favoriteTypei on day favoriteDayi without eating more than dailyCapi candies on any day, and false otherwise. Note that you can eat different types of candy on the same day, provided that you follow rule 2.
 *
 * Return the constructed array answer.
 *
 *
 *
 * Example 1:
 *
 * Input: candiesCount = [7,4,5,3,8], queries = [[0,2,2],[4,2,4],[2,13,1000000000]]
 * Output: [true,false,true]
 * Explanation:
 * 1- If you eat 2 candies (type 0) on day 0 and 2 candies (type 0) on day 1, you will eat a candy of type 0 on day 2.
 * 2- You can eat at most 4 candies each day.
 *    If you eat 4 candies every day, you will eat 4 candies (type 0) on day 0 and 4 candies (type 0 and type 1) on day 1.
 *    On day 2, you can only eat 4 candies (type 1 and type 2), so you cannot eat a candy of type 4 on day 2.
 * 3- If you eat 1 candy each day, you will eat a candy of type 2 on day 13.
 * Example 2:
 *
 * Input: candiesCount = [5,2,6,4,1], queries = [[3,1,2],[4,10,3],[3,10,100],[4,100,30],[1,3,1]]
 * Output: [false,true,true,false,false]
 *
 *
 * Constraints:
 *
 * 1 <= candiesCount.length <= 105
 * 1 <= candiesCount[i] <= 105
 * 1 <= queries.length <= 105
 * queries[i].length == 3
 * 0 <= favoriteTypei < candiesCount.length
 * 0 <= favoriteDayi <= 109
 * 1 <= dailyCapi <= 109
 *
 * Time Complexity: O(n + q)
 * Space Complexity: O(n)
 * Runtime: 4 ms, faster than 100.00% of Java online submissions for Can You Eat Your Favorite Candy on Your Favorite Day?.
 * Memory Usage: 77.1 MB, less than 7.60% of Java online submissions for Can You Eat Your Favorite Candy on Your Favorite Day?.
 *
 */
class Solution {
    public boolean[] canEat(int[] candiesCount, int[][] queries) {

        boolean[] res = new boolean[queries.length];

        long[] help = new long[candiesCount.length + 1];

        for (int i = 1; i < candiesCount.length + 1; i++) {
            help[i] = help[i - 1] + candiesCount[i - 1];
        }

        for (int q = 0; q < queries.length; q++) {
            int[] curQuery = queries[q];
            int candiesType = curQuery[0], days = curQuery[1], dailyCap = curQuery[2];

            res[q] = !(days + 1 > help[candiesType + 1] || ((long)(days + 1) * dailyCap) < help[candiesType] + 1);
        }

        return res;

    }

    public static void main(String[] args) {
        int[] candiesCount = new int[]{5215,14414,67303,93431,44959,34974,22935,64205,28863,3436,45640,34940,38519,5705,14594,30510,4418,87954,8423,65872,79062,83736,47851,64523,15639,19173,88996,97578,1106,17767,63298,8620,67281,76666,50386,97303,26476,95239,21967,31606,3943,33752,29634,35981,42216,88584,2774,3839,81067,59193,225,8289,9295,9268,4762,2276,7641,3542,3415,1372,5538,878,5051,7631,1394,5372,2384,2050,6766,3616,7181,7605,3718,8498,7065,1369,1967,2781,7598,6562,7150,8132,1276,6656,1868,8584,9442,8762,6210,6963,4068,1605,2780,556,6825,4961,4041,4923,8660,4114};
        int[][] queries = new int[][]{{91,244597,840227137},{69,1777314,444098682}};
        System.out.println(new Solution().canEat(candiesCount, queries));
    }
}
