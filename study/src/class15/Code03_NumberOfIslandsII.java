package class15;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

// 本题为leetcode原题
// 测试链接：https://leetcode.com/problems/number-of-islands-ii/
// 所有方法都可以直接通过
public class Code03_NumberOfIslandsII {

	public List<Integer> numIslandsII(int m, int n, int[][] positions) {

		// 构造一个自定义的并查集
		UnionFind unionFind = new UnionFind(m, n);

		// 定义结果集，每个 positions 输出一次
		List<Integer> ans = new ArrayList<>();

		// 循环处理 positions 每个点
		for (int[] position : positions) {

			// 每次 connect 后的 set 数都添加到 ans 中
			ans.add(unionFind.connect(position[0], position[1]));
		}

		// 返回结果集
		return ans;
	}

	class UnionFind {

		// 存储每个位的 parent
		private int[] parent;

		//
		private int[] size;

		// help 数组
		private int[] help;

		// row 行数
		private final int row;

		// 列数
		private final int col;

		// 并查集大小
		private int sets;

		public UnionFind(int m, int n) {
			// m -> row
			row = m;

			// n -> col
			col = n;

			// 初始状态并查集数量为 0
			sets = 0;

			// 初始化并查集变量， len = row * col
			int len = row * col;
			// 数组长度都为 len
			parent = new int[len];
			size = new int[len];
			help = new int[len];
		}

		/**
		 * 返回 index 位置
		 * 位置 [r*col + c]
		 * @param r
		 * @param c
		 * @return
		 */
		private int index(int r, int c) {
			return r * col + c;
		}

		/**
		 * 找父亲节点， 迭代方式
		 * 有兴趣可以改成递归
		 * 这里的 index 含义等价 r * col + c
		 * @param index
		 * @return
		 */
		private int find(int index) {

			// 每次 find 方法， help 数组的索引都从 0 开始
			// 也就是说 help 不断重用
			int helpIndex = 0;

			// index 位置 parent 位置不等于 index
			// 不断循环找到祖先
			while (index != parent[index]) {

				// 每个经过 index, 将他们记录到 help 数组中
				help[helpIndex++] = index;

				// index 上推到父亲 index, 周而复始
				index = parent[index];
			}

			// 对 index 所有经过的  parent index, 进行扁平化处理
			// 将它们 parent 都指向祖先 index
			for (helpIndex--; helpIndex >= 0; helpIndex--) {
				parent[help[helpIndex]] = index;
			}

			// 返回祖先节点
			return index;
		}

		/**
		 * 合并 set
		 * @param r1
		 * @param c1
		 * @param r2
		 * @param c2
		 */
		private void union(int r1, int c1, int r2, int c2) {

			// 排除所有边界场景
			if (
					r1 < 0 || r1 == row
					|| r2 < 0 || r2 == row
					|| c1 < 0 || c1 == col
					|| c2 < 0 || c2 == col
			) {

				// 边界场景，直接返回，不进行 union 操作
				return;
			}

			// 找到两个点的 index 位置
			int i1 = index(r1, c1);
			int i2 = index(r2, c2);

			// 两个 set size 如果有一个为 0， 意味着没有合并的必要性
			// 直接返回
			if (size[i1] == 0 || size[i2] == 0) {
				return;
			}

			// 找到两个点的 parent 节点
			int f1 = find(i1);
			int f2 = find(i2);

			// 如果他们两个为同一个点， 没有合并的需要
			// 不相等于进入判断
			if (f1 != f2) {

				//  size 小的 set 合并到 size 大的 set 中
				// set size 合并
				// 集合合并，大吞小
				if (size[f1] >= size[f2]) {
					size[f1] += size[f2];
					parent[f2] = f1;
				} else {
					size[f2] += size[f1];
					parent[f1] = f2;
				}
				// 合并后， sets 自然需要减一
				sets--;
			}
		}


		/**
		 * 并查集 connect 方法
		 * @param r
		 * @param c
		 * @return
		 */
		public int connect(int r, int c) {

			// 求  index
			int index = index(r, c);

			// 如果 index size == 0, 意味着它从来都没处理过
			// 被处理过的话，直接忽略，返回原 sets
			if (size[index] == 0) {

				// index -> index (自己是自己的父亲)
				// size 为 1
				parent[index] = index;
				size[index] = 1;
				// 集合数加 1
				sets++;

				// 上下左右点， union当前 r,c 点
				union(r - 1, c, r, c);
				union(r + 1, c, r, c);
				union(r, c - 1, r, c);
				union(r, c + 1, r, c);
			}

			// 返回 sets
			return sets;
		}

	}

}
