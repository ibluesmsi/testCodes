package syed.example;

class DoubleLinkNode {
	int data;
	DoubleLinkNode nextNode, prevNode;
	
	public DoubleLinkNode(int val) {
		// TODO Auto-generated constructor stub
		data = val;
		nextNode = prevNode = null;
	}
	
	public DoubleLinkNode getNext() {
		return nextNode;
	}
	
	public DoubleLinkNode getPrev() {
		return prevNode;
	}
	
	public void setNext(DoubleLinkNode next) {
		nextNode = next;
	}
	
	public void setPrev(DoubleLinkNode prev) {
		prevNode = prev;
	}
}

class DoubleLinkListS {
	DoubleLinkNode header;
	
	public DoubleLinkListS() {
		// TODO Auto-generated constructor stub
		header = null;
	}
	
	public void add(int val) {
		DoubleLinkNode currNode, tmpNode;
		if(header == null) {
			header = new DoubleLinkNode(val);
		} else {
			currNode = header;
			while(currNode.getNext() != null) {
				currNode = currNode.getNext();
			}
			tmpNode = new DoubleLinkNode(val);
			tmpNode.setPrev(currNode);
			currNode.setNext(tmpNode);
		}
	}
	
	public void remove(int val) {
		DoubleLinkNode currNode = header;
		
		if(header == null) {
			System.out.print("Empty list \n");
			return;
		}
		
		if(currNode.data == val && currNode.getNext() == null) {
			header = null;
			System.out.println("Removed only node");
			return;
		}
		
		if(currNode.data == val && currNode.getPrev() == null) {
			// First element
			currNode.getNext().setPrev(null);
			header = currNode.getNext();
			currNode.setNext(null);
			currNode = null;
			System.out.println("Removed first node");
			return;
		}
		
		while(currNode.getNext() != null) {
			if(currNode.getNext().data == val) {
				if(currNode.getNext().getNext() == null) {
					// Last Element
					System.out.println("Removed last node");
					currNode.getNext().setPrev(null);
					currNode.setNext(null);
				} else {
					currNode = currNode.getNext();
					currNode.getNext().setPrev(currNode.getPrev());
					currNode.getPrev().setNext(currNode.getNext());
					currNode.setNext(null);
					currNode.setPrev(null);
					currNode = null;
				}
				return;
			}
			currNode = currNode.getNext();
		}
		System.out.println("Node "+val+" not found!");
	}
	
	public void dumpList() {
		DoubleLinkNode currNode = header;
		
		if(header == null) {
			System.out.print("Empty list \n");
			return;
		}
		if(currNode.getNext() == null) {
			System.out.print(" >> : "+currNode.data+ " \n");
			System.out.print(" << "+currNode.data+ " \n");
			return;
		}
			
		while(currNode.getNext() != null) {
			System.out.print(": "+currNode.data+ " -> ");
			currNode = currNode.getNext();
			if(currNode.getNext() == null) {
				System.out.println(": "+currNode.data);
			}
		}
		while(currNode.getPrev() != null) {
			System.out.print(": "+currNode.data+ " <- ");
			currNode = currNode.getPrev();
			if(currNode.getPrev() == null) {
				System.out.println(": "+currNode.data);
			}
		}
		
	}
}

public class SimpleDoubleLinkedList {
	public static void main(String[] args) {
		DoubleLinkListS list = new DoubleLinkListS();
		
		for(int i =1 ; i <= 10 ; i++) {
			list.add(i*2);
			list.dumpList();
		}
		list.remove(16);
		list.dumpList();
		list.remove(0);
		list.remove(2);
		list.dumpList();
		list.remove(20);
		list.dumpList();
		list.remove(10);
		list.dumpList();
		
	}
}
