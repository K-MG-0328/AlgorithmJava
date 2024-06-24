package 나의풀이;

public class 콜라츠추측 {
    static int solution(long num) {
        for(int i = 0; i < 500; i++) {
            if(num == 1) return i;
            num = num%2==0?num/2:num*3+1;
        }
        return -1;
    }

    public static void main(String[] args) {
        int n = 6;
        System.out.println(solution(n));
    }
}
