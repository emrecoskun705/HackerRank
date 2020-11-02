public class PrintTheElementsOfAlinkedList {
    static void printLinkedList(SinglyLinkedListNode head) {

        while(head != null) {
            System.out.println(head.data);
            head = head.next;
        }


    }
    class SinglyLinkedListNode {
          int data;
          SinglyLinkedListNode next;
      };
}
