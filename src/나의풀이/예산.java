package 나의풀이;

import java.util.Arrays;

public class 예산 {
    public static int solution(int[] d, int budget) {

        Arrays.sort(d);
        for (int i = 0; i < d.length; i++) {
            if (budget < d[i]) {
                return i;
            }
            budget -= d[i];
        }
        return d.length;
    }

    public static void main(String[] args) {
        int[] d = {2,2,3,3};
        int budget = 10;
        System.out.println(solution(d, budget));
    }
}
