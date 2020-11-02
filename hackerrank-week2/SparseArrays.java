import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class SparseArrays {
    // my answer
    static int[] matchingStrings(String[] strings, String[] queries) {
        ArrayList<Integer> a = new ArrayList<>();
        for(int i=0; i<queries.length; i++) {
            int total = 0;
            for(int j=0; j<strings.length; j++) {
                if(queries[i].equals(strings[j])) {
                    total++;
                }
            }
            a.add(total);
        }
        int[] answer = new int[a.size()];
        for(int i=0; i<a.size(); i++) {
            answer[i] = a.get(i);
        }
        return answer;
    }
    // my second answer
    static int[] matchingStrings2(String[] strings, String[] queries) {
        Map<String, Integer> answerMap = new HashMap<>();
        for(int i=0; i<strings.length; i++) {
            String string = strings[i];
            if(!answerMap.containsKey(string)) {
                answerMap.put(string, 1);
            } else {
                answerMap.put(string, answerMap.get(string)+1);
            }
        }
        int[] answer = new int[queries.length];
        for(int i=0; i<queries.length; i++) {
            answer[i] = answerMap.getOrDefault(queries[i], 0);
        }
        return answer;
    }

}
