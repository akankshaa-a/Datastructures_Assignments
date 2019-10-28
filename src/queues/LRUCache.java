package queues;

import java.util.*;

/*
 * Program to implement the LRU cache
 * Using a circular queue
 * Time complexity: O(m*n)
 *  				m = size of reference string
 *  				n = size of cache
 */
public class LRUCache {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int i,r,flag=0,x,j;
		int pf = 0; 	//Initially, no. of page faults: 0
		
		
		System.out.println("Enter the size of the cache(n)");
		int n = s.nextInt();
		CircularQueue cq = new CircularQueue(n);	// We use a circular queue as the LRU cache
		
		
		System.out.println("Enter the size of the reference string(m)");
		int m = s.nextInt();
		int[] rs = new int[m];		//Storing the sequence of pages in an array
		
		System.out.println("Enter the reference string:");
		for(i=0;i<m;i++)
			rs[i] = s.nextInt();
		
		for(i=0;i<m;i++)
		{
			r = rs[i];	//r is the current element in demand
			
			if(cq.isEmpty())
			{
				/*
				 * if the cache is empty, its a page miss,
				 * So we increment pf(the page fault count)
				 * and add the new page to the cache 
				 */
				cq.enqueue(r);
				pf++;	
				continue;
			}
			
			flag = 0;
			int c = cq.count;	// c stores the no. of elements in the cache
			
			for(j=0;j<c;j++)
			{
				/*
				 * Iterate c times, checking each element(x)
				 *  comparing it to the requested element(r)
				 *  and put x back to the queue ONLY if x!=r
				 */
				x = cq.dequeue();
				if(x==r)
					flag=1;	// Page hit occurs when r is in cache
				else
					cq.enqueue(x);
			}
			
			if(flag!=1)
			{
				/*
				 * When it is a page miss(flag==0)
				 * we increment page fault count(pf)
				 */
				pf++;
				
				if(cq.isFull())	
					cq.dequeue();	//Remove the least recently used (LRU) element
			}
			cq.enqueue(r);	//Adding recently used element to cache
		}
		
		System.out.println("No of page faults:"+pf);
		System.out.print("Queue:");
		cq.printqueue();
			
		
	}

}