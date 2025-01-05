package 프로그래머스;

import java.util.HashMap;
import java.util.Map;

public class 완주하지못한선수 {
    public static String solution(String[] participant, String[] completion) {

        Map<String, Integer> map = new HashMap<>();
        for(String s : completion) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }
        String answer = "";
        for(String s : participant) {
            if(map.containsKey(s)){
                if(map.get(s) > 1){
                    map.replace(s, map.get(s) - 1);
                }else{
                    map.remove(s);
                }
            }else{
                answer = s;
                break;
            }
        }
        return answer;
    }

    public static void main(String[] args) {

        String[] participant = {"a", "mislav", "stanko", "mislav", "mislav", "ana" };
        String[] completion = {"stanko", "ana", "mislav", "mislav", "a"};
        System.out.println(solution(participant, completion));
    }
}
