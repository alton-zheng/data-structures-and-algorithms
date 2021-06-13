package java00661.m01;

/**
 * @Author: alton
 * @Date: Created in 6/14/21 6:50 AM
 * @Description:
 * 661. Image Smoother #110
 * An image smoother is a filter of the size 3 x 3 that can be applied to each cell of an image by rounding down the average of the cell and the eight surrounding cells (i.e., the average of the nine cells in the blue smoother). If one or more of the surrounding cells of a cell is not present, we do not consider it in the average (i.e., the average of the four cells in the red smoother).
 *
 *
 * Given an m x n integer matrix img representing the grayscale of an image, return the image after applying the smoother on each cell of it.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: img = [[1,1,1],[1,0,1],[1,1,1]]
 * Output: [[0,0,0],[0,0,0],[0,0,0]]
 * Explanation:
 * For the points (0,0), (0,2), (2,0), (2,2): floor(3/4) = floor(0.75) = 0
 * For the points (0,1), (1,0), (1,2), (2,1): floor(5/6) = floor(0.83333333) = 0
 * For the point (1,1): floor(8/9) = floor(0.88888889) = 0
 * Example 2:
 *
 *
 * Input: img = [[100,200,100],[200,50,200],[100,200,100]]
 * Output: [[137,141,137],[141,138,141],[137,141,137]]
 * Explanation:
 * For the points (0,0), (0,2), (2,0), (2,2): floor((100+200+200+50)/4) = floor(137.5) = 137
 * For the points (0,1), (1,0), (1,2), (2,1): floor((200+200+50+200+100+100)/6) = floor(141.666667) = 141
 * For the point (1,1): floor((50+200+200+200+200+100+100+100+100)/9) = floor(138.888889) = 138
 *
 *
 * Constraints:
 *
 * m == img.length
 * n == img[i].length
 * 1 <= m, n <= 200
 * 0 <= img[i][j] <= 255
 *
 * Time Complexity : O(9 * row * col)
 * Space Complexity : O(1)
 *
 * Runtime: 8 ms, faster than 47.69% of Java online submissions for Image Smoother.
 * Memory Usage: 39.7 MB, less than 84.10% of Java online submissions for Image Smoother.
 *
 */
class Solution {
    public int[][] imageSmoother(int[][] img) {
        int row = img.length, col = img[0].length;
        int[][] res = new int[row][col];

        for (int r = 0; r < row; r++) {
            for (int c = 0; c < col; c++) {
                int count = 0;
                for (int r2 = r - 1; r2 <= r + 1; r2++) {
                    for (int c2 = c - 1; c2 <= c + 1; c2++) {
                        // Select the 9 elements and determine the boundaries
                        if (r2 >= 0 && r2 < row && c2 >= 0 && c2 < col) {
                            res[r][c] += img[r2][c2];
                            count++;
                        }
                    }
                }

                res[r][c] /= count;

            }
        }
        return res;
    }
}