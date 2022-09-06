package class14;

import java.util.HashMap;
import java.util.List;
import java.util.Stack;

public class Code05_UnionFind {

	public static class Node<V> {
		V value;

		public Node(V v) {
			value = v;
		}
	}

	public static class UnionFind<V> {

		// 每个节点的对应关系
		public HashMap<V, Node<V>> nodes;

		// 节点和它父亲节点的对应关系
		public HashMap<Node<V>, Node<V>> parents;

		// 集合的 size (只存集合的代表节点)
		public HashMap<Node<V>, Integer> sizeMap;

		// 构造方法
		public UnionFind(List<V> values) {
			nodes = new HashMap<>();
			parents = new HashMap<>();
			sizeMap = new HashMap<>();


			for (V cur : values) {

				// 每个节点信息都放入到 3 张 hash 表中
				Node<V> node = new Node<>(cur);

				// 每个节点的对应关系
				nodes.put(cur, node);

				// 初始状态，它的父亲是它自己
				parents.put(node, node);

				// 每个节点就是一个集合，size 为 1
				sizeMap.put(node, 1);
			}
		}

		/**
		 * 找祖先节点
		 */
		public Node<V> findAncestor(Node<V> cur) {

			// 定义 path 栈
			Stack<Node<V>> path = new Stack<>();

			// 开始 循环
			// 循环节后， cur 就是所有 path 栈中所有节点的公共 parent
			while (cur != parents.get(cur)) {

				// 每次进入，意味着节点的 parent 都非自己
				// 将 cur 压入 path 栈，进行子孙节点的记录
				path.push(cur);

				// cur 上推到 cur parent 节点
				cur = parents.get(cur);
			}

			// path 栈不为空时
			while (!path.isEmpty()) {

				// cur 为 祖先节点
				// 遍历 path, 将所有经过的子孙节点包括  cur
				// 父亲节点都指向祖先节点
				parents.put(path.pop(), cur);
			}

			// 返回祖先节点，也就是此方法的结果值 parent 节点
			return cur;
		}

		/**
		 * 判断两个节点是否是同一个集合
		 * @param a
		 * @param b
		 * @return
		 */
		public boolean isSameSet(V a, V b) {

			// 两个节点的祖先是不是一个
			return findAncestor(nodes.get(a)) == findAncestor(nodes.get(b));

		}

		/**
		 * union 两个 set
		 * @param a
		 * @param b
		 */
		public void union(V a, V b) {

			//找到 a, b 的祖先节点
			Node<V> aHead = findAncestor(nodes.get(a));
			Node<V> bHead = findAncestor(nodes.get(b));

			// 不是同一个节点的时候，union
			if (aHead != bHead) {
				int aSetSize = sizeMap.get(aHead);
				int bSetSize = sizeMap.get(bHead);

				// 找大小集合
				Node<V> big = aSetSize >= bSetSize ? aHead : bHead;
				Node<V> small = big == aHead ? bHead : aHead;

				// 小集合向大集合 union
				parents.put(small, big);

				// 修改 size， big [a + b]
				sizeMap.put(big, aSetSize + bSetSize);

				// small 已经被合并了，从 sizeMap 移除
				sizeMap.remove(small);
			}
		}

		/**
		 * 返回集合数
		 * @return
		 */
		public int sets() {
			return sizeMap.size();
		}

	}
}
