package linkedLists;

class ListNode {
	public int val;
	public ListNode next;

	ListNode(int x) {
		val = x;
		next = null;
	}

	public ListNode() {
		// TODO Auto-generated constructor stub
	}
}
public class LinkedList {
	ListNode head;

	
	LinkedList() {
		head = null;
	}

	

	/**------------------------------*/
	
	public void add(int val) {
		if (head == null) {
			head = new ListNode(val);
		} else {
			ListNode temp = head;
			while (temp.next != null) {
				temp = temp.next;
			}
			temp.next = new ListNode(val);
		}
	}

	public  int countNodes() {
		if (head == null) {
			return 0;
		} else {
			ListNode temp = head;
			int count = 0;
			while (temp != null) {
				count++;
				temp = temp.next;
			}
			return count;
		}

	}

	public ListNode getNthNode(int n) {
		if (head == null) {
			return null;
		} else {
			ListNode temp = head;
			while (n > 0) {
				if (temp.next != null)
					temp = temp.next;
				n--;
			}
			if (n == 0)
				return temp;
			else
				return null;
		}
	}
	
	/**
	 * This code handles inserting at the very front as a special case. Otherwise,
	 * it works by running a current pointer to the node before where the new node
	 * should go. Uses a for loop to march the pointer forward. The exact bounds of
	 * the loop (the use of < vs <=, n vs. n-1) are always tricky — the best
	 * approach is to get the general structure of the iteration correct first, and
	 * then make a careful drawing of a couple test cases to adjust the n vs. n-1
	 * cases to be correct. (The so called "OBOB" — Off By One Boundary cases.) The
	 * OBOB cases are always tricky and not that interesting. Write the correct
	 * basic structure and then use a test case to get the OBOB cases correct. Once
	 * the insertion point has been determined, this solution uses Push() to do the
	 * link in. Alternately, the 3-Step Link In code could be pasted here directly.
	 */
	public void insertNth(int n, int val) {
		if (head == null) {

		} else {
			ListNode temp = head;
			while (n > 1) {
				if (temp.next != null)
					temp = temp.next;
				n--;
			}
			ListNode newNode = new ListNode(val);
			newNode.next = temp.next;
			temp.next = newNode;
		}
	}

	/**
	 * Write a SortedInsert() function which given a list that is sorted in
	 * increasing order, and a single node, inserts the node into the correct sorted
	 * position in the list. While Push() allocates a new node to add to the list,
	 * SortedInsert() takes an existing node, and just rearranges pointers to insert
	 * it into the list. There are many possible solutions to this problem.
	 */
	public void sortedInsert(int val) {
		if (head == null) {
			add(val);
		} else {
			ListNode temp = head;
			if (temp.val >= val) {
				head = new ListNode(val);
				head.next = temp;
			} else {
				while (temp.next != null && temp.next.val <= val) {
					temp = temp.next;
				}
				ListNode newNode = new ListNode(val);
				newNode.next = temp.next;
				temp.next = newNode;
			}
		}
	}

	/**
	 * Write an Append() function that takes two lists, 'a' and 'b', appends 'b'
	 * onto the end of 'a', and then sets 'b' to NULL (since it is now trailing off
	 * the end of 'a'). Here is a drawing of a sample call to Append(a, b) with the
	 * start state in gray and the end state in black. At the end of the call, the
	 * 'a' list is {1, 2, 3, 4}, and 'b' list is empty.
	 */
	public void appendList(ListNode B) {
		if (head == null)
			head = B;
		else {
			ListNode temp = head;
			while (temp.next != null) {
				temp = temp.next;
			}
			temp.next = B;
		}
	}

	/**
	 * Given a list, split it into two sublists — one for the front half, and one
	 * for the back half. 
	 * If the number of elements is odd, the extra element should
	 * go in the front list. 
	 * So FrontBackSplit() on the list 
	 * 
	 * {2, 3, 5, 7, 11} 
	 * should yield the two lists 
	 * 
	 * {2, 3, 5} and {7, 11}. 
	 * 
	 * You should check your solution against a few
	 * cases (length = 2, length = 3, length=4) to make sure that the list gets
	 * split correctly near the short-list boundary conditions. If it works right
	 * for length=4, it probably works right for length=1000. You will probably need
	 * special case code to deal with the (length <2) cases. 
	 * 
	 * Hint. Probably the
	 * simplest strategy is to compute the length of the list, then use a for loop
	 * to hop over the right number of nodes to find the last node of the front
	 * half, and then cut the list at that point. There is a trick technique that
	 * uses two pointers to traverse the list. A "slow" pointer advances one nodes
	 * at a time, while the "fast" pointer goes two nodes at a time. When the fast
	 * pointer reaches the end, the slow pointer will be about half way. For either
	 * strategy, care is required to split the list at the right point.
	 */
	public  ListNode frontBackSplit() {
		if (head == null)
			return null;
		else {
			int count = countNodes();
			ListNode temp = head;
			if (count % 2 != 0) {
				count++;
			}
			count = count / 2;
			for (int i = 1; i < count; i++) {
					temp = temp.next;
			}
			ListNode newHead = temp.next;
			temp.next = null;
			return newHead;
		}
	}

	public ListNode reverseList() {
		if (head == null)
			return head;
		if (head.next == null)
			return head;
		ListNode current = head;
		ListNode previous = null;
		ListNode temp = null;
		while (current.next != null) {
			temp = current.next;
			current.next = previous;
			previous = current;
			current = temp;
		}
		current.next = previous;
		return current;
	}
	
	
	public void deleteList() {
		if (head != null) {
			head = null;
		}
	}

	public  void printList() {
		if (head == null) {
			System.out.println("null");
		} else {
			ListNode temp = head;
			while (temp != null) {
				System.out.print(temp.val + "->");
				temp = temp.next;
			}
			System.out.print("null");
			System.out.println();
		}
	}

	/**-----------------------------*/
	
	 
	public static void main(String args[]) {

		LinkedList a = new LinkedList();
		int[] arr1 = { 1, 1,4,5 };
		for (int i : arr1) {
			a.add(i);
		}
		System.out.println("Count Nodes");
		System.out.print("Original List ");
		a.printList();
		System.out.println("Number of nodes = "+a.countNodes());
		System.out.println("");
		System.out.println("");
		
		
		System.out.println("Insert Nth");
		a.insertNth(1, 99);
		System.out.print("Original List ");
		a.printList();
		System.out.println("1st node = "+ a.getNthNode(1).val);
		System.out.println("");
		System.out.println("");
		
		
		
		System.out.println("Sorted insert");
		System.out.print("Original List ");
		a.printList();
		System.out.print("Inserted 99999; List ");
		a.sortedInsert(99999);
		a.printList();
		System.out.println("");
		System.out.println("");
		
		
		System.out.println("Reverse List ");
		System.out.print("Original List ");
		a.printList();
		a.head=a.reverseList();
		System.out.print("Reversed List ");
		a.printList();
		System.out.println("");
		System.out.println("");
		
	
		
		System.out.println("Append List");
		LinkedList b = new LinkedList();
		b.add(0);
		
		System.out.print("List A ");
		a.printList();
		System.out.print("List B ");
		b.printList();
		a.appendList(b.head);
		System.out.print("Appended List A ");
		a.printList();
		System.out.println("");
		System.out.println("");
		
		
		
		System.out.println("FrontBackSplit ");
		System.out.print("original List ");
		a.printList();
		b.head = a.frontBackSplit();
		System.out.print("List A ");
		a.printList();
		System.out.print("List B ");
		b.printList();
		System.out.println("");
		System.out.println("");
		

	}

}
