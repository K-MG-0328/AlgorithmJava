package 나의풀이;

import java.util.HashSet;
import java.util.Set;

public class 체육복 {
    public static int solution(int n, int[] lost, int[] reserve) {

//        Set<Integer> lostSet = new HashSet<>();
//        Set<Integer> reserveSet = new HashSet<>();
//
//        for (int lostStudent : lost){
//            lostSet.add(lostStudent);
//        }
//
//        for (int reserveStudent : reserve){
//            reserveSet.add(reserveStudent);
//        }
//
//        for (int lostStudent : lost){
//            if(reserveSet.contains(lostStudent)){
//                lostSet.remove(lostStudent);
//                reserveSet.remove(lostStudent);
//            }else if(reserveSet.contains(lostStudent - 1)){
//                lostSet.remove(lostStudent);
//                reserveSet.remove(lostStudent - 1);
//            }else if(reserveSet.contains(lostStudent + 1)){
//                lostSet.remove(lostStudent);
//                reserveSet.remove(lostStudent + 1);
//            }
//        }
//
//        int answer = n - lostSet.size();
//        return answer;

        //set으로 풀면 최적으로 낼 수 있는데 굳이 탐욕법으로 풀라는 문제,,
        int[] people = new int[n];
        int answer = n;

        for (int l : lost)
            people[l-1]--;
        for (int r : reserve)
            people[r-1]++;

        for (int i = 0; i < people.length; i++) {
            if(people[i] == -1) {
                if(i-1>=0 && people[i-1] == 1) {
                    people[i]++;
                    people[i-1]--;
                }else if(i+1< people.length && people[i+1] == 1) {
                    people[i]++;
                    people[i+1]--;
                }else
                    answer--;
            }
        }
        return answer;

    }

    public static void main(String[] args) {
        int n = 5;
        int[] lost = {2, 3};
        int[] reserve = {3, 4};
        System.out.println(solution(n, lost, reserve));
    }

}
