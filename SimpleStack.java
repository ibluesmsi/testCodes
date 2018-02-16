package syed.example;

public class SimpleStack {
	class NodeS {
		int data;
		NodeS next;

		public NodeS() {
			this.data = 0;
			this.next = null;
		}

		public NodeS(int t) {
			this.data = t;
			this.next = null;
		}

	}

	NodeS top;
	int capacity, size;

	public SimpleStack(int size) {
		this.capacity = size;
		this.size = 0;
		this.top = null;
	}

	public void push(int data) {
		if(this.size == this.capacity) {
			System.out.println("Error! No spce in queue..");
			return;
		}
		System.out.println("Pushing data: "+data);
		NodeS newNode = new NodeS(data);
		if (size == 0) {
			top = newNode;
		} else {
			newNode.next = top;
			top = newNode;
		}
		size++;
	}

	public int pop() {
		int tmp = -1;
		if (size > 0 && top != null) {
			tmp = this.top.data;
			this.top = this.top.next;
			// How to free NodeS?
			size--;
			if(size == 0) {
				this.top = null;
			}
		}
		return tmp;
	}

	public int peek() {
		int tmp = -1;
		if (size > 0 && top != null) {
			return this.top.data;
		}
		return tmp;
	}

	public int size() {
		return this.size;
	}

	public int actualSize() {
		NodeS head = top;
		if (head == null)
			return 0;
		int actualS = 0;
		while (head.next != null) {
			actualS++;
			head = head.next;
		}
		return actualS+1;
	}

	public static void main(String[] args) {
		SimpleStack ss = new SimpleStack(20);
		for (int i = 0; i < 20; i++) {
			ss.push((int) (Math.random()*40 - 1));
		}

		System.out.println("Size >> " + ss.actualSize()+", Top >> "+ss.peek());

		for (int i = 0; i < 10; i++)
			System.out.println(">> " + ss.pop());
		System.out.println("Size >> " + ss.actualSize()+", Top >> "+ss.peek());
		
		for (int i = 0; i < 20; i++) {
			ss.push((int) (Math.random()*40 - 1));
		}

		System.out.println("Size >> " + ss.actualSize()+", Top >> "+ss.peek());

		for (int i = 0; i < 20; i++)
			System.out.println(">> " + ss.pop());
		System.out.println("Size >> " + ss.actualSize()+", Top >> "+ss.peek());
	}

	
}
