package trees;

/*
 * Program to implement a complete Binary tree
 */
public class CompleteBT {
	static Node[] queue = new Node[100];
	static int front = -1,rear = -1;
	
	//Function to check if the Queue is empty:
	static boolean isEmpty()
	{
		return front==-1;
	}
	
	//Function to add element to queue:
	static void enqueue(Node node)
	{
		if(isEmpty())
			front = 0;
		queue[++rear] = node;
	}
	
	//Function to remove element from the queue:
	static Node dequeue() throws Exception
	{
		if(isEmpty())
			throw new Exception("Queue is empty");
		Node del = queue[front];
		if(rear==front)
		{
			rear = front = -1;
		}
		else
			front++;
		return del;
	}
	
	//Function to show the element at the front of the queue:
	static Node peek()
	{
		if(isEmpty())
			return null;
		else
			return queue[front];		
	}
	
	//Function to insert a node into the CBT:
	static Node insert(int x,Node root) throws Exception
	{
		Node newNode = new Node(x);
		
		if(root==null)
		{
			root = newNode;
		}
		else
		{
			Node p = peek();
			if(p.left ==null && p.right==null)
				p.left = newNode;
			else if(p.right==null)
			{
				p.right = newNode;
				dequeue();
			}
		}
		
		enqueue(newNode);
		return root;
	}
	
	//In-order traversal of the node:
	static void inorder(Node node)
	{
		if(node==null)
			return;
		inorder(node.left);
		System.out.print(node.data+" ");
		inorder(node.right);
	}
	
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		Node root = null;
		for(int i=1;i<=10;i++)
			root = insert(i,root);
		inorder(root);
	}

}
