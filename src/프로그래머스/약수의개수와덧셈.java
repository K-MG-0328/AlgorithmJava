package 프로그래머스;

public class 약수의개수와덧셈 {

    /*
      9 = 1,3,9
      4 = 1,2,4
      25 = 1,5,25
      */
    /*제곱수는 약수가 홀수개이다.*/
    /*제곱수가 아닌 수는 약수가 짝수개이다.*/
    //위의 내용을 알면 이중 for문을 사용하지 않아도 된다. 하나의 반복문으로 구현이 가능하다.
    static int solution(int left, int right) {
        int count, sum = 0;
        for(int i = left; i <= right; i++){
            count = 0;
            for(int j = 1; j <= i; j++){
                if(i%j == 0) count++;
            }
            sum += count%2==0? i : -i;
        }
        return sum;
    }

    public static void main(String[] args) {
        int left = 24;
        int right = 27;
        System.out.println(solution(left, right));
    }
}
