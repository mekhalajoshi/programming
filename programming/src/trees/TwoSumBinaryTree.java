package trees;

/**
 * 2-Sum Binary Tree
Given a binary search tree T, where each node contains a positive integer, and an integer K, you have to find whether or not there exist two different nodes A and B such that A.value + B.value = K.

Return 1 to denote that two such nodes exist. Return 0, otherwise.

Notes

Your solution should run in linear time and not take memory more than O(height of T).
Assume all values in BST are distinct.
Example :

Input 1: 

T :       10
         / \
        9   20

K = 19

Return: 1

Input 2: 

T:        10
         / \
        9   20

K = 40

Return: 0


traverse binary search tree by inorder way and insert node’s value into a set. 
Also check for any node, difference between given sum and node’s value in set, 
if it is found then pair exists otherwise it doesn’t exist.
 */

import java.util.HashSet;
import java.util.Stack;

import trees.BinaryTree.Node;

public class TwoSumBinaryTree {

	public static int t2Sum(Node A, int B) {
		HashSet<Integer> set = new HashSet<Integer>();
		Stack<Node> stack = new Stack<Node>();
		while (A != null) {
			stack.push(A);
			A = A.left;
		}
		while (!stack.isEmpty()) {
			A = stack.pop();

			if (set.contains(B - A.data)) {
				System.out.println(A.data + "+" + (B - A.data) + "=" + B);
				return 1;
			} else {
				set.add(A.data);
			}

			if (A.right != null) {
				A = A.right;
				while (A != null) {
					stack.push(A);
					A = A.left;
				}
			}
		}
		return 0;
	}

	// InterviewBit
	public int t2Sum2(Node A, int B) {
		Stack<Node> left = new Stack<Node>();
		Stack<Node> right = new Stack<Node>();

		Node root = A;
		while (root != null) {
			left.push(root);
			root = root.left;
		}

		root = A;
		while (root != null) {
			right.push(root);
			root = root.right;
		}

		while (!left.isEmpty() && !right.isEmpty() && right.peek() != left.peek()) {
			if (left.peek().data + right.peek().data == B) {
				return 1;
			}
			if (left.peek().data + right.peek().data < B) {// need to increase
				Node t = left.pop();
				if (t.right != null) {
					t = t.right;
					while (t != null) {
						left.push(t);
						t = t.left;
					}
				}
			} else {// need to decrease
				Node t = right.pop();
				if (t.left != null) {
					t = t.left;
					while (t != null) {
						right.push(t);
						t = t.right;
					}
				}
			}
		}

		return 0;
	}

	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();
		// tree.build123();
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
		System.out.print("Inorder = ");
		tree.inorder(tree.root);
		System.out.println();
		System.out.println(t2Sum(tree.root, 81));

		BinaryTree tree1 = new BinaryTree();
		tree1.root = tree1.insert(tree1.root, 10);
		tree1.insert(tree1.root, 20);
		tree1.insert(tree1.root, 9);
		System.out.print("Inorder = ");
		tree.inorder(tree1.root);
		System.out.println(t2Sum(tree1.root, 19));
	}

}
