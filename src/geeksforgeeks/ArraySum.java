package geeksforgeeks;
import java .util.*;

public class ArraySum {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int testcases = s.nextInt();
		String op="";
		while(testcases--!=0)
		{	
			int n = s.nextInt();
			int[] arr = new int[n];
			
			int reqsum = s.nextInt();
			
			int i;
			for(i=0;i<n;i++)
				arr[i] = s.nextInt();
			
			int start = 0, end = 0,sum=0;
			boolean found = false;
			while(end<n && start<n)
			{
				while(end<n && sum<reqsum)
				{
					sum+= arr[end++];
				}
				
				if(sum==reqsum)
				{
					found =true;
					op+=""+((start+1)+" "+end+"\n" );
					break;
				}
				
				while(start<n && sum>reqsum)
				{
					sum-= arr[start++];
				}
				
				if(sum==reqsum)
				{
					found =true;
					op+=""+((start+1)+" "+end+"\n" );
					break;
				}
			}
				if(!found)
				{	op+=(-1)+"\n";
					System.out.println(start+ " "+ end);
				}
			
			}
		System.out.print(op);
	}

}
