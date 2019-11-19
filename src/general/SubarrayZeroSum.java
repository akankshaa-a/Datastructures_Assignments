package general;

import java.util.*;

/*
 * Program to find the sub array 
 * with sum equals 0
 */
public class SubarrayZeroSum {

	public static void main(String[] args) {
		
		//Initializing the array
		int[] arr = {4, 2, 0, 1, 6};
		int n = arr.length;
		
		HashMap<Integer,Integer> map = new HashMap<>();
		
		int end = 0, sum = 0;
		boolean flag = false;
		
		while(end<n )
		{
			sum+= arr[end];		//Keep adding the current number to the Cumulative sum
			
			if(sum==0 || map.containsKey(sum))	//if the first number is 0, or if the sum is repeated:
			{
				flag = true;
				
				if(sum==0)
					System.out.println(flag+"\nThere is a subarray with zero sum from index "+end+" to "+end);
				else
					System.out.println(flag+"\nThere is a subarray with zero sum from index "+(map.get(sum)+1)+" to "+end);
				break;
			}
			
			else
				map.put(sum,end++);		//If the sum is Unique, we add the sum and index to the HashMap

		}
		
		if(!flag)	//Sub-array not found.
			System.out.println(flag+"\nThere is no subarray with zero sum.");
	}

}
