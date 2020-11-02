public class CompareTwoLinkedLists {
    // my answer
    static boolean compareLists(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {
        try {
            while(head1 != null) {
                if(head1.data != head2.data) {
                    return false;
                }
                head1 = head1.next;
                head2 = head2.next;
            }
        } catch (Exception e) {
            return false;
        }
        return true;

    }
    // the other answer
    static boolean compareLists2(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {
        SinglyLinkedListNode first = head1;
        SinglyLinkedListNode second = head2;

        while (first != null && second != null) {
            if(first.data != second.data) {
                break;
            }
            if(first.next == null && second.next == null) {
                return true;
            }
            first = first.next;
            second = second.next;
        }

        return  false;
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
