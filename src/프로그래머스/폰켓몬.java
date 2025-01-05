package 프로그래머스;

import java.util.HashSet;
import java.util.Set;

public class 폰켓몬 {
    public static int solution(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int i : nums){
            set.add(i);
        }
        int answer = Math.min(set.size(), nums.length/2);
        return answer;
    }

    public static void main(String[] args) {
        int[] nums = {3,3,3,2,2,4};
        System.out.println(solution(nums));
    }
}
