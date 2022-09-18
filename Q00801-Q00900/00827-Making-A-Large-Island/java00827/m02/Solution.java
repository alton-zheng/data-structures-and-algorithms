package java00827.m02;

/**
 * @Description:
 * @Author: alton_z
 * @Create Date Time: 2022-09-18 08:52
 * @Update Date Time: 2022-09-18 08:52
 * @Updated-By: alton_z
 * @Update-Location:
 * 827. Making A Large Island #480
 */
class Solution {
    public int largestIsland(int[][] grid) {

        // 根据题意， grid col, row 一样长，都为 len
        int len = grid.length;

        // 构建并查集
        UnionFind unionFind = new UnionFind(grid);

        // 首次遍历
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {

                // grid[i][j] = 0 没有意义
                if (grid[i][j] == 0) {
                    continue;
                }

                // 如果 col - 1 有效且为 1， 合并并查集
                if (j - 1 >= 0 && grid[i][j - 1] == 1) {
                    unionFind.union(i * len + j - 1, i * len + j);
                }

                // 如果 row - 1 且为 1， 合并并查集
                if (i - 1 >= 0 && grid[i - 1][j] == 1) {
                    unionFind.union((i - 1) * len + j, i * len + j);
                }
            }
        }

        // 定义 res
        // 第二次遍历 grid
        int res = 0;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                // 如果为 1， 第一次遍历已经处理
                if (grid[i][j] == 1) continue;

                // 分别对 i,j 上下左右进行判断
                // 不越界且为 0， 说明上下左右失效，不能连通，否则查找他们的祖父节点
                // 并将他们赋值给 up, left, down, right
                int up = i - 1 < 0 || grid[i - 1][j] == 0 ? -1 : unionFind.find((i - 1) * len + j);
                int left = j - 1 < 0 || grid[i][j - 1] == 0 ? -1 : unionFind.find(i * len + j - 1);
                int down = i + 1 >= len || grid[i + 1][j] == 0 ? -1 : unionFind.find((i + 1) * len + j);
                int right = j + 1 >= len || grid[i][j + 1] == 0 ? -1 : unionFind.find(i * len + j + 1);

                // 面积 area, 如果 up < 0 -> 0 ,说明不存在，面积默认 为 0
                // 否则取 unionFind.area[up]
                int area = up < 0 ? 0 : unionFind.area[up];

                // 加上 left 面积
                if (left >= 0 && left != up) {
                    area += unionFind.area[left];
                }

                // 加上 down 面积
                if (down >= 0 && down != left && down != up) {
                    area += unionFind.area[down];
                }

                // 加上 right 面积
                if (right >= 0 && right != down && right != left && right != up) {
                    area += unionFind.area[right];
                }

                // 加上自身的面积， area + 1 ，然后取最大 res
                res = Math.max(res, area + 1);
            }
        }

        // 如果 res == 0 意味着什么呢？
        // 意味着 grid 都为 1
        return res == 0 ? len * len : res;
    }

    class UnionFind {
        int[] grandfather;
        int[] size;
        int[] area;

        public UnionFind(int[][] grid) {

            // grid row, col 长度 len
            int len = grid.length;

            // 元素个数 n
            int n = len * len;

            grandfather = new int[n];

            // size
            size = new int[n];

            // 记录每个位置 area
            area = new int[n];

            // 开始遍历每个位置, 将  size, root, area 数组进行初始化
            // 这里是二维遍历压缩状态为一维遍历，遍历的时间几乎是一样的
            // 看不明白的多看几遍
            // 每个 i 对应原 grid[i/len][i%len] 位置
            for (int i = 0; i < n; ++i) {

                // size 的每个位置默认为 0
                size[i] = 0;

                // root 位置等于位置标记
                grandfather[i] = i;

                // 初始面积为原二维数组的值
                //  grid[i / len][i % len] 要么为 0， 要么为 1
                area[i] = grid[i / len][i % len];
            }
        }

        //
        public int find(int i) {

            // 如果 i 的 grandfather 节点仍为 i
            if (grandfather[i] == i) {
                // 直接返回
                return i;
            }

            // 递归返回 grandfather[i] 节点
            return grandfather[i] = find(grandfather[i]);
        }

        //合并两个 set
        public void union(int x, int y) {

            // 找到 x, y 的祖父节点，并将他们赋值给 x, y
            x = find(x);
            y = find(y);

            // 如果 x == y 没有合并的必要
            if (x == y) return;

            // 大合小
            // 如果 x 大于 y 的 size, 将 y 合并到 x
            if (size[x] > size[y]) {

                // 面积自然也得合并
                area[x] += area[y];

                // 将 y 的祖父节点指向 x
                grandfather[y] = x;
            } else if (size[x] < size[y]) {

                // 反之亦然
                area[y] += area[x];
                grandfather[x] = y;
            } else {

                // 如果两者 size 相同
                area[x] += area[y];
                grandfather[y] = x;
                size[x] += 1;
            }
        }
    }
}


