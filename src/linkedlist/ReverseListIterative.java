package linkedlist;

/*
 * Program to reverse a linkedList 
 * Iteratively in O(n) time
 * using a Stack of nodes
 */
public class ReverseListIterative {

		static int top = -1,size = 100;
		static Node[] stack = new Node[size];
		
		//Function to reverse the stack iteratively:
		static Node reverseIter(Node head) throws Exception
		{
			Node temp = head;
			if(head==null)
				throw new Exception("List is empty");
			
			while(temp.next!=null)
			{
				push(temp);
				temp = temp.next;
			}
			
			head = temp;
			
			while(top!=-1)
			{
				temp = pop();
				temp.next.next = temp;
				temp.next = null;
			}
			
			return head;
		}
		
		//PUSH function of the stack:
		static void push(Node ele) throws Exception
		{
			if(top==size-1)
				throw new Exception("Stack overflow");
			stack[++top] = ele;
		}
		
		//POP function of the stack:
		static Node pop() throws Exception
		{
			if(top==-1)
				throw new Exception("Stack Underflow");
			return stack[top--];
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
			
			//Reversing list using Iterations		
			System.out.println("\nReversing the list iteratively. \nInitially:");
			printList(head);
			head = reverseIter(head);
			System.out.println("After reversing:");
			printList(head);

		}

	}

