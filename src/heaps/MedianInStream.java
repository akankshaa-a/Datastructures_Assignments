package heaps;

import java.util.*;

/*
 * Program to find the median
 * of a stream of numbers
 * using Heaps
 */
public class MedianInStream {
	
	//Function to print the median
	
	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		int i,n;
		MaxHeap Lmax = new MaxHeap();
		MinHeap Rmin = new MinHeap();
		double m = 0;
		int e;
		
		//Reading the no of elements:
		System.out.println("Enter the no of elements in array:");
		n = s.nextInt();
		int[] arr = new int[n];
		
		//Storing in array
		System.out.println("Enter the array elements:");
		for(i=0;i<n;i++)
			arr[i] = s.nextInt();
		
		for(i=0;i<n;i++)
		{
			e = arr[i];
			int diff = Lmax.getCount() - Rmin.getCount();
			switch(diff)
			{
				case 0: 	//Both Heaps have same size
					if(e<m)
					{
						Lmax.insert(e);
						m = Lmax.getTop();
					}
					else
					{
						Rmin.insert(e);
						m = Rmin.getTop();
					}
				break;
				
				
				case 1: 	//Left heap is bigger
					if(e<m)
					{
						/*
						 * If e belongs to the Left heap
						 * Balance the heaps before adding e to left heap
						 */
						Rmin.insert(Lmax.deleteTop());
						Lmax.insert(e);
					}
					else
						Rmin.insert(e);
					m = 0.5*(Lmax.getTop() + Rmin.getTop());
					break;
					
					
				case -1: 	//Right heap is bigger
					if(e<m)
					{	
						/*
						 * If e belongs to the Right heap
						 * Balance the heaps before adding e to Right heap
						 */
						Lmax.insert(Rmin.deleteTop());
						Rmin.insert(e);
					}
					else
						Lmax.insert(e);
					m = 0.5*(Lmax.getTop() + Rmin.getTop());
					break;
			}
			System.out.println("Median: "+m);
		}
	}

}
