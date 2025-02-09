package 순열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 줄서는방법 {

    public static long factorial(int n) {
        long fact = 1;
        for(int i = 1; i <= n; i++) {
            fact = fact * i;
        }
        return fact;
    }

    public static int[] solution(int n, long k) {

        ArrayList<Integer> element = new ArrayList<Integer>();
        int[] answer = new int[n];

        for(int i = 1; i <= n; i++) {
            element.add(i);
        }

        k--;

        for(int i = 1; i <= n; i++) {
            long fact = factorial(n - i);
            int index = (int) (k / fact);
            k %= fact;
            answer[i-1] = element.get(index);
            element.remove(index);
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        long k = Integer.parseInt(st.nextToken());
        int[] answer = solution(n, k);
        System.out.println(Arrays.toString(answer));
    }
}
