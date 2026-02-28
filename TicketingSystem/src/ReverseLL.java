import javax.swing.tree.TreeNode;
import java.util.LinkedHashMap;
import java.util.LinkedList;



public class ReverseLL {
    static class Node {
        int data;
        Node next;

        Node(int d) {
            this.data = d;
            this.next = null;
        }
        Node(){
            this.next = null;
        }
    }

    public static class LinkedList {
        Node head;

        public void add(int data) {
            Node newNode = new Node(data);
            if (head == null) {
                head = newNode;
                return;
            }
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }

        public void display() {
            Node n = head;
            while (n != null) {
                System.out.print(n.data + " -> ");
                n = n.next;
            }
            System.out.println("null");
        }

        public Node reverse() {
            if (head == null || head.next == null) return head;

            Node prev = null;
            Node current = head;
            Node next = null;

            while (current != null) {
                next = current.next;
                current.next = prev;
                prev = current;
                current = next;
            }

            head = prev; // Update the list's head to the new front
            return head;
        }


    }

    static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.add(10);
        ll.add(20);
        ll.add(30);
        ll.add(40);
        LinkedList ll2 = new LinkedList();
        ll2.head = ll.reverse();
        ll2.display();

    }


}
