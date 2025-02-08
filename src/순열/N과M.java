package 순열;

import java.util.ArrayList;

public class N과M {
    public static int N, M;
    public static int[] arr;
    public static boolean[] used;
    public static ArrayList<Integer> currentPermutation;

    public static void solution() {
        if (currentPermutation.size() == M) {
            System.out.println(currentPermutation);
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

    public static void main(String[] args) {
        N = 4;
        M = 2;
        arr = new int[N+1];
        used = new boolean[N+1];
        currentPermutation = new ArrayList<>();
        solution();
    }
}
