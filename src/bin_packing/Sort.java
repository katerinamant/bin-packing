package bin_packing;

public class Sort {
	public static MyLinkedList<Integer> sort(MyLinkedList<Integer> ll) {
		// Implementation of decreasing MergeSort
		if (ll.isEmpty() | ll.size() == 1) {
			return ll;
		}

		// Split list in half
		int middle = ll.size()/2 - 1;
		LinkedListNode<Integer> curr = ll.headNode();
		for(int i=0; i<middle; i++) {
			curr = curr.next();
		}
		LinkedListNode<Integer> middleNode = curr.next();
		curr.setNext(null);
		MyLinkedList<Integer> left = new MyLinkedList<Integer>(ll.headNode());
		MyLinkedList<Integer> right = new MyLinkedList<Integer>(middleNode);

		// Sort Both
		left = sort(left);
		right = sort(right);

		// Merge Them
		return merge(left, right);
	}

	public static MyLinkedList<Integer> merge(MyLinkedList<Integer> a, MyLinkedList<Integer> b) {
		MyLinkedList<Integer> c = new MyLinkedList<Integer>();

		while (!a.isEmpty() && !b.isEmpty()) {
			int val = (a.head() < b.head()) ? b.popFront() : a.popFront();
			c.pushBack(val);
		}

		// Here either A or B is empty
		while (!a.isEmpty()) {
			c.pushBack(a.popFront());
		}

		while (!b.isEmpty()) {
			c.pushBack(b.popFront());
		}

		return c;
	}
}
