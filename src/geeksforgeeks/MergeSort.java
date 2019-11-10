package geeksforgeeks;

import java.util.*;

public class MergeSort {
	
	static void merge(int[] arr, int low1, int low2, int high2)
	{
		int high1 = low2-1;
		int temp[] = new int[high2-low1+1];
		int k = 0,i=low1,j=low2;
		
		while(i<=high1 && j<high2)
		{
			if(arr[i]<arr[j])
				temp[k++] = arr[i++];
			else
				temp[k++] = arr[j++];
		}
		
		while(i<=high1)
			temp[k++] = arr[i++];
		while(j<high2)
			temp[k++] = arr[j++];
		
		i = low1;
		k=0;
		for(k=0;k<(high2-low1+1);k++)
			arr[i++] = temp[k];
		
	}
	
	static void mergesort(int[] arr, int low, int high)
	{
		if(low<high)
		{
			int mid =(low+high)/2;
			mergesort(arr,low,mid);
			mergesort(arr,mid+1,high);
			merge(arr,low,mid+1,high);
		}
	}
	public static void main(String args[])
	{
		Scanner s = new Scanner(System.in);
		
		//Reading the array
		System.out.println("Enter array size");
		int n = s.nextInt();
		int[] arr = new int[n];
		int i;
		System.out.println("Enter array:");
		for(i=0;i<n;i++)
			arr[i] = s.nextInt();
		
		
	}
}
