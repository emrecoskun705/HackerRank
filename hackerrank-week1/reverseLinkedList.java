import java.util.ArrayList;
import java.util.Collections;

public class reverseLinkedList {


    //solution 1
    static SinglyLinkedListNode reverse(SinglyLinkedListNode head) {
        ArrayList<Integer> list = new ArrayList<>();
        while(head != null) {
            list.add(head.data);
            head = head.next;
        }
        Collections.reverse(list);
        SinglyLinkedListNode answer = new SinglyLinkedListNode(list.get(0));
        SinglyLinkedListNode current = answer;
        for(int i=1; i<list.size(); i++) {
            current.next = new SinglyLinkedListNode(list.get(i));
            current = current.next;
        }
        return answer;
    }

    // solution 2 which is better solution

    static SinglyLinkedListNode reverse2(SinglyLinkedListNode head) {
       if(head == null) {
           return  null;
       }

       SinglyLinkedListNode before = null;
       SinglyLinkedListNode current = head;

       while (current != null) {
           SinglyLinkedListNode next = current.next;
           current.next = before;
           before = current;
           current = next;
       }
       return before;
    }

    static class SinglyLinkedListNode {
        int data;
        SinglyLinkedListNode next;

        public SinglyLinkedListNode(int data) {
            this.data = data;
        }

        @Override
        public String toString() {
            return
                    ""+ data
                    ;
        }
    }
}
