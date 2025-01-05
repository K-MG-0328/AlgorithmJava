package 프로그래머스;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class 로또최고순위와최저순위 {
    public static int[] solution(int[] lottos, int[] win_nums) {
        Set<Integer> set = new HashSet<>();

        for(int i : win_nums){
            set.add(i);
        }

        int zeroCnt = 0;
        int cnt = 6;
        int rank = 6;
        for(int i : lottos){
            if(i == 0){
                zeroCnt++;
            }else if(set.contains(i)){
                cnt--;
                if(cnt < 5){
                    rank--;
                }
            }
        }
        int[] answer = new int[2];
        if(cnt == 6 && zeroCnt != 6){
            answer[0] = cnt - zeroCnt;
            answer[1] = rank;
        }else{
            answer[0] = cnt - zeroCnt + 1;
            answer[1] = rank;
        }
        return answer;
    }

    public static void main(String[] args) {
        //int[] lottos = {1, 2, 3, 4, 5, 6};
        int[] lottos = {0, 0, 0, 0, 0, 0};
        int[] win_nums = {7, 8, 9, 10, 11, 12};
        System.out.println(Arrays.toString(solution(lottos, win_nums)));
    }
}
