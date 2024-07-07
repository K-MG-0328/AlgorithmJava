package 나의풀이;

import java.util.Stack;

public class 문자열나누기 {
    public static int solution(String s) {

        int answer = 0;
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if(stack.isEmpty()){
                stack.push(c);
            }else{
                if(c != stack.peek()){
                    stack.pop();
                    if(stack.isEmpty()){
                        answer++;
                    }
                }else{
                    stack.push(c);
                }
            }
        }
        if(!stack.isEmpty()) answer++;
        return answer;
    }

    public static void main(String[] args) {
        String s = "abracadabra";
        //result = 3
        System.out.println(solution(s));
    }
}
