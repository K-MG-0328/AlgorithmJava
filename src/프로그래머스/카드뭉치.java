package 프로그래머스;

import java.util.LinkedList;
import java.util.Queue;

public class 카드뭉치 {
    public static String solution(String[] cards1, String[] cards2, String[] goal) {

        Queue<String> q1 = new LinkedList<>();
        Queue<String> q2 = new LinkedList<>();

        int len = Math.max(cards1.length, cards2.length);

        for(int i = 0; i < len; i++) {
            if(cards1.length > i) q1.offer(cards1[i]);
            if(cards2.length > i) q2.offer(cards2[i]);
        }

        Boolean bol = true;
        for(String s : goal){
            if(!q1.isEmpty() && q1.peek().equals(s)){
                q1.poll();
            }else if(!q2.isEmpty() && q2.peek().equals(s)){
                q2.poll();
            }else{
                bol = false;
            }
        }
        return bol == true ? "Yes" : "No";
    }

    public static void main(String[] args) {
        String[] cards1 = {"i", "water", "drink"};
        String[] cards2 = {"want", "to"};
        String[] goal = {"i", "want", "to", "drink", "water"};
        System.out.println(solution(cards1,cards2,goal));
    }
}
