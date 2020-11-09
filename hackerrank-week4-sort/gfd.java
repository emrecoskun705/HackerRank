import java.io.*;
import java.util.*;
import java.util.stream.IntStream;

public class gfd {

    //3,4,5

    public static void main(String[] args) {
        linkedList list1 = new linkedList(3);
        linkedList list2 = new linkedList(4);
        linkedList list3 = new linkedList(5);
        list2.next = list3;
        list1.next = list2;
        System.out.println(list1.a);
        System.out.println(list1.next.a);
        System.out.println(list1.next.next.a);
    }


}

class linkedList {
    int a;
    linkedList next;

    public linkedList(int a) {
        this.a = a;
    }
}
