package geeksforgeeks;
import java.util.*;
import java.lang.*;
import java.io.*;

class Triplets {
	public static void main (String[] args) {
		Scanner s = new Scanner(System.in);
		int testcase = s.nextInt();
		while(testcase--!=0)
		{
		    int n = s.nextInt();
		int[] arr = new int[n];
		Set<Integer> set = new HashSet<Integer>();
		int i,j,count;
		for(i=0;i<n;i++)
		{
			arr[i] = s.nextInt();
			set.add(arr[i]);
		}
		count=0;
		for(i=0;i<n-1;i++)
		{
			for(j=i+1;j<n;j++)
			{
				if(set.contains((arr[i]+arr[j])))
						count++;
			}
			
		}
		
		System.out.println(count!=0?count:-1);
		
	}
	}
}