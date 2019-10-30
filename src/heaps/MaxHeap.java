package heaps;

/*
 * Program to implement a Maxheap
 * using an array
 */
public class MaxHeap{
	int[] heap = new int[100];
	int count = -1;
	
	//Function to  get the parent index of a node i
	int getParent(int i)
	{
		if(i>0)
			return (i-1)/2;
		else
			return -1;
	}
	
	//Function to get the index of the left child of node i
	int leftChild(int i)
	{
		return 2*i+1;
	}
	
	//Function to get the index of the right child of node i
	int rightChild(int i)
	{
		return 2*i+2;
	}
	
	//Function to swap two elements of the heap
	void swap(int i, int j)
	{
		int temp = heap[i];
		heap[i] = heap[j];
		heap[j] = temp;
	}
	
	//Function to return index of the minimum element
	int max(int a,int b)
	{
		return heap[a]>heap[b]?a:b;
	}
	
	//Function to ensure the heap property is maintained at node i
	int heapify(int i)
	{
		int left = leftChild(i), right = rightChild(i);
		int maxindex = -1;
		
		//Swim-Down Operation
		if((left<=count)&& !(heap[i]>heap[left] && heap[i]>heap[right]))
		{
			if(right<=count)		//Node i has 2 children
				maxindex = max(left,right);
			else					//Node i has only one child
				maxindex=left;
			
			swap(i,maxindex);
		}
		return maxindex;		
	}
	
	//Function to get the top element of the heap
	int getTop()
	{
		if(count==-1)
			return -1;
		else
			return heap[0];
	}
	
	//Function to insert an element into the heap
	void insert(int e)
	{
		heap[++count] = e;
		int i = count;
		int p  = getParent(i);
		
		//Swim-Up Operation
		while(p>=0)
		{
			if(heap[p]<heap[i])
				swap(i,p);
			i=p;
			p = getParent(i);
		}
	}
	
	//Function to delete and return the top element of the heap
	int deleteTop()
	{
		int e = heap[0];
		swap(0,count--);
		
		int i=0,maxindex=heapify(i);
		while(maxindex<=count && maxindex!=-1)
		{
			i = maxindex;
			maxindex = heapify(i);
		}
		return e;
	}
	
	//Function to print the heap contents
	void printheap()
	{
		int i;
		for(i=0;i<=count;i++)
			System.out.print(heap[i]+" ");
		System.out.println();
	}
	
	//Function to return the no of elements in heap
	int getCount()
	{
		return count+1;
	}
	
	public static void main(String[] args) {
		/*
		MaxHeap heap = new MaxHeap();
		
		int[] a = {5,4,1,7,9,3,6,8};
		int i;
		for(i=0;i<a.length;i++)
		{
			heap.insert(a[i]);
			heap.printheap();
		}
		
		System.out.println("\n Insertion done!");
		
		for(i=0;i<5;i++)
		{
			heap.deleteTop();
			heap.printheap();
		}
		
		System.out.println("\n Deletion done!");
		*/
	}

}
