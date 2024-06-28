package 나의풀이;

import java.util.Arrays;
import java.util.Stack;

public class 같은숫자는싫어 {
    public static int[] solution(int[] arr) {
        Stack<Integer> s = new Stack();
        for(int i : arr){
            if(s.isEmpty() || !s.peek().equals(i)){
                s.push(i);
            }
        }
        return s.stream().mapToInt(Integer::intValue).toArray();

    }

    public static void main(String[] args) {
        int[] arr = {1,1,3,3,0,1,1};
        //1,3,0,1
        System.out.println(Arrays.toString(solution(arr)));
    }
}
