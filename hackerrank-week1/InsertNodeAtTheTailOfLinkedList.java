public class InsertNodeAtTheTailOfLinkedList {

    public static void main(String[] args) {
        SinglyLinkedListNode node = new SinglyLinkedListNode(3);
        node.next =  new SinglyLinkedListNode(2);
        System.out.println(insertNodeAtTail(node, 4));
    }


    static SinglyLinkedListNode insertNodeAtTail(SinglyLinkedListNode head, int data) {
        SinglyLinkedListNode tail = new SinglyLinkedListNode(data);
        if(head == null) {
            return tail;
        }

        SinglyLinkedListNode currentData = head;
        while(currentData.next != null) {
            currentData = currentData.next;
        }
        currentData.next = tail;

        return head;

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
