package 프로그래머스;
/*
* 삼항연산자나, 변수를 안만들고 조건문안에서 바로 비교했으면 코드 수를 더 줄일 수 있었는데 아쉽다.
* */
public class 정수제곱근판별 {
    static long solution(long n) {
        double sqrtRoot = Math.sqrt(n);
        long compareValue = (long)sqrtRoot;
        long answer;
        if(sqrtRoot == compareValue){
            answer = (long)Math.pow(sqrtRoot+1, 2);
        } else {
            answer = -1;
        };
        return answer;
    }

    public static void main(String[] args) {
        long n = 121;
        System.out.println(solution(n));
    }
}
