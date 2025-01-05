package 프로그래머스;

public class 콜라문제 {
    public static int solution(int a, int b, int n) {
        //a 빈병 개수, b 콜라 개수, n 빈병 총 개수
        int sum = 0;
        while(n>=a){
            sum += n/a * b;
            n = n/a * b + n%a;
        }
        return sum;
    }

    public static void main(String[] args) {
        int a = 2, b = 1, n=20;
        System.out.println(solution(a, b, n));
    }
}
