package general;

/*
 * Program to find the sub-array with the largest sum
 * using the Kadane's algorithm
 */
public class LargestSumSubaray {

	public static void main(String[] args) {
		
		//Initializing the array
		int[] arr = {-2, -3, 4, -1, -2, 1, 5, -3};
		int n = arr.length,i;
		
		int maxsofar=0,max=-999999;
		
		for(i=0;i<n;i++)
		{
			maxsofar+=arr[i];
			
			//Updating the max value
			if(maxsofar>max)
				max = maxsofar;
			
			//In case the sum becomes negative
			if(maxsofar<0)
				maxsofar = 0;
		}
		
		System.out.println("Max sum: "+max);
	}

}
