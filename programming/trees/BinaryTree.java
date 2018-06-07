package trees;

import java.util.Stack;

public class BinaryTree {
	Node root;

	BinaryTree(){
		root=null;
	}
	
	class Node {
		int data;
		Node left;
		Node right;

		Node(int data) {
			this.data = data;
			left = null;
			right = null;
		}
	}

	/**
	 * Returns true if the given target is in the binary tree. Uses a recursive
	 * helper.
	 */
	public boolean lookup(Node node, int data) {
		if (node == null)
			return false;
		if (node.data == data)
			return true;
		else {
			if (data < node.data)
				return lookup(node.left, data);
			else
				return lookup(node.right, data);
		}
	}

	/**
	 * Build 123 using only one pointer variable.
	 */
	public void build123() {
		root = new Node(2);
		root.left = new Node(1);
		root.right = new Node(3);
	}

	/**
	 * Recursive insert -- given a node pointer, recur down and insert the given
	 * data into the tree. Returns the new node pointer (the standard way to
	 * communicate a changed pointer back to the caller).
	 */
	public Node insert(Node node, int data) {
		if (node == null) {
			node = new Node(data);
		} else {
			if (data <= node.data) {
				node.left = insert(node.left, data);
			} else {
				node.right = insert(node.right, data);
			}
		}

		return (node);
	}

	/**
	 * Prints the node values in the "inorder" order. Uses a recursive helper to do
	 * the traversal.
	 */
	public void inorder(Node node) {
		if (node == null)
			return;
		inorder(node.left);
		System.out.print(node.data + " ");
		inorder(node.right);

	}

	/** 
	 Prints the node values in the "postorder" order. 
	 Uses a recursive helper to do the traversal. 
	*/
	public void postorder(Node node) {
		if (node == null)
			return;
		postorder(node.left);
		postorder(node.right);
		System.out.print(node.data + " ");
	}

	/** 
	 Prints the node values in the "preorder" order. 
	 Uses a recursive helper to do the traversal. 
	 */
	public void preorder(Node node) {
		if (node == null)
			return;
		System.out.print(node.data + " ");
		preorder(node.left);
		preorder(node.right);
	}
	
	/** 
	 Returns the number of nodes in the tree. 
	 Uses a recursive helper that recurs 
	 down the tree and counts the nodes. 
	*/ 
	public int size(Node node) {
		if(node==null)
			return 0;
		return 1 + size(node.left)+size(node.right);
	}
	
	/** 
	 Returns the max root-to-leaf depth of the tree. 
	 Uses a recursive helper that recurs down to find 
	 the max depth. 
	*/ 
	public  int maxDepth(Node node) {
		if(node==null)
			return 0;
		else{
			int lDepth = maxDepth(node.left); 
		    int rDepth = maxDepth(node.right);
		return (Math.max(lDepth, rDepth))+1;
		}
	}
	
	/** 
	 Returns the min root-to-leaf depth of the tree. 
	 Uses a recursive helper that recurs down to find 
	 the min depth. 
	*/ 
	public int minDepth(Node A) {
        if(A==null)
            return 0;
         // Base case : Leaf Node. This accounts for height = 1.
        if (A.left == null && A.right == null)
            return 1;
 
        // If left subtree is NULL, recur for right subtree
        if (A.left == null)
            return minDepth(A.right) + 1;
 
        // If right subtree is NULL, recur for right subtree
        if (A.right == null)
            return minDepth(A.left) + 1;
		return Math.min(minDepth(A.left),
                        minDepth(A.right)) + 1;
    }

	/** 
	 Returns the min value in a non-empty binary search tree. 
	 Uses a helper method that iterates to the left to find 
	 the min value. 
	*/ 
	public int minValue(Node node) {
		while(node.left!=null) {
			node=node.left;
		}
		return node.data;
	}

	/** ***********
	 Given a tree and a sum, returns true if there is a path from the root 
	 down to a leaf, such that adding up all the values along the path 
	 equals the given sum.
	 Strategy: subtract the node value from the sum when recurring down, 
	 and check to see if the sum is 0 when you run out of tree. 
	*/
	public boolean hasPathSum(Node node, int sum) {
		  // return true if we run out of tree and sum==0 
		  if (node == null) { 
		    return(sum == 0); 
		  } 
		  else { 
		  // otherwise check both subtrees 
		    int subSum = sum - node.data; 
		    return(hasPathSum(node.left, subSum) || hasPathSum(node.right, subSum)); 
		  } 
	}
	
	/**
	 *Inorder traversal without recursion 
	 */
	public void inorderNoRecursion(Node node) {
		if(node==null)
			return;
		Stack<Node> stack = new Stack<Node>();
		Node current = node;
		while(current!=null) {
			stack.push(current);
			current = current.left;
		}
		while(!stack.isEmpty() ) {
			current = stack.pop();
			System.out.print(current.data+" ");
		
			if (current.right != null) {
				current = current.right;
				
				while(current!=null) {
					stack.push(current);
					current = current.left;
				}
			}
			
		}
	}
	
	/** 
	 Changes the tree into its mirror image.

	 So the tree... 
	       4 
	      / \ 
	     2   5 
	    / \ 
	   1   3

	 is changed to... 
	       4 
	      / \ 
	     5   2 
	        / \ 
	       3   1

	 Uses a recursive helper that recurs over the tree, 
	 swapping the left/right pointers. 
	*/ 
		public void mirror(Node node) {
			if (node != null) { 
				 // do the sub-trees 
				 mirror(node.left); 
				 mirror(node.right);

				 // swap the left/right pointers 
				 Node temp = node.left; 
				 node.left = node.right; 
				 node.right = temp; 
			} 
		}
	 
		/** 
		 Changes the tree by inserting a duplicate node 
		 on each nodes's .left. 
		  
		 
		 So the tree... 
		    2 
		   / \ 
		  1   3

		 Is changed to... 
		       2 
		      / \ 
		     2   3 
		    /   / 
		   1   3 
		  / 
		 1

		 Uses a recursive helper to recur over the tree 
		 and insert the duplicates. 
		*/ 
	public void doubleTree(Node node) {
		if(node!=null) {
			doubleTree(node.left);
			doubleTree(node.right);
			
			Node temp = new Node(node.data);
			temp.left = node.left;
			node.left = temp;
		}
	}
	
	/**
	 Compares the receiver to another tree to 
	 see if they are structurally identical. 
	*/ 
	public static boolean sameTree(Node a, Node b) {
		if(a==null&&b==null) {
			return true;
		}else if(a!=null&&b!=null) {
			return (a.data == b.data && sameTree(a.left,b.left) && sameTree(a.right,b.right));
		}else
			return false;
	}
		
	public  boolean isBalancedTree(Node node) {  
	        int lh; /* for height of left subtree */
	  
	        int rh; /* for height of right subtree */
	  
	        /* If tree is empty then return true */
	        if (node == null)
	            return true;
	  
	        /* Get the height of left and right sub trees */
	        lh = maxDepth(node.left);
	        rh = maxDepth(node.right);
	  
	        if (Math.abs(lh - rh) <= 1
	                && isBalancedTree(node.left)
	                && isBalancedTree(node.right)) 
	            return true;
	  
	        /* If we reach here then tree is not height-balanced */
	        return false;
	    }
	
	public int isBalanced(Node A) {
		
	   return isBalancedTree(A) ? 1 : 0;
   }
	
		
 	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();
		BinaryTree t = new BinaryTree();
		t.build123();
		
		t.postorder(t.root);
		
		Node root = tree.root;
		tree.root=tree.insert(root, 50);
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
		System.out.print("Inorder = ");
		tree.inorderNoRecursion(tree.root);
		System.out.println();
		System.out.print("Postorder = ");
		tree.postorder(tree.root);
		System.out.println();
		System.out.print("Preorder = ");
		tree.preorder(tree.root);
		System.out.println();
		System.out.println("Tree size = "+tree.size(tree.root));
		System.out.println("Max Depth = "+tree.maxDepth(tree.root));
		System.out.println("Min Value = "+tree.minValue(tree.root));
		System.out.println("hasPathSum = "+tree.hasPathSum(tree.root,211));
		System.out.println("Max Depth tree1 left = "+tree.maxDepth(tree.root.left));
		System.out.println("Max Depth tree1 right= "+tree.maxDepth(tree.root.right));
		System.out.println("isBalanced= "+tree.isBalanced(tree.root));
		
		
		
		BinaryTree tree1 = new BinaryTree();
		tree1.root=tree1.insert(tree1.root,2);
		tree1.insert(tree1.root,1);
		tree1.insert(tree1.root,3);
		System.out.print("Inorder tree1= ");
		tree.inorder(tree1.root);
		tree1.doubleTree(tree1.root);
		System.out.println();
		System.out.print("postorder tree1= ");
		tree.postorder(tree1.root);
		
		System.out.println();
		BinaryTree tree2 = new BinaryTree();
		BinaryTree tree3 = new BinaryTree();
		tree2.build123();
		tree3.build123();
		System.out.println("isSameTree"+sameTree(tree2.root,tree3.root));
		
		
		System.out.println("Max Depth tree1 left = "+tree.maxDepth(tree.root.left));
		System.out.println("Max Depth tree1 right= "+tree.maxDepth(tree.root.right));
		System.out.println("isBalanced= "+tree.isBalanced(tree.root));
		
		BinaryTree tree4 = new BinaryTree();
		tree4.root=tree3.insert(tree4.root, 1);
		tree3.insert(tree4.root, 2);
		System.out.println("Max Depth tree4 left = "+tree.maxDepth(tree4.root.left));
		System.out.println("Max Depth tree4 right= "+tree.maxDepth(tree4.root.right));
		System.out.println("isBalanced tree4= "+tree.isBalanced(tree4.root));

	}

}
