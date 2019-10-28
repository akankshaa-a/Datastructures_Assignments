package queues;

import java.util.*;
/*
 * 	Program to sort the queue in-place, using Recursion
 */
public class SortQueue {
	
	/*
	 * Function to sort the queue 
	 * queue = queue to sort
	 * a = element from the top of recursive stack to be added to queue
	 * (For the first call, a=0)
	 * n = count of the recursive calls 
	 * (n is used to prevent the first a=0 being added to queue)
	 */
	static void sort(Queue queue, int a,int num)
	{
		if(queue.isEmpty())
		{
			queue.enqueue(a);	//Adding the smallest element to the queue after emptying it
			return;
		}
		int x,max,i;
		max=queue.dequeue();
		int size = queue.isEmpty()?0:(queue.rear - queue.front + 1);
		
		for(i=0;i<size;i++)
		{	
			// Iterating over all queue elements, to find Max element
			x = queue.dequeue();
			if(x>max)
			{
				queue.enqueue(max);
				max = x;
			}
			else
				queue.enqueue(x);
		}
		
		// Call the function with the max element
		sort(queue,max,num+1);
		
		//To avoid adding the first a=0 to the queue
		if(num!=0)
		queue.enqueue(a);
	}
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int i;
		
		System.out.println("Enter the number of elements:");
		int n = s.nextInt();
		
		Queue queue = new Queue(n*n);	//Queue size is n*n is created
		
		System.out.println("Enter the queue elements:");		
		for(i=0;i<n;i++)
			queue.enqueue(s.nextInt());
		
		System.out.println("\nInitially:");
		queue.printqueue();
		
		sort(queue,0,0);	//calling sort() with a=0, num=0
		
		System.out.println("\nAfter sorting:");
		queue.printqueue();
	}

}