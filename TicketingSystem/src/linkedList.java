import java.util.LinkedList;


     class Node{
        Node next;
        int val;
        Node(){
            next = null;
        }
        Node(int x){
            val = x;
            next = null;
        }
    }

     class LList{
        static Node head = null;

         void insertAtBeginning(int x){
            Node temp = new Node(x);
            temp.next = head;
            head = temp;
        }

         void insertAtEnd(int x){
            Node temp = new Node(x);
            Node y = head;
            while(y.next !=null){
                y = y.next;
            }
            y.next = temp;
        }

         void insertAtIndex(int val , int index){
            Node temp = new Node(val);
            Node q = head;
            for(int i=1;i<index;i++){
                temp.next = q.next;
                q.next = temp;
            }
        }

         void display(){
            Node q = head;
            while(q!=null){
                System.out.print(q.val + "-->");
                q=q.next;
            }
            System.out.println("null");
        }

         void deleteByValue(int val){
            Node p = null;
            Node q = head;
            while(q!=null){
                if(q.val == val){
                    p.next = q.next;
                    q.next = null;
                    System.out.println("Value found and deleted");
                    return;
                }
                p = q;
                q = q.next;
            }

            System.out.println("Value not found");

        }

         void deleteByIndex(int pos){
            Node p = head;
            for(int i=1;i<pos;i++){
                if(pos!=2)
                 p = p.next;
            }
             Node q = p.next;
             p.next = q.next;
             q.next = null;
             System.out.println("Value at index "+ pos+" deleted");
        }
    }
public class linkedList {
    public static void main(){
        LList ll = new LList();
        System.out.println("Add 10 to beggining");

        ll.insertAtBeginning(10);
        ll.display();
        System.out.println("Add 20 to end");

        ll.insertAtEnd(20);
        ll.display();
        System.out.println("Add 30 to end");

        ll.insertAtEnd(30);
        ll.display();
        System.out.println("Add 50 to 2nd index");

        ll.insertAtIndex(50,2);
        ll.display();

        System.out.println("Delete element at 2nd index");

        ll.deleteByIndex(2);
        ll.display();
        System.out.println("Delete element 30 in linkedlist");

        ll.deleteByValue(30);
        ll.display();
    }

}
