package 프로그래머스;

import java.util.Arrays;

public class 최대공약수와최대공배수유클리드호제법 {
    public static int[] solution(int n, int m) {
        //유클리드 호제법
        int max = Math.max(n, m), min = Math.min(n, m), temp;
        int gcd, lcm;
        while (max%min != 0) {
            temp = min;
            min = max % min;
            max = temp;
        }
        gcd = min;
        lcm = (n*m)/gcd;

        int[] answer = {gcd,lcm};
        return answer;
    }

    public static void main(String[] args) {
        int n=2, m=5;
        System.out.println(Arrays.toString(solution(n, m)));
    }
}
