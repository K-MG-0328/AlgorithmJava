package 난이도높았던문제.나의풀이;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class 기사단원의무기 {
    public static int solution(int number, int limit, int power) {

        //문제 풀이 자체는 어렵지 않았으나
        //약수를 구하는 방법이 아니라 배수를 구해서 풀이하는 방식을 생각하지 못한게 아쉽다.
        //성능 적으로는 1부터 number까지의 배수를 구하는게 더 효율적이구나,,

//        int[] count = new int[number + 1];
//        for (int i = 1; i <= number; i++) {
//            for (int j = 1; j <= number / i; j++) { //배수를 구하는 방법
//                count[i * j]++;
//            }
//        }
//        System.out.println(Arrays.toString(count));
//
//        int answer = 0;
//        for (int i = 1; i <= number; i++) {
//            if (count[i] > limit) {
//                answer += power;
//            } else {
//                answer += count[i];
//            }
//        }
//        return answer;

        //나의 풀이 약수를 일일이 구했으나 i의 number까지의 배수를 구하는게 더 효율적이었다.
        int answer = 1;
        Set<Integer> set = new HashSet<>();
        for (int i = 2; i <= number; i++) {
            int cnt = 0;
            set.add(i);
            for (int j = 1; j <= i/2; j++) {
                if(i%j == 0){
                    set.add(j);
                }
                if(set.size() > limit){
                    cnt = power;
                    set.clear();
                    break;
                }
            }
            if(set.size() != 0){
                cnt = set.size();
                set.clear();
            }
            answer+=cnt;
        }
        return answer;
    }

    public static void main(String[] args) {
        int number = 5 , limit = 3, power = 2;
        System.out.println(solution(number, limit, power));
    }
}
