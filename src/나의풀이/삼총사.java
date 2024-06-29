package 나의풀이;

public class 삼총사 {
    public static int solution(int[] number) {
        int cnt = 0;
        for(int i = 0; i < number.length-2; i++) {
            for(int j = i + 1; j < number.length-1; j++) {
                for(int k = j + 1; k < number.length; k++) {
                    if(number[i] + number[j] + number[k] == 0) {
                        cnt++;
                    }
                }
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        int[] number = {-1, 1, -1, 1};
        System.out.println(solution(number));
    }
}
