package 프로그래머스;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class 옹알이2 {
    public static int solution(String[] babbling) {
        //피드백 replace를 사용하면 더 빠르게 할 수 있었다.. 중복은 하드코딩으로 처리하면 되는거였네,,
        Set<String> speakSet = new HashSet<>(Arrays.asList("aya", "ye", "woo", "ma"));
        int answer = 0;
        for (String s : babbling){
            String cTemp = "";
            String beforeTemp = "";
            String sTemp = "";
            for (char c : s.toCharArray()){
                cTemp += c;
                if(cTemp.length() > 3) break;
                if(speakSet.contains(cTemp) && !beforeTemp.contains(cTemp)){
                    beforeTemp = cTemp;
                    sTemp += cTemp;
                    cTemp = "";
                    if(s.length() == sTemp.length()) answer++;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        String[] babbling = {"ayayemaaya"};
        //String[] babbling = {"ayaye", "uuu", "yeye", "yemawoo", "ayaayaa"};
        System.out.println(solution(babbling));
    }
}
