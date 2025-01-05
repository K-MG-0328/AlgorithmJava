package 프로그래머스;

public class 소수만들기 {
    public static int solution(int[] nums) {
        int answer = 0;

        for (int i = 0; i < nums.length-2; i++) {
            for (int j = i + 1; j < nums.length-1; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    boolean flag = true;
                    int num = nums[i]+nums[j]+nums[k];
                    for (int div = 2; div < num/2; div++) {
                        if(num % div == 0){ flag = false; break; }
                    }
                    if(flag) answer += 1;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {

        int[] nums = {1,2,3,4};
        System.out.println(solution(nums));
    }
}
