package class16;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;

// OJ链接：https://www.lintcode.com/problem/topological-sorting
public class Code03_TopologicalOrderDFS2 {

	// 不要提交这个类
	public static class DirectedGraphNode {
		public int label;
		public ArrayList<DirectedGraphNode> neighbors;

		public DirectedGraphNode(int x) {
			label = x;
			neighbors = new ArrayList<DirectedGraphNode>();
		}
	}

	// 提交下面的
	public static class Record {
		public DirectedGraphNode node;
		public long nodes;

		public Record(DirectedGraphNode n, long o) {
			node = n;
			nodes = o;
		}
	}

	public static class MyComparator implements Comparator<Record> {

		@Override
		public int compare(Record o1, Record o2) {
			return o1.nodes == o2.nodes ? 0 : (o1.nodes > o2.nodes ? -1 : 1);
		}
	}

	public static ArrayList<DirectedGraphNode> topSort(ArrayList<DirectedGraphNode> graph) {

		// 定义缓存
		HashMap<DirectedGraphNode, Record> order = new HashMap<>();

		// 遍历图，将每个节点进行缓存
		// 每个节点的点次都会被缓存
		for (DirectedGraphNode cur : graph) {
			f(cur, order);
		}

		// 将记录提取出来
		ArrayList<Record> recordArr = new ArrayList<>();
		for (Record r : order.values()) {
			recordArr.add(r);
		}

		// 按点次进行排序
		recordArr.sort(new MyComparator());

		// 构建结果集
		ArrayList<DirectedGraphNode> ans = new ArrayList<>();
		for (Record r : recordArr) {
			ans.add(r.node);
		}
		return ans;
	}

	// 当前来到cur点，请返回cur点所到之处，所有的点次！
	// 返回（cur，点次）
	// 缓存！！！！！order   
	//  key : 某一个点的点次，之前算过了！
	//  value : 点次是多少
	public static Record f(DirectedGraphNode cur, HashMap<DirectedGraphNode, Record> order) {

		// 缓存过的，直接拿
		if (order.containsKey(cur)) {
			return order.get(cur);
		}
		// cur的点次之前没算过！
		// 所有子节点的点次，相加
		long nodes = 0;
		for (DirectedGraphNode next : cur.neighbors) {
			nodes += f(next, order).nodes;
		}

		// 构建结果
		Record ans = new Record(cur, nodes + 1);

		// 进缓存
		order.put(cur, ans);
		return ans;
	}

}
