package 프로그래머스;

import java.util.Arrays;

public class 행렬의덧셈 {
    static int[][] solution(int[][] arr1, int[][] arr2) {

        int[][] result = Arrays.copyOf(arr1, arr1.length);
        for(int i=0;i<arr1.length;i++){
            for(int j=0;j<arr1[0].length;j++){
                result[i][j] = arr1[i][j] + arr2[i][j];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] arr1 = {{1,2},{2,3}};
        int[][] arr2 = {{3,4},{5,6}};
        System.out.println(solution(arr1, arr2));
    }
}
