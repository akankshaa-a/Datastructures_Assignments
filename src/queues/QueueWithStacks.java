package queues;

import java.util.*;

/*
 * Program to implement a queue
 * using Stacks 
 */
public class QueueWithStacks {

	Stack<Integer> s1 = new Stack<Integer>();
	Stack<Integer> s2 = new Stack<Integer>();
	
	//Function to add element to queue
	void enqueue(int x)
	{
		s1.push(x);
	}
	
	//Function to remove element from the queue
	int dequeue()
	{
		if(s1.empty())
		{
			System.out.println("Queue is empty");
			return -99999;
		}

		while(!s1.empty())
			s2.push(s1.pop());
		
		int x = s2.pop();
		
		while(!s2.empty())
			s1.push(s2.pop());
		
		return x;
	}
	
	//Function to print queue contents
	void printqueue()
	{
		System.out.println(s1);
	}
	
	
	public static void main(String[] args) {
		
		//Adding elements to queue
		
		QueueWithStacks q = new QueueWithStacks();
		q.enqueue(1);
		q.enqueue(2);
		q.enqueue(3);
		q.printqueue();
		
		//Removing element ( "1" should be removed from queue)
		q.dequeue();
		q.printqueue();
		
		//Adding another element to queue
		q.enqueue(4);
		q.printqueue();
	}

}