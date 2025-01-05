package DFS;

public class 타겟넘버 {
    static int[] numbers = {4, 1, 2, 1};
    static int target = 4;
    static int answer = 0;

    public static void dfs(int index, int val){

        if(target == val && index == numbers.length) {
            answer++;
            return;
        }

        if(index < numbers.length) {
            int plusVal = val + numbers[index];
            dfs(index + 1, plusVal);

            int minusVal = val - numbers[index];
            dfs(index + 1, minusVal);
        }
    }

    public static int solution(int[] numbers, int target) {

        //dp를 제외하고 완전탐색으로만 문제를 풀어보자. 완전탐색으로만 문제를 풀어도 2^20 = 10^6이라 할만해
        dfs(0, 0);
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(numbers, target));
    }
}
