public class repeated_string {
    public static void main(String[] args) {
        repeatedString("aba", 10);
    }

    public static long repeatedString(String s, long n) {
        // Write your code here
        long firstCount = 0;
        String[] sArr = s.split("");
        for(int i=0; i<sArr.length; i++) {
            if(sArr[i].equals("a")) firstCount++;
        }

        long answer = ((long)(n / sArr.length))*firstCount;

        for(int i=0; i<(n%sArr.length); i++) {
            if(sArr[i].equals("a")) answer++;
        }

        return answer;
    }

}
