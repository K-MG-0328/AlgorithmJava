package 프로그래머스;

/*아쉬웠던 점
    Stream을 사용하면 굳이 합계를 구할 필요도 없었다는 점에서 너무 아쉽다.
    Stream 사용법 미숙이 아쉬움
    return Arrays.stream(arr).average().getAsDouble();
* */
public class 평균구하기 {
    static double solution(int[] arr) {
        double result=0;
        for(int num :arr) result+=num;
        result = result/arr.length;
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4};
        System.out.println(solution(arr));
    }
}
