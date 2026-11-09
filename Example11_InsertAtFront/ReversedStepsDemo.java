public class ReversedStepsDemo {
    static void print(String label, Node<String> head) {
        System.out.print(label);
        Node<String> cur = head;
        for (int i = 0; i < 5 && cur != null; i++) {   // max 5 nodes
            System.out.print(cur.getElement() + " -> ");
            cur = cur.getNext();
        }
        System.out.println(cur == null ? "null" : "...");
    }

    public static void main(String[] args) {
        // Correct order
        Node<String> head = new Node<>("B");
        Node<String> newNode = new Node<>("A");
        newNode.setNext(head);   // 1. link
        head = newNode;          // 2. move head
        print("Correct: ", head);

        // Swapped order
        head = new Node<>("B");
        newNode = new Node<>("A");
        head = newNode;          // 2. move head (B is now unreachable!)
        newNode.setNext(head);   // 1. link (A points to itself)
        print("Swapped: ", head);
    }
}
