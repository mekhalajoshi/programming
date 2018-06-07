package linkedlists;

public class CloneListRandomPointer {

	class RandomListNode {
		int label;
		RandomListNode next, random;

		RandomListNode(int x) {
			this.label = x;
		}

		public RandomListNode() {
		}
	}

	public RandomListNode copyRandomList(RandomListNode head) {
		RandomListNode headA = head;
		RandomListNode headB = null;
		RandomListNode currentA = headA;
		RandomListNode currentB = null;
		RandomListNode temp = null;
		
		while(currentA!=null) {
			currentB = new RandomListNode (currentA.label);
			currentB.next = currentA.next;
			currentA.next = currentB;
			currentA=currentB.next;
		}
		
		currentA = headA;
		currentB = currentA.next;
		while(currentA!=null) {
			if(currentA.random!=null)
				currentA.next.random = currentA.random.next;
			currentA = currentA.next.next;
		}
		
		currentA = headA;
		currentB = currentA.next;
		headB=currentA.next;
		while(currentA!=null) {
			temp = currentA.next;
			currentA.next = temp.next;
			if (temp.next != null)
				temp.next = temp.next.next;
			currentA = currentA.next;
					
		}
		
		return headB;
	}
	
	
	public static void main(String[] args) {
		
		CloneListRandomPointer x = new CloneListRandomPointer();
		RandomListNode a = null;
		RandomListNode temp =  null;
		temp = x.new RandomListNode(0);
		a=temp;
		int[] arr1 = { 1, 2, 3, 4, 5, 6 };
		for (int i : arr1) {
			x.add(temp,i);
		}
		temp=a;
		System.out.print("Original List ");
		x.printList(temp);
		
		RandomListNode b = x.copyRandomList(a);
		
		System.out.print("Copied List ");
		x.printList(b);

	}

	
	
	public   void printList(RandomListNode h) {
		if (h == null) {
			System.out.println("null");
		} else {
			RandomListNode temp = h;
			while (temp != null) {
				System.out.print(temp.label + "->");
				temp = temp.next;
			}
			System.out.print("null");
			System.out.println();
		}
	}
	
	public  void add(RandomListNode head,int label) {
		if (head == null) {
			head = new RandomListNode(label);
		} else {
			RandomListNode temp = head;
			while (temp.next != null) {
				temp = temp.next;
			}
			temp.next = new RandomListNode(label);
		}
	}
	
	
}
