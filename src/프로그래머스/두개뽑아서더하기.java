package 프로그래머스;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

public class 두개뽑아서더하기 {
    public static int[] solution(int[] numbers) {
//        Set<Integer> set = new HashSet<>();
//        for (int i = 0; i < numbers.length-1; i++) {
//            for (int j = i + 1; j < numbers.length; j++) {
//                set.add(numbers[i] + numbers[j]);
//            }
//        }
//        int[] answer = set.stream().sorted().mapToInt(Integer::intValue).toArray();
//        return answer;
        Set<Integer> set = new TreeSet<>();
        for (int i = 0; i < numbers.length-1; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                set.add(numbers[i] + numbers[j]);
            }
        }
        int[] answer = set.stream().mapToInt(Integer::intValue).toArray();
        return answer;
    }

    public static void main(String[] args) {

        int[] numbers = {5,0,2,7};
        //2 3 4 5 6 7
        System.out.println(Arrays.toString(solution(numbers)));
    }
}
