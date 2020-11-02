public class HackerlandRadioTransmitters {
    static int hackerlandRadioTransmitters(int[] x, int k) {
        for (int i = 1; i < x.length; i++) {
            int tmp = x[i];
            int j;
            for (j = i; j > 0 && x[j - 1] > tmp; j--)
                x[j] = x[j - 1];
            x[j] = tmp;
        }
        int head = 0;
        int count = 0;
        int tran = 0;
        int i=0;
        while(i < x.length) {
            tran = x[i] + k;
            //to find mid
            while(i < x.length && tran >= x[i]) {
                i++;
            }
            count++;

            //to find the head of the tran
            if(i < x.length) {
                head = x[i-1] + k;
                while(i < x.length && x[i] <= head) {
                    i++;
                }
            }
        }
        return count;
    }
}
