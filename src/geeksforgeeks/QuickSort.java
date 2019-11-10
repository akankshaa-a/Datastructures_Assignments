package geeksforgeeks;
import java.util.*;

/*
 * Program to implement the Quick Sort Algorithm
 */
public class QuickSort {
	
	//Function to swap the elements at indices i and j
	static void swap(int[] arr, int i, int j)
	{
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	/*
	 * Function that 
	 * puts the first element(pivot) in its correct place
	 * and returns the index of the pivot element
	 */
	static int partition(int[] arr, int low,int high)
	{
		int i,j,pivot = arr[low];
		i = low+1;
		j = high;
		
		while(i<j)
		{
			while(i<=high && arr[i]<pivot)
				i++;	//Increment i till i points to element > pivot
			while(j>=low && arr[j]>pivot)
				j--;	//Increment j till j points to element < pivot
			
			//swapping the 2 elements
			if(i<j)
				swap(arr,i++,j--);
		}

		if(pivot>arr[j])
			swap(arr,low,j);
		
		/*
		 * At this point, all elements 
		 * to the left of j will be smaller than pivot &
		 * to the right of j will be greater than pivot
		 */
		
		return j;	// Returning the Pivot index
	}
	
	//Recursive function to sort the array
	static void quicksort(int[] arr, int low, int high)
	{
		if(low<high)
		{
			int pivot = partition(arr,low,high);
			quicksort(arr,low,pivot-1);
			quicksort(arr,pivot+1,high);
		}
		
	}
	
	public static void main(String[] args){
		Scanner s = new Scanner(System.in);
		
		//Reading the array
		System.out.println("Enter array size");
		int n = s.nextInt();
		int[] arr = new int[n];
		int i;
		System.out.println("Enter array:");
		for(i=0;i<n;i++)
			arr[i] = s.nextInt();
		
		quicksort(arr,0,n-1);
		
		//Sorted array is printed
		for(i=0;i<n;i++)
			System.out.print(arr[i]+" ");
	}

}
