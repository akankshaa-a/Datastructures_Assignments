package geeksforgeeks;
import java.util.*;

public class MinStack {
	public static void main(String args[]) throws Exception
	{
		Scanner s = new Scanner(System.in);
		System.out.println("Enter stack size");
		int n = s.nextInt();
		int i;
		Stack mainstack = new Stack();
		Stack minstack = new Stack();
		System.out.println("Enter the Stack elements");
		int min =0,x;
		for(i=0;i<n;i++)
		{
			x = s.nextInt();
			
			mainstack.push(x);
			
			if(i==0)
			{
				min = mainstack.peek();
				minstack.push(min);
				continue;
			}
			
			if(min>x)
			{
				x = min;
				minstack.push(x);
			}
		}
		
		mainstack.printStack();
		minstack.printStack();
		
	}
}
