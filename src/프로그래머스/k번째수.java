package 프로그래머스;

import java.util.Arrays;

public class k번째수 {
    public static int[] solution(int[] array, int[][] commands) {
        //자바에서는 자를 때 항상 시작부분은 이상이고 마지막부분은 미만이라는 것을 염두해두기
        int[] answer = new int[commands.length];
        for(int i = 0; i < commands.length; i++) {
            int[] tempArr = Arrays.copyOfRange(array, commands[i][0]-1, commands[i][1]);
            Arrays.sort(tempArr);
            answer[i] = tempArr[commands[i][2] - 1];
        }
        return answer;
    }

    public static void main(String[] args) {
        int[] array = {1, 5, 2, 6, 3, 7, 4};
        int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};
        //[5, 6, 3]
        System.out.println(Arrays.toString(solution(array, commands)));
    }
}
