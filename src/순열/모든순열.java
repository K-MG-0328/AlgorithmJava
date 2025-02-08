package 순열;

import java.util.ArrayList;

public class 모든순열 {
    /*
    * N이 주어졌을 때 N만큼의 순열 배열을 생성
    * N만큼 반복문 ->  used 배열로 해당 요소를 사용했는지 확인 -> 요소를 선택했으면 재귀 호출 -> 재귀 호출이 끝나면 현재 순열에서 요소 제거
    * */
    public static int[] arr;
    public static boolean[] used;
    public static ArrayList<Integer> currentPermutation;

    public static void generatePermutation(int[] arr, boolean[] used, ArrayList<Integer> currentPermutation) {
        if(!currentPermutation.isEmpty() && arr.length - 1 == currentPermutation.size()) {
            System.out.println(currentPermutation);
            return;
        }

        for (int i = 1; i < arr.length; i++) {
            if(used[i] == false) {
                used[i] = true;
                currentPermutation.add(i);
                generatePermutation(arr, used, currentPermutation);
                currentPermutation.remove(currentPermutation.size() - 1);
                used[i] = false;
            }
        }
    }

    public static void solution(int n){
        arr = new int[n+1];
        used = new boolean[n+1];
        currentPermutation = new ArrayList<>();

        for(int i=1;i<=n;i++){
            arr[i] = i;
        }
        generatePermutation(arr, used, currentPermutation);
    }

    public static void main(String[] args) {
        solution(3);
    }
}
