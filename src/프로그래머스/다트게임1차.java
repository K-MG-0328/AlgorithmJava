package 프로그래머스;

import java.util.Arrays;

public class 다트게임1차 {
    public static int solution(String dartResult) {
        //기회는 3번
        //점수|보너스|옵션
        //점수는 0~10
        //보너스 S D T
        //옵션 * #
        double[] score = new double[4];
        int index = 0;
        char[] chars = dartResult.toCharArray();
        for( int i = 0; i < dartResult.length(); i++) {
            System.out.println("before =" + Arrays.toString(score));
            System.out.println(chars[i]);
            if(Character.isDigit(chars[i])) {
                if(chars[i] != '0') {
                    score[++index] += Integer.parseInt(String.valueOf(chars[i]));
                }else if(i > 0){
                    if(Character.isDigit(chars[i-1])) {
                        score[index] *= 10;
                    }else{
                        index++;
                    }
                }
            }else if(Character.isAlphabetic(chars[i])) {
                System.out.println(chars[i]);
                switch (chars[i]) {
                    case 'D':
                        score[index] = Math.pow(score[index], 2);
                        break;
                    case 'T':
                        score[index] =  Math.pow(score[index], 3);
                        break;
                }
            }else if(chars[i] == '*' || chars[i] == '#'){
                switch (chars[i]) {
                    case '*':
                        score[index-1] *= 2;
                        score[index] *= 2;
                        break;
                    case '#':
                        score[index] *= -1;
                        break;
                }
            }
            System.out.println("after =" + Arrays.toString(score));
        }

        int answer = ((int) Arrays.stream(score).sum());
        return answer;
    }

    public static void main(String[] args) {
        String dartResult = "1S*2T3S";
        System.out.println(solution(dartResult));
    }
}
