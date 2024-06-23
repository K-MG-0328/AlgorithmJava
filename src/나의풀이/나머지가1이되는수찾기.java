package 나의풀이;

import java.util.stream.IntStream;

public class 나머지가1이되는수찾기 {
    static int solution(int n) {
        //n%i == i가 성립할 수 있는 이유는 n과 i가 둘 다 정수이기 때문에 실수로 계산이 되지 않는다.
        return IntStream.range(2, n).filter(i -> n%i == 1).findFirst().getAsInt();
    }

    public static void main(String[] args) {
        int n = 11;
        System.out.println(solution(n));
    }
}
