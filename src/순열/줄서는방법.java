package 순열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class 줄서는방법 {

    public static int[] solution(int n, long k) {
        long num = 1;
        List<Integer> list = new ArrayList<>();

        for(int i = 1 ; i<= n ; i++){
            list.add(i);
            num*=i;
        }

        int[] ans = new int[n];
        int idx = 0;
        k--;

        while (idx < n){
            num = num / (n - idx);
            ans[idx++] = list.remove((int)(k/num));
            k= k % num;
        }

        return ans;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        long k = Long.parseLong(st.nextToken());

        int[] result = solution(n, k);
        for(int val : result){
            System.out.print(val + " ");
        }
    }
}
