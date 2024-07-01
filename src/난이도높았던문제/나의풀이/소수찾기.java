package 난이도높았던문제.나의풀이;

public class 소수찾기 {
    public static int solution(int n) {
        //1은 소수가 아니다.
        //1부터 입력받은 숫자 n 사이에 있는 소수의 개수를 반환하는 함수

        //기사단장 문제랑 비슷한 문제
        //2부터 n까지 배수를 구하고  // 값이 1이면 자기자신만 카운트 한거니까.
        int[] result = new int[n+1];
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= n / i; j++) {
                result[i*j]++;
            }
        }
        int answer = 0;

        for(int i : result){
            if(i==1) answer++;
        }
        return answer;
    }

    public static void main(String[] args) {
        int n = 10;
        System.out.println(solution(n));
    }
}
