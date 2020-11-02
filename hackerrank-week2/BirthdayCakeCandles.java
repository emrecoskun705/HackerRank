import java.util.List;

public class BirthdayCakeCandles {
    public static int birthdayCakeCandles1(List<Integer> candles) {
        int count = 0;
        int biggest = 0;
        for(int candle : candles) {
            if(candle > biggest){
                biggest = candle;
                count = 1;
            } else if (candle == biggest) {
                count++;
            }
        }
        return count;
    }

}

