package 순열;

import java.util.ArrayList;

public class 줄서는방법 {
    public static int n, k;
    public static boolean[] used;
    public static ArrayList<ArrayList<Integer>> result;
    public static ArrayList<Integer> currentPermutation;

    public static void solution(){
        if(currentPermutation.size() == n){
            System.out.println(currentPermutation);
            result.add(new ArrayList<>(currentPermutation)); // 주의  result.add(currentPermutation); 이렇게 할 경우 객체가 참조되니 주의
            return;
        }

        for(int i=1; i<=n; i++){
            if(!used[i]){
                used[i] = true;
                currentPermutation.add(i);
                solution();
                used[i] = false;
                currentPermutation.remove(currentPermutation.size()-1);
            }
        }
    }

    public static void main(String[] args) {
        n = 3;
        k = 5;
        used = new boolean[n+1];
        result = new ArrayList<>();
        currentPermutation = new ArrayList<>();
        solution();
        System.out.println(result.get(k-1));
    }
}
