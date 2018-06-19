package trees;

import java.util.LinkedList;
import java.util.Queue;

import trees.BinaryTree.Node;

public class LevleOrderTraversal {

	public void printLevelOrder1Line1Queue(Node node) {
		Queue<Node> q = new LinkedList<Node>();
		if (node != null) {
			q.add(node);
		}
		while (!q.isEmpty()) {
			Node current = q.poll();
			System.out.print(current.data + " ");
			if (current.left != null) {
				q.add(current.left);
			}
			if (current.right != null) {
				q.add(current.right);
			}
		}
		System.out.println("");
	}

	public void printLevelOrderLineByLine2Queue(Node node) {
		Queue<Node> q1 = new LinkedList<Node>();
		Queue<Node> q2 = new LinkedList<Node>();
		q1.add(node);
		while (!q1.isEmpty() || !q2.isEmpty()) {

			while (!q1.isEmpty()) {
				Node current = q1.poll();
				System.out.print(current.data + " ");
				if (current.left != null) {
					q2.add(current.left);
				}
				if (current.right != null) {
					q2.add(current.right);
				}
			}
			System.out.println("");

			while (!q2.isEmpty()) {
				Node current = q2.poll();
				System.out.print(current.data + " ");
				if (current.left != null) {
					q1.add(current.left);
				}
				if (current.right != null) {
					q1.add(current.right);
				}
			}
			System.out.println("");

		}

	}

	public void leftView(Node node) {
		Queue<Node> q1 = new LinkedList<Node>();
		Queue<Node> q2 = new LinkedList<Node>();
		q1.add(node);
		boolean first = true;
		while (!q1.isEmpty() || !q2.isEmpty()) {

			while (!q1.isEmpty()) {
				Node current = q1.poll();
				if (first) {
					System.out.print(current.data + " ");
					first = false;
				}
				if (current.left != null) {
					q2.add(current.left);
				}
				if (current.right != null) {
					q2.add(current.right);
				}
			}
			first = true;

			while (!q2.isEmpty()) {
				Node current = q2.poll();
				if (first) {
					System.out.print(current.data + " ");
					first = false;
				}
				if (current.left != null) {
					q1.add(current.left);
				}
				if (current.right != null) {
					q1.add(current.right);
				}
			}
			first = true;
		}
		System.out.println("");
	}

	public void rightView(Node node) {
		Queue<Node> q1 = new LinkedList<Node>();
		Queue<Node> q2 = new LinkedList<Node>();
		q1.add(node);

		while (!q1.isEmpty() || !q2.isEmpty()) {

			while (!q1.isEmpty()) {
				Node current = q1.peek();
				if(q1.size()==1) {
					System.out.print(current.data + " ");
				}
				current = q1.poll();
				if (current.left != null) {
					q2.add(current.left);
				}
				if (current.right != null) {
					q2.add(current.right);
				}
			}

			while (!q2.isEmpty()) {
				Node current = q2.peek();
				if(q2.size()==1) {
					System.out.print(current.data + " ");
				}
				current = q2.poll();
				if (current.left != null) {
					q1.add(current.left);
				}
				if (current.right != null) {
					q1.add(current.right);
				}
			}
		}
		System.out.println("");
	}

	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();
		Node root = tree.root;
		tree.root = tree.insert(root, 50);
		tree.insert(tree.root, 30);
		tree.insert(tree.root, 40);
		tree.insert(tree.root, 70);
		tree.insert(tree.root, 69);
		tree.insert(tree.root, 90);
		tree.insert(tree.root, 29);
		tree.insert(tree.root, 28);
		tree.insert(tree.root, 39);
		tree.insert(tree.root, 38);
		tree.insert(tree.root, 37);
		tree.insert(tree.root, 36);

		System.out.println("Level Order Traversal One Line");
		new LevleOrderTraversal().printLevelOrder1Line1Queue(tree.root);
		System.out.println("");

		System.out.println("Level Order Traversal Line By Line 2 Queues");
		new LevleOrderTraversal().printLevelOrderLineByLine2Queue(tree.root);
		System.out.println("");

		System.out.println("Left View");
		new LevleOrderTraversal().leftView(tree.root);
		System.out.println("");

		System.out.println("Right View");
		new LevleOrderTraversal().rightView(tree.root);
		System.out.println("");
	}

}
