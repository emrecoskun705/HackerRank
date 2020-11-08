import java.util.*;

public class ShortPalindrome {
    static int mod = 1000*1000*1000 + 7;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine();
        char[] sArr = s.toCharArray();

        int[] arr1 = new int[26];
        int[][] arr2 = new int[26][26];
        int[] arr3 = new int[26];

        int total = 0;
        for(int i=0; i<sArr.length; i++) {
            int idx = (int)(sArr[i] - 'a');
            total += arr3[idx];
            total = total % mod;

            for(int j=0; j<26; j++) {
                arr3[j] += arr2[j][idx];
                arr3[j] = arr3[j] % mod;
            }

            for(int j=0; j<26; j++) {
                arr2[j][idx] += arr1[j];
                arr2[j][idx] = arr2[j][idx] % mod;
            }

            arr1[idx]++;
            arr1[idx] = arr1[idx] % mod;
        }

        System.out.println(total);
    }
}
