package geeksforgeeks;
import java.util.*;

public class Kadane {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int testcase = s.nextInt();
		while(testcase--!=0)
		{
			int n = s.nextInt();
			int[] arr = new int[n];
			int i;
			for(i=0;i<n;i++)
				arr[i] = s.nextInt();
			int maxsofar=0,max=-999999;
			for(i=0;i<n;i++)
			{
				maxsofar+= arr[i];
				if(maxsofar>max)
					max = maxsofar;
				if(maxsofar<0)
					maxsofar=0;
			}
			System.out.println(max);
			
		}
	}

}
