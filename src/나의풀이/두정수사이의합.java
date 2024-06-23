package 나의풀이;

import java.util.stream.LongStream;

/*
* 아쉬운점  return ((max-min+1) * (max+min)) / 2;
* 등차수열의 합공식을 이용하지 못한게 아쉬운 점이다.
* LongStream.range를 사용하면 반복을 하게되는데 합공식을 사용하면 한번만 사용하게 되므로 등차수열을 사용한 방법이 답이라고 할 수 있다.
* (max-min+1) 항의 개수
* (max-min+1) * (max+min) / 2 평균값
* return ((max-min+1) * (max+min)) / 2
* */
public class 두정수사이의합 {
    static long solution(int a, int b) {
        int min = Math.min(a, b);
        int max = Math.max(a, b);
        return LongStream.range(min,max+1).sum();
    }

    public static void main(String[] args) {
        int a = 5, b = 3;
        System.out.println(solution(a, b));
    }
}
