public class GetNodeValue {

    //my solution
    static int getNode(SinglyLinkedListNode head, int positionFromTail) {
        SinglyLinkedListNode current = head;
        SinglyLinkedListNode before = null;

        while(current != null) {
            SinglyLinkedListNode next = current.next;
            current.next = before;
            before = current;
            current = next;
        }
        SinglyLinkedListNode currentForReversed = before;
        int i=0;
        while(currentForReversed != null) {
            if(i == positionFromTail) {
                return currentForReversed.data;
            }
            currentForReversed = currentForReversed.next;
            i++;
        }

        return 0;
    }

    // best solution

    static int getNode2(SinglyLinkedListNode head, int positionFromTail) {
        SinglyLinkedListNode pointer = head;

        int count = 0;
        while(head != null) {
            head = head.next;
            if (count < positionFromTail) {
                count++;
            } else {
                pointer = pointer.next;
            }

        }


        return pointer.data;
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
