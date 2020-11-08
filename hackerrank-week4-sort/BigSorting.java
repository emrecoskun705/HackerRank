import java.io.*;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;
import java.util.Scanner;

public class BigSorting {
    // Complete the bigSorting function below.
    static String[] bigSorting(String[] unsorted) {

        Arrays.sort(unsorted, new Comparator<String>() {
            @Override
            public int compare(String x, String y) {
                if (x.length() == y.length()) {
                    return x.compareTo(y);
                }

                return x.length() - y.length();
            }
        });

        return unsorted;
    }

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(reader.readLine());

        String[] unsorted = new String[n];

        for (int i = 0; i < n; i++) {
            String unsortedItem = reader.readLine();
            unsorted[i] = unsortedItem;
        }

        String[] result = bigSorting(unsorted);

        for (int i = 0; i < result.length; i++) {
            bufferedWriter.write(result[i]);

            if (i != result.length - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();

        reader.close();
    }}

class MyComparator implements Comparator<String> {

    public int compare(String x, String y) {
        if (x.length() == y.length()) {
            return x.compareTo(y);
        }

        return x.length() - y.length();
    }
}

