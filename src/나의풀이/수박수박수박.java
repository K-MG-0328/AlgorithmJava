package 나의풀이;

public class 수박수박수박 {
    static String solution(int n) {
        String s ="";
        for(int i=0; i<n; i++) { s += i%2==0 ? "수" : "박"; };
        return s;
    }

    public static void main(String[] args) {
        int n = 3;
        System.out.println(solution(n));
    }
}
