package geeksforgeeks;
import java.util.*;
import java.io.*;

public class MergeArrays {

	/**
	 * @param args
	 */
	
	static void swapSame(int i, int j, int[] arr)
	{
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	static void add(int x)
	{
		
	}

	static void sort(int[] arr1, int[] arr2, int p1, int p2)
	{
		int x = arr1.length, y = arr2.length;
		while(p1<x && p2<y)
		{
			if(arr1[p1]<arr2[p2])
			{
				sort(arr1,arr2,p1++,p2);
				add(arr1[p1]);
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int x,y,i,j;
		String s[] = br.readLine().split(" ");
		x = Integer.parseInt(s[0]);
		y = Integer.parseInt(s[1]);
		
		int[] arr1 = new int[x];
		String xarray[] = br.readLine().split(" ");
		for(i=0;i<x;i++)
			arr1[i] = Integer.parseInt(xarray[i]);
		
		int[] arr2 = new int[y];
		String yarray[] = br.readLine().split(" ");
		for(j=0;j<y;j++)
			arr2[j] = Integer.parseInt(yarray[j]);
		
		sort(arr1,arr2,0,0);
	}

}
