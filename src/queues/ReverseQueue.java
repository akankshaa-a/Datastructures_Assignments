package queues;

import java.util.*;

/*
 * Program to reverse queue contents using a stack
 */
public class ReverseQueue {
	
	static int front = -1, rear = -1,size=50;
	static int[] queue = new int[size];
	
	//Function to check if the queue is empty
	static boolean isEmpty()
	{
		return front==-1;
	}
	
	//Function to check if the queue is full
	static boolean isFull()
	{
		return rear==size-1;
	}
	
	//Function to add an element to the back of the queue
	static void enqueue(int x)
	{
		if(isFull())
		{
			System.out.println("Queue is full!");
			return;
		}
		else
		{
			if(isEmpty())
				front++;
			queue[++rear] = x;
		}
	}
	
	
	//Function to remove an element from the front of queue
	static int dequeue()
	{
		int x=-1;
		if(isEmpty())
			//throw new Exception
			System.out.println("Queue is Empty!");
		else
		{
			x = queue[front];
			if(front==rear)
			{
				front = -1;
				rear = front;
			}
			else
				front++;
		}
		return x;
		
	}
	
	
	//Function to print contents of queue
	static void printqueue()
	{
		int i;
		if(!isEmpty())
		{
			System.out.println();
			for(i=front;i<=rear;i++)
				System.out.print(queue[i]+" ");
		}
	}
	
	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);
		int i,n;
		
		//Populating the queue with some elements
		System.out.println("Enter the no. of elements:");
		n = s.nextInt();
		
		System.out.println("Enter the queue elements:");
		for(i=0;i<n;i++)
			enqueue(s.nextInt());
		
		
		//Displaying the initial queue contents
		System.out.print("\nInitially:");
		printqueue();
		
		Stack<Integer> s1 = new Stack<Integer>();
		
		while(!isEmpty())
			s1.push(dequeue()); //Pushing all queue elements to stack
		
		while(!s1.empty())
				enqueue(s1.pop());  //Popping all stack elements back to queue
		
		//Displaying the queue after reversal
		System.out.print("\nAfter reversal:");
		printqueue();
		
	}

}
