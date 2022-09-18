package java00827.m03;

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

        // 存储每个位的 parent
        int[] grandFather;

        //
        int[] size;

        // help 数组
        int[] help;

        int[] area;

        // 并查集大小
        private int sets;

        public UnionFind(int[][] grid) {

            int len = grid.length;
            int n = len * len;

            // 初始状态并查集数量为 0
            sets = 0;

            // 数组长度都为 len
            grandFather = new int[n];
            size = new int[n];
            help = new int[n];
            area = new int[n];

            // 开始遍历每个位置, 将  size, root, area 数组进行初始化
            // 这里是二维遍历压缩状态为一维遍历，遍历的时间几乎是一样的
            // 看不明白的多看几遍
            // 每个 i 对应原 grid[i/len][i%len] 位置
            for (int i = 0; i < n; ++i) {

                // root 位置等于位置标记
                grandFather[i] = i;

                // 初始面积为原二维数组的值
                //  grid[i / len][i % len] 要么为 0， 要么为 1
                area[i] = grid[i / len][i % len];
            }
        }

        /**
         * 找父亲节点， 迭代方式
         * 有兴趣可以改成递归
         * 这里的 index 含义等价 r * col + c
         *
         * @return
         */
        private int find(int index) {

            // 每次 find 方法， help 数组的索引都从 0 开始
            // 也就是说 help 不断重用
            int helpIndex = 0;

            // index 位置 parent 位置不等于 index
            // 不断循环找到祖先
            while (index != grandFather[index]) {

                // 每个经过 index, 将他们记录到 help 数组中
                help[helpIndex++] = index;

                // index 上推到父亲 index, 周而复始
                index = grandFather[index];
            }

            // 对 index 所有经过的  parent index, 进行扁平化处理
            // 将它们 parent 都指向祖先 index
            for (helpIndex--; helpIndex >= 0; helpIndex--) {
                grandFather[help[helpIndex]] = index;
            }

            // 返回祖先节点
            return index;
        }

        /**
         * 合并 set
         */
        private void union(int x, int y) {

            // 找到两个点的 parent 节点
            x = find(x);
            y = find(y);

            // 如果他们两个为同一个点， 没有合并的需要
            // 不相等于进入判断
            if (x != y) {

                //  size 小的 set 合并到 size 大的 set 中
                // set size 合并
                // 集合合并，大吞小
                if (size[x] >= size[y]) {
                    area[x] += area[y];
                    size[x] += size[y];
                    grandFather[y] = x;
                } else {
                    area[y] += area[x];
                    size[y] += size[x];
                    grandFather[x] = y;
                }
                // 合并后， sets 自然需要减一
                sets--;
            }
        }
    }
}


