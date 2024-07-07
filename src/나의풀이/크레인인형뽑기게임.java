package 나의풀이;

import java.util.Stack;

public class 크레인인형뽑기게임 {
    public static int solution(int[][] board, int[] moves) {

        Stack<Integer> stack = new Stack<>();
        int answer = 0;

        for (int move : moves){
            for(int i=0; i<board.length; i++){
                if(board[i][move-1] != 0){
                    if(stack.isEmpty() || stack.peek() != board[i][move-1]){
                        stack.push(board[i][move-1]);
                    }else{
                        stack.pop();
                        answer+=2;
                    }
                    board[i][move-1] = 0;
                    break;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        int[][] board = {{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}};
        int[] moves ={1,5,3,5,1,2,1,4};
        System.out.println(solution(board, moves));
    }
}
