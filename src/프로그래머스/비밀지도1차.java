package 프로그래머스;

import java.util.Arrays;

public class 비밀지도1차 {
    public static String[] solution(int n, int[] arr1, int[] arr2) {
        /*
        * & (AND)
        | (OR)
        ^ (XOR)
        ~ (NOT)
        << (왼쪽 시프트)
        >> (오른쪽 시프트)
        >>> (부호 없는 오른쪽 시프트)
        * 비트연산자 안사용한게 좀 아쉽네.
        * */
        String[] answer = new String[n];
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        StringBuilder temp = new StringBuilder();

        for (int i = 0; i < n; i++) {            ;
            sb1.append(leftPad(Integer.toBinaryString(arr1[i]),n));
            sb2.append(leftPad(Integer.toBinaryString(arr2[i]),n));
            for (int j = 0; j < n; j++) {
                if(sb1.charAt(j) == '1' || sb2.charAt(j) == '1'){
                    temp.append("#");
                }else{
                    temp.append(" ");
                }
            }
            answer[i] = temp.toString();
            sb1.setLength(0);
            sb2.setLength(0);
            temp.setLength(0);
        }
        return answer;
    }

    public static String leftPad(String s, int n){
        String str = "";
        for(int i =0; i<n-s.length(); i++) str+= "0";
        str += s;
        return str;
    }

    public static void main(String[] args) {
        int n = 5;
        int[] arr1 = {9, 20, 28, 18, 11};
        int[] arr2 = {30, 1, 21, 17, 28};
        System.out.println(Arrays.toString(solution(n, arr1, arr2)));
    }
}
