package 나의풀이;

import java.util.HashMap;
import java.util.Map;

public class 성격유형검사하기 {
    public static String solution(String[] survey, int[] choices) {
        //1 2 3 4 5 6 7
        //3 2 1 0 1 2 3
        Map<Character, Integer> mbtiMap = new HashMap<>();

        for (int i = 0; i < survey.length; i++) {
            if(choices[i] < 4) {
                mbtiMap.put(survey[i].charAt(0), mbtiMap.getOrDefault(survey[i].charAt(0), 0) + 4-choices[i]);
            }else if(choices[i] > 4){
                mbtiMap.put(survey[i].charAt(1), mbtiMap.getOrDefault(survey[i].charAt(1), 0) + choices[i]-4);
            }
        }

        char[] mbtiArr = {'R', 'T', 'C', 'F', 'J', 'M', 'A', 'N'};
        String answer = "";
        for (int i = 0; i < mbtiArr.length; i+=2) {
            answer += mbtiMap.getOrDefault(mbtiArr[i], 0) >= mbtiMap.getOrDefault(mbtiArr[i+1], 0) ? mbtiArr[i] : mbtiArr[i+1];
        }

        return answer;
    }

    public static void main(String[] args) {
        String[] survey = {"RT", "RT", "RT"};
        int[] choices = {7, 2, 4};
        System.out.println(solution(survey, choices));
    }
}
