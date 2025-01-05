package 프로그래머스;

import java.util.Arrays;

public class 과일장수 {
    public static int solution(int k, int m, int[] score) {

        /*다른사람의 풀이*/
//        public int solution(int k, int m, int[] score) {
//            int answer = 0;
//
//            Arrays.sort(score);
//
//            for(int i = score.length; i >= m; i -= m){
//                answer += score[i - m] * m;
//            }
//
//            return answer;
//        }


        /*나의 풀이*/
        // i--로 하나씩 다 연산할 필요가 없었네 i -= m 이렇게 했으면 됬었고,, 이렇게 했으면 cnt를 빼도 됐었네.
        Arrays.sort(score);
        int answer = 0;
        for (int i = score.length-m; i >= score.length % m; i-=m) {
            answer += score[i] > k ? k * m : score[i] * m;
        }
        return answer;
    }

    public static void main(String[] args) {
        int k=4, m=3;
        int[] score = {4, 1, 2, 2, 4, 4, 4, 4, 1, 2, 4, 2};
        System.out.println(solution(k,m,score));
    }
}
