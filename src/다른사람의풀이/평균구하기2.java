package 다른사람의풀이;

import java.util.Arrays;

public class 평균구하기2 {
    public double solution(int[] arr) {
        return Arrays.stream(arr).average().getAsDouble();
    }
}
