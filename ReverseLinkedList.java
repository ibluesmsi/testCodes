package syed.example;

public class ReverseLinkedList {

	public static NodeS reverseList(NodeS list) {
		if (list == null)
			return null;
		if (list.next == null)
			return list;
		NodeS reverse = list.next;
		list.next = null;
		NodeS result = reverseList(reverse);
		reverse.next = list;
		return result;
	}

	public static NodeS extractList(NodeS list, NodeS start, NodeS end) {
		NodeS result = new NodeS(start.data);
		result.next = null;
		System.out.println("extractList() start:" + start.data + ", end: "
				+ end.data);

		NodeS tmp = result;
		System.out.print("Creating new list :: " + tmp.data + " -->");
		while (start != end && start != null) {
			start = start.next;
			tmp.next = start;
			tmp = tmp.next;
			System.out.print(tmp.data + " -->");
		}
		tmp = tmp.next;
		tmp.next = null;
		System.out.print(tmp.data + "\n");
		return result;
	}

	public static NodeS reverseSubList2(NodeS list, int k) {
		NodeS start = list, end, tmpEnd, tmp2, result, resultIdx;
		int k2 = k;

		resultIdx = new NodeS(list.data);
		result = resultIdx;

		while (k > 1) {
			list = list.next;
			resultIdx.next = new NodeS(list.data);
			resultIdx = resultIdx.next;
			k--;
		}

		start = list.next;
		System.out.println("Start found :: " + start.data + ", resultIdx: "
				+ resultIdx.data);

		// Find End node
		tmp2 = end = list;
		for (int i = 0; i < k2; i++) {
			tmp2 = tmp2.next;
		}

		while (tmp2 != null && tmp2.next != null) {
			end = end.next;
			tmp2 = tmp2.next;
		}

		// Clone the End node list to tmpEnd
		tmpEnd = end.cloneNode(end.next);

		System.out.println("End found :: " + end.data);
		end.printNodes();

		// Extract and reverse the sublist
		NodeS subList = extractList(list, start, end);
		subList = reverseList(subList);

		System.out.println("reverseList :: " + subList.data);

		// Loop to copy the reversed sublist
		while (subList != null) {
			resultIdx.next = new NodeS(subList.data);
			resultIdx = resultIdx.next;
			System.out.print(" ### " + subList.data);
			System.out.println(", resultIdx: " + resultIdx.data);
			subList = subList.next;
		}
		System.out.println(" ### resultIdx: " + resultIdx.data);

		// Copy end list
		resultIdx.next = tmpEnd.next;

		result.printNodes();
		return result;

	}

	public static void reverseListVoid(NodeS node) {
		NodeS first, rest;

		if (node == null)
			return;
		first = node;
		rest = first.next;

		if(rest == null )
			return;
		System.out.println(">> " + node.data);
		reverseListVoid(rest);

		System.out.println("node << "
				+ node.data
				+ " -> "
				+ ((node.next == null) ? "null" : Integer
						.toString(node.next.data)));
		System.out.print("first << "
				+ ((first == null) ? "null" : Integer.toString(first.data)));
		System.out.println(", rest << "
				+ ((rest == null) ? "null" : Integer.toString(rest.data)));

		if(rest == null) {
			first = node;
		}
		if (rest != null) {
			//node.next = null;
			//NodeS tmp = first;
			//first.next = rest.next;
			//rest.next = first;
			//first.next = tmp;
			//first = rest;
			//rest = tmp;
			// tmp.next = null;
			//node = rest;
		}

		System.out.print("@@first << "
				+ ((first == null) ? "null" : Integer.toString(first.data)));
		System.out.println(", rest << "
				+ ((rest == null) ? "null" : Integer.toString(rest.data)));

		//node = first;
	}

	public static void main(String[] args) {
		LinkedListS list = new LinkedListS();

		// list.addNode(4);
		// list.addNode(5);
		// list.addNode(6);
		for (int i = 0; i < 10; i++)
			list.addNode(i);

		list.printNodes();
		// list.setHead(reverseList(list.getHead()));
		System.out.println("Reversing..");

		reverseListVoid(list.getHead());
		// list.setHead(reverseSubList2(list.getHead(), 3));
		list.printNodes();

	}
}
