package 나의풀이;

import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class x만큼간격이있는n개의숫자 {
    static long[] solution(int x, int n) {
        //range를 사용하면 해당 0 ~ N 까지의 스트림을 생성한다.
        long[] result = IntStream.range(0,n).mapToLong(i->x*(i+1)).toArray();
        long[] result2 = LongStream.range(0, n).map(i -> x * (i + 1)).toArray();
        return result2;
    }

    public static void main(String[] args) {
        int x = 2 , n = 5;
        System.out.println(solution(x, n));
    }
}
