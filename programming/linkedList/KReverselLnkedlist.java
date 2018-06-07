package linkedlists;
import linkedlists.LinkedList.ListNode;
//import linkedlists.ReverseList;
/**
 * 
 * Given a singly linked list and an integer K, reverses the nodes of the
 * 
 * list K at a time and returns modified linked list.
 * 
 * NOTE : The length of the list is divisible by K Example :
 * 
 * Given linked list 1 -> 2 -> 3 -> 4 -> 5 -> 6 and K=2,
 * 
 * You should return 2 -> 1 -> 4 -> 3 -> 6 -> 5
 * 
 * Try to solve the problem using constant extra space.
 *
 *
 */
public class KReverselLnkedlist {
	public static ListNode reverseList(ListNode A, int B) {
		if(B==0)
			return A;

		// fake is used to find the new head
		ListNode fake = null;
		// flag that will be set if the current node is the head of the rseult list
		boolean first = true;
		// cu current node
		ListNode cu = A;
		ListNode end = A;
		int i=0;
		ListNode rs = A;
		//ListNode re = null;
		while(cu!=null) {
			i++;
			//reverse will be called only when i % B==0 else current = current.next
			if(i % B==0) {
				//temp is the node after the cu
				// Save the node next to cu 
				ListNode temp = cu.next;
				 //  Unlink the endNode
				cu.next = null;
				// only for first iteration 
				if(first==true) {
					fake=reverse(rs);
					first=false;
				}else {
					end.next = reverse(rs);
				}
				//after reversing rs will be the last node
				//the returned list will be blah->blah->rs->null
				//so link the returned list to the temp
				rs.next = temp;
				//so for the next iteration save the last node
				end = rs;
				//initialize for next iteration
				rs=rs.next;
				cu = temp;
			
			}else {
				cu=cu.next;
			}
		}
		
		
		
		return fake;
    }
	
	
	public static ListNode reverse(ListNode A) {
		ListNode prev = null;
		ListNode current = A;
		ListNode temp=null;
		while(current!=null) {
			temp=current.next;
			current.next = prev;
			prev = current;
			current = temp;
		}
		return prev;
	}
	
	public static void main(String args[]) {
		LinkedList a = new LinkedList();
		int[] arr1 = { 1,2,3,4,5,6 };
		for (int i : arr1) {
			a.add(i);
		}
		System.out.print("Original List ");
		a.printList();
		a.head = reverseList(a.head,4);
		System.out.print("reversed List ");
		a.printList();
		
		
		
	}
	
}
