package 나의풀이;

public class 푸드파이트대회 {
    public static String solution(int[] food) {
        String answer = "0";
        for (int i = food.length-1; i >= 1; i--) {
            food[i] = food[i]/2;
            for (int j = 0; j < food[i]; j++) {
                answer = i + answer + i;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        int[] food = {1, 3, 4, 6};
        System.out.println(solution(food));
    }
}
