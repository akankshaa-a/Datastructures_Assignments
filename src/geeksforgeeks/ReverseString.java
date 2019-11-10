package geeksforgeeks;
import java.util.*;

public class ReverseString {

	static void reverse(char[] arr, int first, int last)
	{
			//System.out.println("Reversing");
		char temp;
		while(first<last)
		{
			temp = arr[first];
			arr[first] = arr[last];
			arr[last] = temp;
			first++;
			last--;
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		String a1 = s.nextLine();
		char[] a = a1.toCharArray();
		reverse(a,0,a.length-1);
		int start =0, end = 0;
		int n = a.length;
		while(end<n)
		{
			while(end<=n-1 && a[end]!=' ')
				end++;
				//System.out.println(start+" "+end);
			reverse(a,start,end-1);
			end++;
			start=end;
			
		}
		System.out.println(a);
	}

}
