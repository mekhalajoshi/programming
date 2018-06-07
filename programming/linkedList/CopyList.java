package linkedlists;


import linkedlists.LinkedList.ListNode;

/***
 * Deep Copy
 *
 *
 */

public class CopyList {
	static LinkedList result = new LinkedList();

	public static ListNode copyRandomList(ListNode head) {
		if (head == null) {
			return null;
		}
		boolean first = true;
		ListNode current = head;
		ListNode temp = null;
		ListNode newHead = null;
		ListNode prev = null;

		while (current != null) {
			// make deep copy of node
			temp = result.new ListNode(current.val);
			// mark the first node as the new head
			if (first == true) {
				newHead = temp;
				prev = temp;
				first = false;
			}
			// keeptrack of the previous node to creat the next link
			prev.next = temp;
			prev = prev.next;
			current = current.next;
			
		}
		return newHead;
	}

	
	public static void main(String[] args) {
		LinkedList a = new LinkedList();
		int[] arr1 = { 1, 2, 3, 4, 5, 6 };
		for (int i : arr1) {
			a.add(i);
		}
		System.out.print("Original List ");
		a.printList();

		LinkedList b = new LinkedList();
		b.head = copyRandomList(a.head);
		System.out.print("Copied List ");
		b.printList();
		
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		
	}

}
