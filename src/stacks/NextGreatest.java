package stacks;

import java.util.*;

/**
 * Program to find the next greatest element in an array
 */
public class NextGreatest {
	static int len=50,top=-1;
	static int[] stack = new int[len];
	
	/* Stack function: PUSH 
	 * Insert element at top of stack
	 */
	static void push(int x)
	{
		if(!isFull())
			stack[++top]=x;
		else
		{
			System.out.println("Stack is full");
			return;
		}
	}
	

	/* Stack function: POP 
	* Remove and return element at top of stack
	*/
	static int pop()
	{
		if(!isEmpty())
			return stack[top--];
		else
		{
			System.out.println("Stack is empty");
			return 0;
		}
	}
	
	/* Stack function: PEEK 
	 * Return element at top of stack
	 */
	static int peek()
	{
		if(!isEmpty())
			return stack[top];
		else
		{
			System.out.println("Stack is empty");
			return 0;
		}
	}
	
	/*
	 * Function to check if stack is full
	 */
	static boolean isFull()
	{
		return top==len-1;
	}
	
	/*
	 * Function to check if the stack is empty
	 */
	static boolean isEmpty()
	{
		return top==-1;
	}
	
	public static void main(String[] args) {
		Scanner s= new Scanner(System.in);
		
		int i,elem,maxindex;
		
		System.out.println("Enter the number of elements:");
		int n= s.nextInt();
		
		int[] arr = new int[n];
		System.out.println("Enter array elements:");
		for(i=0;i<n;i++)
			arr[i] = s.nextInt();
		
		//Map to store the element and their next greatest element
		HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
		
		//Last element(at position n-1) has no greater number
		i=n-1;
		map.put(arr[i], -1);
		push(arr[i]);
		
		maxindex=i;
		
		//Iterate from second-last to first element
		for(i=n-2;i>=0;i--)
		{
			elem = arr[i];
			
			if(arr[maxindex]<elem)
				maxindex = i;
			
			/*
			 * Pop until:
			 * 	Top element > current element (OR)
			 * 	Stack is empty
			 */
			while(!isEmpty() && peek()<elem) 
				pop();		
			if(isEmpty())
				map.put(elem,-1); //No element in stack is greater
			else
				map.put(elem,peek());
			
			push(elem);
		}
		
		for(i=0;i<n;i++)
		{
			elem = arr[i];
			if(i!=maxindex)
				System.out.println(elem+"-->"+map.get(elem));
		}
		
	}

}