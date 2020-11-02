import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class answer {

    public static List<Integer> dynamicArray(int n, List<List<Integer>> queries) {
        ArrayList<ArrayList<Integer>> seqList = new ArrayList<ArrayList<Integer>>();

        List<Integer> deneme = new ArrayList<>();
        for(int i=0; i<n; i++) {
            seqList.add(new ArrayList<>());
        }
        int lastAnswer = 0;

        for(int i=0; i<queries.size(); i++) {
            int x = queries.get(i).get(1);
            int y = queries.get(i).get(2);
            int xor = x ^ lastAnswer;


            int seq = xor % n;
            System.out.println("seq is"+ seq);
            if(queries.get(i).get(0) == 1) {
                seqList.get(seq).add(y);
            } else {
                int size = seqList.get(seq).size();

                lastAnswer = seqList.get(seq).get(y%size) ;
                deneme.add(lastAnswer);
            }
        }

        return deneme;
    }

    public static void main(String[] args) {
        List<List<Integer>> queries = new ArrayList<>();
        List<Integer> a1 = new ArrayList<>(Arrays.asList(1,0 ,5));
        List<Integer> a2 = new ArrayList<>(Arrays.asList(1,1,7));
        List<Integer> a3 = new ArrayList<>(Arrays.asList(1,0,3));
        List<Integer> a4 = new ArrayList<>(Arrays.asList(2,1,0));
        List<Integer> a5 = new ArrayList<>(Arrays.asList(2,1,1));
        queries.add(a1);
        queries.add(a2);
        queries.add(a3);
        queries.add(a4);
        queries.add(a5);
        System.out.println(dynamicArray(2, queries));



    }
}
