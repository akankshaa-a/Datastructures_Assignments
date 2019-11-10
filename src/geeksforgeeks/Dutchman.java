package geeksforgeeks;

import java.util.*;

public class Dutchman {

	/**
	 * @param args
	 */
	
	static void swap(int[] arr, int i, int j)
	{
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		System.out.println("Enter array size");
		int n = s.nextInt();
		int[] arr = new int[n];
		int i;
		System.out.println("Enter array:");
		for(i=0;i<n;i++)
			arr[i] = s.nextInt();
		int low=0, mid=0, high = n-1;
		while(mid<high)
		{
			switch(arr[mid])
			{
				case 0:
					swap(arr,low++,mid++);
					break;
				case 1:
					mid++;
					break;
				case 2:
					swap(arr,mid,high--);
					break;
			}
		}
		for(i=0;i<n;i++)
			System.out.print(arr[i]+" ");
				
	}

}
