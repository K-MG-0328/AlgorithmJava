package 프로그래머스;

import java.util.stream.IntStream;

public class 음양더하기 {
    static int solution(int[] absolutes, boolean[] signs) {
        /*
        int sum=0;
        for(int i=0; i<absolutes.length; i++ ){
            if(signs[i]){
                sum+=absolutes[i];
            }else{
                sum-=absolutes[i];
            }
        }
        */
        return IntStream.range(0, absolutes.length).map(i-> signs[i] ? absolutes[i] : -absolutes[i]).sum();
    }

    public static void main(String[] args) {
        int[] absolutes = {4,7,12};
        boolean[] signs = {true,false,true};
        System.out.println(solution(absolutes, signs));
    }
}
