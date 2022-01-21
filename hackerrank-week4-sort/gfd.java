
import java.io.*;
import java.util.*;
import java.util.stream.IntStream;



class gfd{
    public static void main(String[] args) {

        Integer s = new Integer(24);
        Integer p = new Integer(21);
        Integer k = new Integer(10);


        ListCel head =  new ListCel(s,
                            new ListCel(p,
                                    new ListCel(k, null)));
        ListCel tail = head;
        while (tail.getNext() != null) {
            System.out.println(tail.getDatum());
            tail = tail.getNext();
        }
        System.out.println(tail.getDatum());
//        System.out.println(head.getDatum());
    }

    static class ListCel{
        private Integer i;
        private ListCel next;

        public ListCel(Integer i, ListCel next) {
            this.i = i;
            this.next = next;
        }

        public Integer getDatum() {
            return i;
        }

        public ListCel getNext() {
            return next;
        }

        public void setDatum(Integer i) {
            this.i = i;
        }

        public void setNext(ListCel next) {
            this.next = next;
        }
    }

}




