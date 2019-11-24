
 class Node {
	private  int val;
	private  Node next;
	private Node pre;
	private int size;

	Node(int val)
	{
		this.val=val;
	}
	Node head=null;
	Node last=null;
	public void pushFront(int val)
	{
		Node node=new Node(val);
		node.next=head;
		if(head==null)
		{
			head=last=node;
		}else{
			head.pre=node;
		}
		head=node;
		size++;

	}
	public void popFront()
	{
		if(size<=0)
		{
			System.out.println("无法删除空链表");
			return;
		}
		head=head.next;
		if(head==null)
		{
			head=last=null;
		}else{
			head.pre=null;
		}
		size--;

	}
	void pushBack(int val)
	{
		Node node=new Node(val);
		if(last==null)
		{
			head=last=node;
		}else{
			last.next=node;
			node.pre=last;
		}
		last=node;
		size++;
	}
	void popBack(){
		if(size<=0)
		{
			System.out.println("无法删除空链表");
			return;
		}
		if(head.next==null)
		{
			head=last=null;
		}else{
			last.pre.next=null;
			last=last.pre;
		}

		
		size--;
	}
	private Node getNode(int index){
		int back=size-index-1;
		Node pos;
		if(index<=back){
			pos=head;
			for(int i=0;i<index;i++)
			{
				pos=pos.next;
			}
		}else{
			pos=last;
			for(int i=0;i<back;i++)
			{
				pos=pos.pre;
			}
		}
		return pos;
	}
	
	public void add(int index,int val)
	{
		if(index<0||index>size)
		{
			System.out.println("下标错误");
		}
		if(index==0)
		{
			pushFront(val);
		}else if(index==size)
		{
			pushBack(val);
		}else
		{
			Node pos=getNode(index);
			Node node= new Node(val);
			node.next=pos;
			node.pre=pos.pre;
			node.next.pre=node;
			node.pre.next=node;
				
//			Node pos=getNode(index);
//			Node node=new Node(val);
//		   node.next=pos;
//		   node.pre=pos.pre;
//		   node.pre.next=node;
//		   node.next.pre=node;
//		    
			size++;
			
		}
		
		
	}
	public void delete(int index,int xize)
	{
		if(size<=0)
		{
			System.out.println("无法删除空链表");
			return;
		}
		if(index<0||index>size)
		{
			System.out.println("下标错误");
		}
		if(index==0)
		{
			popFront();
		}else if(index==size)
		{
			popBack();
		}else{
			Node pos=getNode(index);
			pos.pre.next=pos.next;
			pos.next.pre=pos.pre;
			size--;
		}
		
	}
}
 
