package 다른사람의풀이;

public class 없는숫자더하기2 {
    public int solution(int[] numbers) {
        int sum = 45;
        for (int i : numbers) {
            sum -= i;
        }
        return sum;
    }
}
