public class InsertNodeAtSpecificPositionInLinkedList {

// if you use in hackerran delete the // signs
    static SinglyLinkedListNode insertNodeAtPosition(SinglyLinkedListNode head, int data, int position) {
        SinglyLinkedListNode insert = new SinglyLinkedListNode(data);
        SinglyLinkedListNode current = head;

        for(int i=0; i<position-1; i++) {
        //    current = current.next;
        }
        insert.next = current.next;
      //  current.next = insert;
        return head;
    }


    static class SinglyLinkedListNode {
        int data;
        InsertNodeAtTheTailOfLinkedList.SinglyLinkedListNode next;

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
