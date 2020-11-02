public class DeleteNode {

    static SinglyLinkedListNode deleteNode(SinglyLinkedListNode head, int position) {

        SinglyLinkedListNode current = head;

        for(int i=0; i<position-1; i++) {
        //    current = current.next;
        }
        current.next = current.next.next;
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
