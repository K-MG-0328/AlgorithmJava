package 다른사람의풀이;


public class 두정수사이의합2 {
    static long solution(int a, int b) {
        int min = Math.min(a, b);
        int max = Math.max(a, b);
        return ((max-min+1) * (max+min)) / 2;
    }

    public static void main(String[] args) {
        int a = 5, b = 3;
        System.out.println(solution(a, b));
    }
}
