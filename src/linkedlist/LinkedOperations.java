package linkedlist;

import java.util.*;

/*
 * Program to implement the Linked List Operations:
 * 	1. Insert at end
 * 	2. Insert at the beginning
 * 	3. Search for a number
 * 	4. Delete at start
 * 	5. Delete at end
 * 	6. Delete at index
 * 	7. Reverse list
 * 		a. Iterative method
 * 		b. Recursive method
 */
public class LinkedOperations {
	
	Node head = null;
	
	//Function to insert element at the end of list
	void insertEnd(int e)
	{
		Node node = new Node(e);
		Node temp = head;
		if(head==null)
		{
			head=node;
			return;
		}
		while(temp.next!=null)
			temp = temp.next;
		temp.next = node;
	}
	
	//Function to insert element at the start of list
	void insertFront(int e)
	{
		Node node = new Node(e);
		node.next = head;
		head = node;
	}
	
	/*
	 * Function to Search for a number in a list
	 * Returns index of the element e, if e is in list
	 * Returns -1 if e is not found in list
	 */
	int search(int e)
	{
		Node temp = head;
		int pos = -1,i=0;
		while(temp!=null)
		{
			if(temp.val==e)
			{
				pos=i;
				break;
			}
			i++;
			temp = temp.next;
		}
		return pos;
	}
	
	//Function to delete an element from the start of a LinkedList
	int deleteFront() throws Exception
	{
		if(head==null)
			throw new Exception("List is Empty");
		else
		{
			int x = head.val;
			head = head.next;
			return x;
		}
	}
	
	//Function to delete the last element
	int deleteEnd() throws Exception
	{
		if(head==null)
			throw new Exception("List is Empty");
		else
		{
			Node temp = head;
			int x=0;
			if(head.next==null)
			{
				x = head.next.val;
				head.next = null;
			}
			else
			{
				while(temp.next.next!=null)
					temp = temp.next;
				x=temp.next.val;
				temp.next = null;
			}
			return x;
		}
	}
	
	/*
	 * Function to delete a node at index i
	 * index starts from 0
	 */
	int deleteIndex(int ind) throws Exception
	{
		int i = 0;
		Node temp = head;
		int x;
		if(ind<0)
			throw new Exception("Invalid index: "+ind);
		else if(ind==0)
		{
			x = head.val;
			head = head.next;
		}
		else
		{
			while(temp.next!=null)
			{
				if(i==ind-1)
					break;
				temp = temp.next;
				i++;
			}
			if(i==ind-1)
			{
				x = temp.next.val;
				temp.next = temp.next.next;
			}
			else
				throw new Exception("Invalid index: "+ind);
		}
		return x;
	}
	
	//Function to check if the list is empty
	boolean isEmpty()
	{
		return head==null;
	}
	
	//Function to Reverse list without recursion
	void reverseIter() throws Exception
	{
		Stack<Integer> stack = new Stack<Integer>();
		while(!isEmpty())
			stack.push(deleteFront());
		while(!stack.empty())
			insertEnd(stack.pop());
	}
	
	//Function to Reverse list using recursion
		void reverseRec() throws Exception
		{
			if(isEmpty())
				return;
			else
			{
				int x = deleteFront();
				reverseRec();
				insertEnd(x);				
			}
		}
	
	//Function to print the contents of LinkedList
	void printlist()
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
		LinkedOperations list = new LinkedOperations();
		
		/*
		 * Adding elements to list using insertFront() function
		 */
		System.out.println("\nInsert front: 50,40,30,20,10");
		list.insertFront(50);
		list.insertFront(40);
		list.insertFront(30);
		list.insertFront(20);
		list.insertFront(10);
		list.printlist();
		
		/*
		 * Adding elements to list using insertEnd() function
		 */
		System.out.println("\nInsert end: 60,70,80,90,100");
		list.insertEnd(60);
		list.insertEnd(70);
		list.insertEnd(80);
		list.insertEnd(90);
		list.insertEnd(100);
		list.printlist();
		
		
		/*
		 * Deleting the first element using deleteFront() function
		 */
		System.out.println("\nDelete front: "+list.deleteFront());
		list.printlist();
		
		
		/*
		 * Deleting the last element using deleteEnd() function
		 */
		System.out.println("\nDelete end: "+list.deleteEnd());
		list.printlist();
		
		
		/*
		 * Deleting the first element using deleteIndex(0)
		 */
		System.out.println("\nDelete at index 0: "+list.deleteIndex(0));
		list.printlist();
		
		
		/*
		 * Deleting the last element using deleteIndex(6)
		 */
		System.out.println("\nDelete at index 6: "+list.deleteIndex(6));
		list.printlist();
		
		
		/*
		 * Deleting the middle elements using deleteIndex()
		 */
		System.out.println("\nDelete at index 3 and 2: "+list.deleteIndex(3)+" and "+list.deleteIndex(2));
		list.printlist();
		
		
		/*
		 * Trying to use the deleteIndex() function with an invalid index
		 */
		try{
			System.out.println("\nDelete at index 5: "+list.deleteIndex(5));
			list.printlist();
		}
		catch(Exception e)
		{
			System.out.println(e.toString());
		}
		
		
		
		
		/*
		 * Searching for an element that's in the list
		 */
		int element = 40;
		System.out.println("\nSearching for element: "+element);
		int pos = list.search(element);
		if(pos==-1)
			System.out.println(element+" not found");
		else
			System.out.println(element+" found at index "+pos);
		
		
		/*
		 * Searching for an element that's not in the list
		 */
		element = 60;
		System.out.println("\nSearching for element: "+element);
		pos = list.search(element);
		if(pos==-1)
			System.out.println(element+" not found");
		else
			System.out.println(element+" found at index "+pos);
		
		
		
		//Reversing list using iteration
		System.out.println("\nReversing the list iteratively. \nInitially:");
		list.printlist();
		list.reverseIter();
		System.out.println("After reversing:");
		list.printlist();
		
		
		
		//Reversing list using recursion		
		System.out.println("\nReversing the list recursively. \nInitially:");
		list.printlist();
		list.reverseIter();
		System.out.println("After reversing:");
		list.printlist();		
		
	}

}
