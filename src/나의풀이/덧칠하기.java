package 나의풀이;

public class 덧칠하기 {
    public static int solution(int n, int m, int[] section) {
        int temp = 0;
        int cnt = 0;
        for(int sec : section){
            if(temp < sec) {
                temp = sec + m-1;
                cnt++;
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        int n = 4, m = 1;
        int[] section = {1,2,3,4};
        System.out.println(solution(n, m, section));
    }
}
