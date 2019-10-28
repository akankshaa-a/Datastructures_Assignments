package general;

import java.util.*;
/*
 * Program to find an element in a sorted 2D array
 */
public class FindIn2D {

	//BINARY SEARCH of element in column
	static void searchincol(int[][] arr, int col, int elem)
	{
		int low=0, high= arr.length-1,mid;
		while(low<=high)
		{
			mid = (low+high)/2;
			if(arr[mid][col]==elem)
			{
				System.out.println("Found "+elem+" at "+mid+","+col);
				return;
			}
			else if(arr[mid][col]<elem)
				low=mid+1;
			else 
				high=mid-1;

		}
		System.out.println("Not found");
		return;
	}
	
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int arr[][]={{11,21,31,41,51},
					{12,22,32,42,52},
					{13,23,33,43,53},
					{14,24,34,44,54},
					{15,25,35,45,55}};
		
		System.out.println("Enter element to search");
		int elem = sc.nextInt();
		int low=0,high=arr[0].length-1,mid;
		
		while(low<=high)
		{
			mid=(low+high)/2;
			
			//To prevent infinite loop, in case element is in the middle row 
			if(mid+1 < arr[0].length)
			{
				if(arr[0][mid]<elem && elem<arr[0][mid+1])
				{	
					searchincol(arr,mid,elem);
					return;
				}
					
			}
			
			//Logic similar to binary search
			if(arr[0][mid]==elem)
			{
				System.out.println("Found at 0,"+mid);
				return;
			}
			else if(arr[0][mid]>elem)
				high=mid-1;
			else
				low=mid+1;
			
			//To search for elements in the first and last column
			if( (high-low==1 && arr[0][low]<elem && arr[0][high]>elem) ||(high==low))
			{
				searchincol(arr,low,elem);
				return;
			}
			
		}
		
		System.out.println("Not found");
		
		
		
	}

}