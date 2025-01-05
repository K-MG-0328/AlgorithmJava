package 프로그래머스;

import java.util.Arrays;

public class 제일작은수제거하기 {
    static int[] solution(int[] arr) {
        if(arr.length <= 1) return new int[]{-1};
        int min = Arrays.stream(arr).min().getAsInt();
        return Arrays.stream(arr).filter(i-> i != min).toArray();
    }

    public static void main(String[] args) {
        int[] arr = {10};
        System.out.println(solution(arr));
    }
}
