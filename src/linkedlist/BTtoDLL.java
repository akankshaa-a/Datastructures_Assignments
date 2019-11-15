package linkedlist;

/*
 * Program to demonstrate the BFS 
 * Traversal of a Binary Tree using
 * A queue of Nodes.
 */
public class BTtoDLL {
	
	static TreeNode[] queue = new TreeNode[100];
	static int front = -1,rear = -1;
	
	//Function to check if the Queue is empty:
	static boolean isEmpty()
	{
		return front==-1;
	}
	
	//Function to add element to queue:
	static void enqueue(TreeNode node)
	{
		if(isEmpty())
			front = 0;
		queue[++rear] = node;
	}
	
	//Function to remove element from the queue:
	static TreeNode dequeue() throws Exception
	{
		if(isEmpty())
			throw new Exception("Queue is empty");
		TreeNode del = queue[front];
		if(rear==front)
		{
			rear = front = -1;
		}
		else
			front++;
		return del;
	}
	
	
	//Converting the Binary tree to Doubly Linked list
	static DLLNode toLinkedList(TreeNode root) throws Exception
	{
		if(root==null)
			return null;
		else
		{
			// TreeNode temp is used for the BFS traversal of the tree
			TreeNode temp = root;
			
			//The root node for the DLL is created
			DLLNode DLLRoot = new DLLNode(root.val);
			
			//previous is used to establish the links of the DLL
			DLLNode previous = DLLRoot;
			
			// Step 1: Adding the first node to the queue
			enqueue(temp);
			
			while(!isEmpty())
			{
				//Step 2: Removing the node at the front
				temp = dequeue();
				
				/*
				 * Step 3: Creating a new DLL node with val = Tree node's value
				 * 			and connecting it with the previous node using 'previous' 
				 */
				if(temp.val!=DLLRoot.val) 	//To be done for all the nodes except first node
				{
					DLLNode node = new DLLNode(temp.val);
					
					node.prev = previous;
					previous.next = node;
					
					previous = node;
				}
				
				/*
				 * Step 4: Adding the left and right child
				 * 			of the removed TreeNode to queue 
				 */
				if(temp.left!=null)
					enqueue(temp.left);
				if(temp.right!=null)
					enqueue(temp.right);
				
			}
			
			return DLLRoot;		//Return the root of the Doubly Linked list
		}
			
	}
	
	//Function to print the Doubly Linked List
	static void printList(DLLNode root)
	{
		DLLNode temp = root;
		
		while(temp!=null)
		{
			/* To print the node along with previous and next values:
			 * String prv="",nxt="";
			 * prv += temp.prev!=null?temp.prev.val: "null";
			 * nxt += temp.next!=null?temp.next.val: "null";
			 * System.out.println("Node "+temp.val+" :\t prev = "+prv+"\t next = "+nxt);
			 */
			
			System.out.print(temp.val+" ");
			temp = temp.next;
		}
	}
	
	public static void main(String[] args) throws Exception{
		
		//Creating the Binary tree, level by level
		TreeNode root = new TreeNode(1);
		
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(7);
		
		root.left.right.left = new TreeNode(8);
		
		root.left.right.left.right = new TreeNode(9);
		root.left.right.left.right.left = new TreeNode(10);
		
		//Creating the Doubly Linked List
		DLLNode rootnode = toLinkedList(root);
		
		//Displaying the List
		printList(rootnode);
	
	}

}
