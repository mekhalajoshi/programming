package linkedLists;

import linkedLists.LinkedList.ListNode;

/**
 * Given a singly linked list, determine if its a palindrome. Return 1 or 0
 * denoting if its a palindrome or not, respectively.
 * 
 * Notes:
 * 
 * Expected solution is linear in time and constant in space. For example,
 * 
 * List 1-->2-->1 is a palindrome. List 1-->2-->3 is not a palindrome.
 *
 *
 */
public class PalindromeList {
	/**
	 * class ListNode { public int val; public ListNode next;
	 * 
	 * ListNode(int x) { val = x; next = null; } }
	 * 
	 */
	public static int lPalin(ListNode A) {
		LinkedList a = new LinkedList();
		LinkedList b = new LinkedList();
		LinkedList reverse = new LinkedList();
		a.head = A;
		b.head = a.frontBackSplit();
		reverse.head = b.reverseList();
		ListNode currenta = A;
		ListNode currentb = reverse.head;
		
		
		
		
		while (currentb != null) {
			if (currenta.val != currentb.val) {
				return 0;
			}
			currentb = currentb.next;
			currenta = currenta.next;
		}
		return 1;
	}

	public static void main(String[] args) {
		LinkedList a = new LinkedList();
		int[] arr1 = { 1, 2, 3, 3, 2 };
		for (int i : arr1) {
			a.add(i);	
			}
		System.out.print("Original List ");
		a.printList();
		System.out.println(lPalin(a.head)==1?"Palinderme":"Not a Palindrome" );
	}

}
