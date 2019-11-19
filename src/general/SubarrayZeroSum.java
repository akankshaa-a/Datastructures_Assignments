package general;

import java.util.*;

/*
 * Program to find the sub array 
 * with sum equals 0
 */
public class SubarrayZeroSum {

	public static void main(String[] args) {
		int[] arr = {4, 2, 0, 1, 6};
		int n = arr.length;
		
		HashMap<Integer,Integer> map = new HashMap<>();
		
		int start = 0, end = 0, sum = 0;
		boolean flag = false;
		
		while(end<n && start<n)
		{
			sum+= arr[end];
			
			if(sum==0 || map.containsKey(sum))
			{
				flag = true;
				System.out.println(flag+"\nThere is a subarray with zero sum from index "+(map.get(sum)+1)+" to "+end);
				break;
			}
			
			else
				map.put(sum,end++);

		}
		if(!flag)
			System.out.println(flag+"\nThere is no subarray with zero sum.");
	}

}
