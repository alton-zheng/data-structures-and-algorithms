package class16;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map.Entry;

// no negative weight
public class Code06_Dijkstra {

	public static HashMap<Node, Integer> dijkstra1(Node from) {
		HashMap<Node, Integer> distanceMap = new HashMap<>();
		distanceMap.put(from, 0);
		// 打过对号的点
		HashSet<Node> selectedNodes = new HashSet<>();
		Node minNode = getMinDistanceAndUnselectedNode(distanceMap, selectedNodes);
		while (minNode != null) {
			//  原始点  ->  minNode(跳转点)   最小距离distance
			int distance = distanceMap.get(minNode);
			for (Edge edge : minNode.edges) {
				Node toNode = edge.to;
				if (!distanceMap.containsKey(toNode)) {
					distanceMap.put(toNode, distance + edge.weight);
				} else { // toNode 
					distanceMap.put(edge.to, Math.min(distanceMap.get(toNode), distance + edge.weight));
				}
			}
			selectedNodes.add(minNode);
			minNode = getMinDistanceAndUnselectedNode(distanceMap, selectedNodes);
		}
		return distanceMap;
	}

	public static Node getMinDistanceAndUnselectedNode(HashMap<Node, Integer> distanceMap, HashSet<Node> touchedNodes) {
		Node minNode = null;
		int minDistance = Integer.MAX_VALUE;
		for (Entry<Node, Integer> entry : distanceMap.entrySet()) {
			Node node = entry.getKey();
			int distance = entry.getValue();
			if (!touchedNodes.contains(node) && distance < minDistance) {
				minNode = node;
				minDistance = distance;
			}
		}
		return minNode;
	}

	public static class NodeRecord {
		public Node node;
		public int distance;

		public NodeRecord(Node node, int distance) {
			this.node = node;
			this.distance = distance;
		}
	}

	public static class NodeHeap {
		// 实际的堆结构
		private Node[] nodes;


		// key 某一个 node， value 上面 nodes 堆中的位置
		// 当被访问过，将值更新为 -1， isEntered
		private HashMap<Node, Integer> heapIndexMap;

		// key 某一个节点， value 从源节点出发到该节点的目前最小距离
		private HashMap<Node, Integer> distanceMap;

		// 堆上有多少个点
		private int size;
		public NodeHeap(int size) {
			nodes = new Node[size];
			heapIndexMap = new HashMap<>();
			distanceMap = new HashMap<>();
			size = 0;
		}

		public boolean isEmpty() {
			return size == 0;
		}

		// 有一个点叫node，现在发现了一个从源节点出发到达node的距离为distance
		// 判断要不要更新，如果需要的话，就更新
		public void addOrUpdateOrIgnore(Node node, int distance) {

			// 检查是否在堆上，在对上，说明已经进来过
			if (inHeap(node)) {

				// 更新小值
				distanceMap.put(node, Math.min(distanceMap.get(node), distance));

				// 更新堆位置
				insertHeapify(node, heapIndexMap.get(node));
			}


			// 没进来过
			if (!isEntered(node)) {

				// 更新到对上最后一位
				nodes[size] = node;
				// 更新反向索引结构
				heapIndexMap.put(node, size);

				// 距离结构新增 node 数据
				distanceMap.put(node, distance);

				// 上推，更新堆结构
				insertHeapify(node, size++);
			}
		}


		// 弹出 head
		public NodeRecord pop() {

			// 记录 nodeRecord
			NodeRecord nodeRecord = new NodeRecord(nodes[0], distanceMap.get(nodes[0]));

			// 首位置和尾位置替换
			swap(0, size - 1);

			// 更新下标 -> -1
			heapIndexMap.put(nodes[size - 1], -1);

			// node -> distance 结构中，将弹出的 node 移除
			distanceMap.remove(nodes[size - 1]);

			// free C++同学还要把原本堆顶节点析构，对java同学不必
			nodes[size - 1] = null;

			// 交换后的下推
			heapify(0, --size);

			// 返回 nodeRecord
			return nodeRecord;
		}

		private void insertHeapify(Node node, int index) {
			while (distanceMap.get(nodes[index]) < distanceMap.get(nodes[(index - 1) / 2])) {
				swap(index, (index - 1) / 2);
				index = (index - 1) / 2;
			}
		}

		private void heapify(int index, int size) {
			int left = index * 2 + 1;
			while (left < size) {
				int smallest = left + 1 < size && distanceMap.get(nodes[left + 1]) < distanceMap.get(nodes[left])
						? left + 1
						: left;
				smallest = distanceMap.get(nodes[smallest]) < distanceMap.get(nodes[index]) ? smallest : index;
				if (smallest == index) {
					break;
				}
				swap(smallest, index);
				index = smallest;
				left = index * 2 + 1;
			}
		}

		private boolean isEntered(Node node) {
			return heapIndexMap.containsKey(node);
		}

		private boolean inHeap(Node node) {

			// 进来过，且在 head 上的索引位置不等于 -1， -1 说明被访问过，被弹出了
			return isEntered(node) && heapIndexMap.get(node) != -1;
		}

		private void swap(int index1, int index2) {
			heapIndexMap.put(nodes[index1], index2);
			heapIndexMap.put(nodes[index2], index1);
			Node tmp = nodes[index1];
			nodes[index1] = nodes[index2];
			nodes[index2] = tmp;
		}
	}

	// 改进后的dijkstra算法
	// 从head出发，所有head能到达的节点，生成到达每个节点的最小路径记录并返回
	public static HashMap<Node, Integer> dijkstra2(Node head, int size) {

		// 先生成一个堆，大小为节点大小
		NodeHeap nodeHeap = new NodeHeap(size);

		// 加 head
		nodeHeap.addOrUpdateOrIgnore(head, 0);

		// 收集每个节点的 result
		HashMap<Node, Integer> result = new HashMap<>();
		while (!nodeHeap.isEmpty()) {

			// 弹出堆顶
			NodeRecord record = nodeHeap.pop();

			// cur 弹出的节点和 distance
			Node cur = record.node;
			int distance = record.distance;

			// 遍历边，放入堆中
			for (Edge edge : cur.edges) {
				nodeHeap.addOrUpdateOrIgnore(edge.to, edge.weight + distance);
			}

			// cur, distance -> result
			result.put(cur, distance);

		}
		return result;
	}

}
