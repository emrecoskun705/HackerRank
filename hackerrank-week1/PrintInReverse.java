import java.util.ArrayList;

public class PrintInReverse {
    // Complete the reversePrint function below.



     class SinglyLinkedListNode {
          int data;
         SinglyLinkedListNode next;
      }

    static void reversePrint(SinglyLinkedListNode head) {
        ArrayList<Integer> a = new ArrayList<>();
        while(head != null) {
            a.add(head.data);
            head = head.next;
        }

        for(int i=a.size()-1; i>=0 ; i--) {
            System.out.println(a.get(i));
        }
    }

}
