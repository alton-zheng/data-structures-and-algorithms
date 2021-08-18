package java00000;

class Solution {

    private int flag = 0;
    public int latestDayToCross(int row, int col, int[][] cells) {

        int[][] help = new int[row][col];

        int[] h = new int[col];

        int res = 0;
        for (int[] cell : cells) {

            help[cell[0] - 1][cell[1] - 1] = 1;

            flag = 0;
            is(help, 0, 0, row, col);
            if (flag == 1) {
                res++;
            }  else {
                break;
            }
        }

        return res;

    }

    private void is(int[][] help, int r, int c, int row, int col) {



        if (c < 0 || c == col - 1) {
            return;
        }

        if (help[r][c] == 1) {
            return;
        }

        if (r == row - 1) {

            if (help[r][c] == 0) {
                flag = 1;
            }
            return;
        }

        is(help, r + 1, c, row, col);
        is(help, r, c + 1, row, col);
        is(help, r, c - 1, row, col);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().latestDayToCross(3, 3, new int[][]{{1, 1}, {2, 1}, {1, 2}, {2, 2}}));
    }
}