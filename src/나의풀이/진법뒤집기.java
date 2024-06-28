package 나의풀이;

import java.util.Stack;

public class 진법뒤집기 {
    public static int solution(int n) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();

        while(n!=0){
            stack.push(n%3);
            n = n/3;
        }

        int stackSize = stack.size();
        //배운점 stackSize는 pop을 할 때마다 동적으로 변하므로  반복문내에서 stack.size()로 하면 안된다. 변수로 담아서 처리해야함.
        System.out.println(stack);
        for(int i=0;i<stackSize;i++){
            answer += (int)Math.pow(3, i) * stack.pop();
        }

        //추가
        // Integer.parseInt(a, 3) N진법 -> 10진법으로 변환은 parseInt에서 제공한다.
        System.out.println(Integer.parseInt("22111", 3));
        return answer;
    }

    public static void main(String[] args) {
        int n = 125;         //229
        System.out.println(solution(n));
    }
}
