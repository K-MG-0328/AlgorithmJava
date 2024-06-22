package 나의풀이;

import java.lang.reflect.Array;
import java.util.Arrays;

public class 자연수뒤집어배열로만들기 {
    static int[] solution(long n) {
        String s = Long.toString(n);
        StringBuilder sb = new StringBuilder(s);
        sb = sb.reverse();
        int cnt = 0;
        int[] result = new int[s.length()];
        for(char c : sb.toString().toCharArray()) {
            result[cnt++] = Character.getNumericValue(c);
        }
        return result;
    }

    public static void main(String[] args) {
        long n = 12345;
        System.out.println(solution(n));
    }
}
