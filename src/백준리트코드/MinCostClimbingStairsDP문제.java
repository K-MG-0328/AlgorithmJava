package 백준리트코드;

import java.util.HashMap;

public class MinCostClimbingStairsDP문제 {

    //MinCostClimbingStairs DP문제
    static int[] cost = {10,15,20};
    static int[] memo = new int[cost.length + 10];

    //topDown 방식
    public static int topDown(int stair){

        //1층과 2층은 0의 값으로 올라갈 수 있음. * 해당 층의 값이 0이라는게 아님.
        if(stair == 0 || stair == 1) return 0;

        //메모리에 값이 있으면 해당 값을 반환
        if(memo[stair] != 0) return memo[stair];

        //해당 층에 올라가기 위한 값 + 해당 층의 값
        memo[stair] = Math.min(topDown(stair-2) + cost[stair-2] , topDown(stair-1) + cost[stair-1]);
        return memo[stair];
    }

    static HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

    //bottomUp 방식
    public static int bottomUp(int stairs){

        for(int i=2; i<=stairs; i++){
            map.put(i, Math.min(map.get(i-1) + cost[i-1], map.get(i-2) + cost[i-2]));
        }
        return map.get(stairs);
    }

    public static void main(String[] args) {
        System.out.println(topDown(cost.length));

        map.put(0, 0);
        map.put(1, 0);
        System.out.println(bottomUp(cost.length));
    }
}
