import java.util.LinkedList;
import java.util.Queue;

public class 붕대감기 {
    public static int solution(int[] bandage, int health, int[][] attacks) {
        int t = bandage[0];
        int x = bandage[1];
        int y = bandage[2];
        int now = health;
        int damage;
        int tCnt = 0;
        Queue<int[]> q = new LinkedList<>();

        for(int i=0; i < attacks.length; i++){ q.add(attacks[i]);}

        for(int j=0; j < attacks[attacks.length - 1][0] - 1; j++){
            if(q.peek()[0] == j){
                damage = q.poll()[1];
                now -= damage;
                tCnt = 0;
                if(now < 1){
                    return -1;
                }
            }else{
                int healAmount = x;
                if(t==tCnt){
                    healAmount += y;
                    tCnt = 0;
                }
                if(health < now + healAmount){
                    now = health;
                }else {
                    now += healAmount;
                }
            }
        }
        return now;
    }

    public static void main(String[] args) {
        int[] bandage = {1,1,1};
        int health = 5;
        int[][] attacks = {{1,2}, {3,2}};
        System.out.println(solution(bandage, health, attacks));
    }
}
