package 나의풀이;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class 모의고사 {
    public static int[] solution(int[] answers) {
        int[] arr1 = {1, 2, 3, 4, 5};
        int[] arr2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] arr3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        int[] cntArr = new int[3];

        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        Queue<Integer> q3 = new LinkedList<>();

        Arrays.stream(arr1).forEach(q1::offer);
        Arrays.stream(arr2).forEach(q2::offer);
        Arrays.stream(arr3).forEach(q3::offer);

        //다른 사람의 풀이 -  i%a.length 하게 되면 배열을 순회하면서 찾을 수 있구나,,
//        for(int i=0; i<answer.length; i++) {
//            if(answer[i] == a[i%a.length]) {score[0]++;}
//            if(answer[i] == b[i%b.length]) {score[1]++;}
//            if(answer[i] == c[i%c.length]) {score[2]++;}
//        }

        for(int i : answers){
            if(q1.peek().equals(i)) cntArr[0]++;
            if(q2.peek().equals(i)) cntArr[1]++;
            if(q3.peek().equals(i)) cntArr[2]++;
            q1.offer(q1.poll());
            q2.offer(q2.poll());
            q3.offer(q3.poll());
        }

        ArrayList<Integer> result = new ArrayList<>();
        int maxVal = Math.max(cntArr[0], Math.max(cntArr[1], cntArr[2]));
        for(int i=0; i<3; i++){
            if(maxVal == cntArr[i]) result.add(i+1);
        }

        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        int[] answers = {1,3,2,4,2};
        System.out.println(Arrays.toString(solution(answers)));
    }
}
