package general;

import java.util.Scanner;
public class FindDuplicates {
	
	
	//merge sort function to sort the array
	static void merge(int arr[], int l, int m, int r) 
    { 
        // Find sizes of two subarrays to be merged 
        int n1 = m - l + 1; 
        int n2 = r - m; 

        int L[] = new int [n1];
        int R[] = new int [n2]; 
  
        //Copy data to temp arrays L and R
        for (int i=0; i<n1; ++i) 
            L[i] = arr[l + i]; 
        for (int j=0; j<n2; ++j) 
            R[j] = arr[m + 1+ j]; 
  
  
        // Merge the temp arrays 
  
        int i = 0, j = 0; 
        int k = l;
        
        while (i < n1 && j < n2) 
        { 
            if (L[i] <= R[j]) 
            { 
                arr[k] = L[i]; 
                i++; 
            } 
            else
            { 
                arr[k] = R[j]; 
                j++; 
            } 
            k++; 
        } 
  
        // Copy remaining elements of L[] , if any 
        while (i < n1) 
        { 
            arr[k] = L[i]; 
            i++; 
            k++; 
        } 
  
        // Copy remaining elements of R[], if any 
        while (j < n2) 
        { 
            arr[k] = R[j]; 
            j++; 
            k++; 
        } 
    } 
  
    // Main function that sorts arr[l..r]
    static void sort(int arr[], int l, int r) 
    { 
        if (l < r) 
        { 
            // Find the middle point 
            int m = (l+r)/2; 
  
            // Sort first and second halves 
            sort(arr, l, m); 
            sort(arr , m+1, r); 
  
            // Merge the sorted halves 
            merge(arr, l, m, r); 
        } 
    } 

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter array size:");
		int n = s.nextInt();
		
		int i;
		int arr[]= new int[n];
		
		System.out.println("Enter array elements:");
		
		for(i=0;i<n;i++)
			arr[i]=s.nextInt();
		
		//Merge sort applied to array
		sort(arr,0,n-1);
		
		
		//Finding duplicates in the sorted array:
		//(All repeated elements will be adjacent to each other)
		i=0;
		while(i<n-1)
		{
			
			if(arr[i]!=arr[i+1]) // if element is not the same as following, increment i
				i++;
			if(i<n-1 && arr[i]==arr[i+1]) //if element is same as next element, print it
				System.out.print(arr[i]+" ");
			while(i<n-1 && arr[i]==arr[i+1]) //till 2 adjacent elements are not equal, increment i
				i++;
			
		}
		
	}

}
