package find_intersection;

public class find_intersection {
	public static void main (String[] args) {
		//Create two LLs
		//a-b-c-d
		//		 \
		//		  e-f-g-null
		//       /
		//	  m-n
		Node root1 = new Node('a');
		Node curr = root1;
		Node intersection = new Node('0');
		
		for (int i = 0; i < 'g' - 'a'; i++) {
			char c = (char)('a' + i + 1);
			Node next = new Node(c);
			if (c == 'e')
				intersection = next;
			curr.next = next;
			curr = curr.next;
		}
		
		//System.out.print(intersection.val);
		
		Node root2 = new Node('m');
		Node next2 = new Node('n');
		root2.next = next2;
		next2.next = intersection;
		
		Node ans = findIns(root1, root2);
		
		if (ans == intersection)
			System.out.println("Found intersection!");
		else
			System.out.println("Not Find");
	}
	
	private static Node findIns(Node root1, Node root2) {
		int len1 = 0, len2 = 0;
		Node curr1 = root1, curr2 = root2;
		
		while (curr1 != null) {
			len1++;
			curr1 = curr1.next;
		}
		
		while (curr2 != null) {
			len2++;
			curr2 = curr2.next;
		}
		
		curr1 = root1;
		curr2 = root2;
		
		if (len1 > len2) {
			for (int i = 0; i < len1 - len2; i++)
				curr1 = curr1.next;
		}
		else if (len2 > len1) {
			for (int i = 0; i < len2 - len1; i++)
				curr2 = curr2.next;
		}
		
		while (curr1 != null && curr2 != null) {
			if (curr1 == curr2) {
				return curr1;
			}
			curr1 = curr1.next;
			curr2 = curr2.next;
		}
		return null;
	}
}
