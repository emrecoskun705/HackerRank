import java.util.Arrays;
import java.util.Scanner;

public class FraudulentActivityNotifications {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] expenditure = new int[scanner.nextInt()];
        int d = scanner.nextInt();
        for(int i=0; i<expenditure.length; i++) {
            expenditure[i] = scanner.nextInt();
        }


        System.out.println(activityNotifications(expenditure, d));
    }
    static int activityNotifications(int[] expenditure, int d) {
        //we are using counting sort here
        //but just for median array
        //and maximum number is 200
        //we will ad +1 for each number
        //then we will find the median then check the condition finally we will change the median array(shift 1 index)
        int[] medArr = new int[201];
        for(int i=0; i<d; i++) {
            medArr[expenditure[i]]++;
        }
//        System.out.println(Arrays.toString(medArr));
        int notifications = 0;
        int j = 0;
        for(int i=d; i<expenditure.length; i++) {
//            System.out.println("i :" + i);
            double med = calculateMedian(medArr, d);
            changeInitialMed(medArr, expenditure, i, j);
            j++;
//            System.out.println("med:" + med);
//            System.out.println("medArr: " + Arrays.toString(medArr));
            if(expenditure[i] >= med * 2) {
                notifications++;
            }


        }

        return notifications;
    }

    static double calculateMedian(int[] medArr, int d) {
        double median = 0;
        if (d % 2 == 0) {
            Integer m1 = null;
            Integer m2 = null;
            int count = 0;
            for (int j = 0; j < medArr.length; j++) {
                count += medArr[j];
                if (m1 == null && count > d/2) {
                    m1 = j;
                }
                if (m2 == null && count > d/2 + 1) {
                    m2 = j;
                    break;
                }
            }
            median = (m1 + m2) / 2.0;
        } else {
            int count = 0;
            for (int j = 0; j < medArr.length; j++) {
                count += medArr[j];
                if (count > d/2) {
                    median = j;
                    break;
                }
            }
        }
        return median;
    }

    static void changeInitialMed(int[] medArr, int[] expenditure, int c, int j) {
        int addValue = expenditure[c];
        int removeValue = expenditure[j];
        medArr[removeValue]--;
        medArr[addValue]++;
    }

}
