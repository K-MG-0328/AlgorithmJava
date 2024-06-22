package 나의풀이;

import java.util.LinkedList;
import java.util.Queue;
/*아쉬웠던 점
* 공격시점에 회복에 대해서 다 연산처리했다면 마지막 공격시간까지 초단위로 반복할 필요가 없었다는 점
* math.min 이나 삼항연산자를 사용했다면 코드가 더 간결해질수 있었던 점
* */

public class 붕대감기 {
    public static int solution(int[] bandage, int health, int[][] attacks) {
        int now = health;
        int damage;
        int tCnt = 0;
        Queue<int[]> q = new LinkedList<>();

        for(int i=0; i < attacks.length; i++){ q.add(attacks[i]);}

        for(int j=0; j <= attacks[attacks.length - 1][0]; j++){
            if(q.peek()[0] == j){
                damage = q.poll()[1];
                now -= damage;
                tCnt = 0;
                if(now < 1){
                    return -1;
                }
            }else{
                tCnt++;
                int healAmount = bandage[1];
                if(bandage[0]==tCnt){
                    healAmount += bandage[2];
                    tCnt = 0;
                }
                now += healAmount;
                if(health < now){
                    now = health;
                }
            }
        }
        return now;
    }

    public static void main(String[] args) {
        int[] bandage = {5, 1, 5};
        int health = 30;
        int[][] attacks = {{2, 10}, {9, 15}, {10, 5}, {11, 5}};
        System.out.println(solution(bandage, health, attacks));
    }
}
