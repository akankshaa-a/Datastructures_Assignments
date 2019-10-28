package general;
import java.util.Scanner;

/*
 * Program to print the elements of a 2D array in a spiral manner
 */
public class Spiral {

	public static void main(String[] args) {
		Scanner s= new Scanner(System.in);
		
		int i,j,left,right,top,bottom,count=0;

		System.out.println("Enter m and n"); //m rows, n columns
		int m = s.nextInt();
		int n = s.nextInt();
		int arr[][]=new int[m][n];
		
		//Reading the array elements
		System.out.println("Enter the array elements");
		for(i=0;i<m;i++)
		{
			for(j=0;j<n;j++)
				arr[i][j]=s.nextInt();
		}
		
		//Initializing the starting pointers for top,bottom,left,right:
		
		top=0;		//Points to the topmost row
		bottom=m-1;	//Points to bottom-most row
		left=0;		//Points to the leftmost column
		right=n-1;	//Points to the rightmost column
		
		
		while(count<(m*n))		//Count is incremented after each element is printed
		{
			/*
			 * Printing all elements of Topmost row from Left to Right
			 */
			for(i=left;i<=right;i++)
			{
				System.out.print(arr[top][i]+" ");
				count++;
			}
			top++;	//Moving top pointer down by 1 row
			
			
			/*
			 * Printing all elements of Rightmost column from Top to Bottom
			 */
			for(i=top;i<=bottom;i++)
			{
				System.out.print(arr[i][right]+" ");
				count++;
			}
			right--;	//Moving Right pointer to left by 1 column
			
			
			/*
			 * Printing all elements of Bottom-most row from Right to Left
			 */
			for(i=right;i>=left;i--)
			{
				System.out.print(arr[bottom][i]+" ");
				count++;
			}
			bottom--;	//Moving Bottom pointer upward by 1 row
			
			
			/*
			 * Printing all elements of Left-most column from Bottom to Top
			 */
			for(i=bottom;i>=top;i--)
			{
				System.out.print(arr[i][left]+" ");
				count++;
			}
			left++;	//Moving Left pointer to the right by 1 column
			
		}
				
	}

}

