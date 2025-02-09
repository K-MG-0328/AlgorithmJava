package 순열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class N과M {
    public static int N, M;
    public static int[] arr;
    public static boolean[] used;
    public static ArrayList<Integer> currentPermutation;

    public static void solution() {
        if (currentPermutation.size() == M) {
            for (int i = 0; i < currentPermutation.size(); i++) {
                System.out.print(currentPermutation.get(i) + " ");
            }
            System.out.println();
            return;
        }

        for(int i = 1; i < arr.length; i++) {
            if (!used[i]) {
                used[i] = true;
                currentPermutation.add(i);
                solution();
                currentPermutation.remove(currentPermutation.size()-1);
                used[i] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N+1];
        used = new boolean[N+1];
        currentPermutation = new ArrayList<>();
        solution();
    }
}
