public class counting_valleys {
    public static void main(String[] args) {

    }

    public static int countingValleys(int steps, String path) {
        // Write your code here
        int location = 0;
        int count = 0;
        String[] ls = path.split("");
        for(int i=0; i<steps; i++) {
            String upOrdDown = ls[i];
            if(ls[i].equals("U")) {
                if(location < 0 && location + 1 == 0) {
                    count++;
                }
                location++;
            }
            if(ls[i].equals("D")) location--;

        }

        return count;
    }

}
