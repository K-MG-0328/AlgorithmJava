package 백준리트코드;

public class 피보나치수5 {
    static int n = 20;
    static int answer;
    public static void main(String[] args) {
        long startTime = System.nanoTime();
        dfs(0, 1 , 2);
        System.out.println(answer);
        long endTime = System.nanoTime();
        System.out.println(endTime - startTime);
    }

    static void dfs(int i, int j, int dept) {
        if(dept == n){
            answer = i+j;
            return;
        }
        int val = i+j;
        dfs(j, val, dept + 1);
    }
}
