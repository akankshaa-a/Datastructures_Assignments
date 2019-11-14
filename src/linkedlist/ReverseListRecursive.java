package linkedlist;

/*
 * Program to reverse a linkedList 
 * Recursively using a single pointer
 */
public class ReverseListRecursive {

	//Function to reverse the linked list recursively:
	static Node reverseRec(Node node)
	{
		if(node==null || node.next==null)
			return node;	//Returning the last node (revHead)
		
		Node revHead = reverseRec(node.next); //Pushing the next node onto recursive stack
		
		//Modifying the links:
		node.next.next = node;
		node.next = null;
		
		return revHead;
	}
	
	//Function to insert elements at the end of the list
	static Node insertEnd(Node head, int ele) throws Exception
	{
		Node temp = head;
		Node node = new Node(ele);
		if(head==null)
		{
			head = node;
			return head;
		}
		while(temp.next!=null)
			temp = temp.next;
		temp.next = node;
		return head;
	}
	
	//Function to print the contents of linkedList
	static void printList(Node head)
	{
		Node temp = head;
		while(temp!=null)
		{
			System.out.print(temp.val+" ");
			temp = temp.next;			
		}
		System.out.println();		
	}
	
	public static void main(String[] args) throws Exception {
		int i;
		int[] arr = {1,2,3,4,5};
		
		Node head = null;
		
		for(i=0;i<arr.length;i++)
			head = insertEnd(head,arr[i]);
		
		//Reversing list using recursion		
		System.out.println("\nReversing the list recursively. \nInitially:");
		printList(head);
		head = reverseRec(head);
		System.out.println("After reversing:");
		printList(head);

	}

}
