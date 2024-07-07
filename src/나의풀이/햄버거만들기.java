package 나의풀이;

import java.util.Stack;

public class 햄버거만들기 {
    public static int solution(int[] ingredient) {
        Stack<Integer> stack = new Stack<>();
        int cnt = 0;
        int answer = 0;

        for (int i = 0; i < ingredient.length; i++) {
            if (stack.isEmpty()) {
                if (ingredient[i] == 1) {
                    stack.push(ingredient[i]);
                    cnt = ingredient[i];
                }
            } else {
                if ((stack.peek() == 1 && ingredient[i] == 3) || (stack.peek() == 2 && ingredient[i] == 2) || (stack.peek() == 3 && ingredient[i] == 2) ||(stack.peek() == 3 && ingredient[i] == 3)) {
                    stack.clear();
                    cnt = 0;
                } else {
                    if (cnt == 3 && ingredient[i] == 1) {
                        stack.pop();
                        stack.pop();
                        stack.pop();
                        answer++;
                        if (!stack.isEmpty()) {
                            cnt = stack.peek();
                        }
                    } else {
                        stack.push(ingredient[i]);
                        cnt = ingredient[i];
                    }
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] ingredient = {1, 2, 3, 1, 1, 2, 3, 1};
        System.out.println(solution(ingredient));
    }
}
