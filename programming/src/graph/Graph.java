package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class Node {
	public char data;
	public boolean visited = false;

	public Node(char l) {
		this.data = l;
	}
}

class Graph {

	public Node rootNode;
	public ArrayList<Node> nodes = new ArrayList<Node>();
	public int[][] adjMatrix;// Edges will be represented as adjacency Matrix
	int size;

	Graph(int size) {
		this.size = size;
		nodes = new ArrayList<Node>();
		adjMatrix = new int[size][size];
	}

	public Graph() {
	}

	public void setRootNode(Node n) {
		this.rootNode = n;
	}

	public Node getRootNode() {
		return this.rootNode;
	}

	public void addNode(Node n) {
		nodes.add(n);
	}

	// This method will be called to make connect two nodes
	// Use for UNDIRECTED GRAPH
	public void connectNode(Node start, Node end) {
		if (adjMatrix == null) {
			size = nodes.size();
			adjMatrix = new int[size][size];
		}

		int startIndex = nodes.indexOf(start);
		int endIndex = nodes.indexOf(end);
		adjMatrix[startIndex][endIndex] = 1;
		adjMatrix[endIndex][startIndex] = 1;
	}

	/***
	 * Use for DIRECTED GRAPH
	 */
	public void addEdge(Node start, Node end) {
		if (adjMatrix == null) {
			size = nodes.size();
			adjMatrix = new int[size][size];
		}

		int startIndex = nodes.indexOf(start);
		int endIndex = nodes.indexOf(end);
		adjMatrix[startIndex][endIndex] = 1;
		// adjMatrix[endIndex][startIndex]=1;
	}

	@SuppressWarnings("unused")
	private void printAdj() {
		size = nodes.size();
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				System.out.print(adjMatrix[i][j] + " ");
			}
			System.out.println("");

		}
	}

	private Node getUnvisitedChildNode(Node n) {
		int index = nodes.indexOf(n);
		int j = 0;
		while (j < size) {
			if (adjMatrix[index][j] == 1 && (nodes.get(j)).visited == false) {
				return nodes.get(j);
			}
			j++;
		}
		return null;
	}

	private void clearNodes() {
		int i = 0;
		while (i < size) {
			Node n = (Node) nodes.get(i);
			n.visited = false;
			i++;
		}
	}

	private void printNode(Node n) {
		System.out.print(n.data + " ");
	}

	public void dfs(Node start) {

		// DFS uses Stack data structure
		Stack<Node> s = new Stack<Node>();
		s.push(start);
		start.visited = true;
		printNode(start);
		while (!s.isEmpty()) {
			Node n = s.peek();
			Node child = getUnvisitedChildNode(n);
			if (child != null) {
				child.visited = true;
				printNode(child);
				s.push(child);
			} else {
				s.pop();
			}
		}
		System.out.println("");
		// Clear visited property of nodes
		clearNodes();
	}

	// BFS traversal of a tree is performed by the bfs() function
	public void bfs() {

		// BFS uses Queue data structure
		Queue<Node> q = new LinkedList<Node>();
		q.add(this.rootNode);
		printNode(this.rootNode);
		rootNode.visited = true;
		while (!q.isEmpty()) {
			Node n = q.remove();
			Node child = null;
			while ((child = getUnvisitedChildNode(n)) != null) {
				child.visited = true;
				printNode(child);
				q.add(child);
			}
		}
		// Clear visited property of nodes
		clearNodes();
	}

	public static void main(String[] args) {

		// Lets create nodes as given as an example in the article
		Node nA = new Node('A');
		Node nB = new Node('B');
		Node nC = new Node('C');
		Node nD = new Node('D');
		Node nE = new Node('E');
		Node nF = new Node('F');

		// Create the graph, add nodes, create edges between nodes
		Graph g = new Graph();
		g.addNode(nA);
		g.addNode(nB);
		g.addNode(nC);
		g.addNode(nD);
		g.addNode(nE);
		g.addNode(nF);

		g.connectNode(nA, nB);
		g.connectNode(nA, nC);
		g.connectNode(nA, nD);

		g.connectNode(nB, nE);
		g.connectNode(nB, nF);
		g.connectNode(nC, nF);

		Node oA = new Node('A');
		Node oB = new Node('B');
		Node oC = new Node('C');
		Node oD = new Node('D');
		Node oE = new Node('E');
		Node oF = new Node('F');

		Graph g1 = new Graph();

		g1.addNode(oA);
		g1.addNode(oB);
		g1.addNode(oC);
		g1.addNode(oD);
		g1.addNode(oE);
		g1.addNode(oF);

		g1.addEdge(oA, oB);
		g1.addEdge(oA, oC);
		g1.addEdge(oA, oD);

		g1.addEdge(oB, oE);
		g1.addEdge(oB, oF);
		g1.addEdge(oC, oF);

		// Perform the traversal of the graph
		System.out.println("DFS Traversal of a undirected Graph is ------------->");
		g.dfs(nB);
		System.out.println("DFS Traversal of a directed Graph is ------------->");
		g1.dfs(oB);
	}

}

// public class Graph {
// ArrayList<Node> nodes = new ArrayList<Node>();
// int[][] adjMatrix;
// int size = nodes.size();
//
// public Graph() {
// size = 0;
// adjMatrix = null;
// }
//
// public Graph(int size) {
// this.size = size;
// adjMatrix = new int[size][size];
// }
//
// class Node {
// int data;
// boolean visited;
//
// Node(int i) {
// data = i;
// visited = false;
// }
// }
//
// /**
// * -----------------------------------
// *
// */
// public void addNode(int data) {
// nodes.add(new Node(data));
// }
//
// public void connectNodes(Node start, Node end) {
// if (adjMatrix == null) {
// int size = nodes.size();
// adjMatrix = new int[size][size];
// } else {
// adjMatrix[nodes.indexOf(start)][nodes.indexOf(end)] = 1;
// adjMatrix[nodes.indexOf(end)][nodes.indexOf(start)] = 1;
// }
// }
//
// void addEdge(int i, int j) {
// adjMatrix[i][j] = 1;
// }
//
// void removeEdge(int i, int j) {
// adjMatrix[i][j] = 0;
// }
//
// boolean hasEdge(int i, int j) {
// return adjMatrix[i][j] == 1 ? true : false;
// }
//
// public Node getUnvisitedNodes(Node n) {
// int index = nodes.indexOf(n);
// int i = 0;
// while (i < nodes.size()) {
// if (adjMatrix[index][i] == 1 && nodes.get(i).visited == false) {
// return nodes.get(i);
// }
// i++;
// }
// return null;
// }
//
// public void clearNodes() {
// int i = 0;
// while (i < nodes.size()) {
// Node n = nodes.get(i);
// n.visited = false;
// i++;
// }
// }
//
// public void dfs(Node node) {
// clearNodes();
// Stack<Node> stack = new Stack<Node>();
// if (node == null) {
// return;
// }
// node.visited = true;
// stack.push(node);
// System.out.print("" + node.data + " ");
// while (!stack.isEmpty()) {
// Node temp = stack.peek();
// Node child = getUnvisitedNodes(temp);
// if (child != null) {
// System.out.print("" + child.data + " ");
// child.visited = true;
// stack.push(child);
//
// } else {
// stack.pop();
// }
//
// }
//
// }
//
// /** ----------------------------------- */
//
// public static void main(String[] args) {
// ArrayList<Node> nodes = new ArrayList<Node>();
// Graph g = new Graph(7);
// Node node40 =g.new Node(40);
// Node node10 =g.new Node(10);
// Node node20 =g.new Node(20);
// Node node30 =g.new Node(30);
// Node node60 =g.new Node(60);
// Node node50 =g.new Node(50);
// Node node70 =g.new Node(70);
//
// nodes.add(node40);
// nodes.add(node10);
// nodes.add(node20);
// nodes.add(node30);
// nodes.add(node60);
// nodes.add(node50);
// nodes.add(node70);
//
//
//
// int adjacency_matrix[][] = { { 0, 1, 1, 0, 0, 0, 0 }, // Node 1: 40
// { 0, 0, 0, 1, 0, 0, 0 }, // Node 2 :10
// { 0, 1, 0, 1, 1, 1, 0 }, // Node 3: 20
// { 0, 0, 0, 0, 1, 0, 0 }, // Node 4: 30
// { 0, 0, 0, 0, 0, 0, 1 }, // Node 5: 60
// { 0, 0, 0, 0, 0, 0, 1 }, // Node 6: 50
// { 0, 0, 0, 0, 0, 0, 0 }, // Node 7: 70
// };
// g.adjMatrix = adjacency_matrix;
// g.dfs(nodes.get(0));
// }
// }