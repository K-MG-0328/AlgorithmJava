package 프로그래머스;

import java.util.HashMap;
import java.util.Map;

public class 완주하지못한선수 {
    public static String solution(String[] participant, String[] completion) {
        String answer = "";

        HashMap<String, Integer> participantMap = new HashMap<>();

        //초기 세팅
        for(String p : participant) {
            participantMap.put(p, participantMap.containsKey(p) ? participantMap.get(p) + 1 : 1);
        }

        for(String c : completion){
            participantMap.put(c, participantMap.get(c) - 1);
        }

        for(String key : participantMap.keySet()) {
            int val = participantMap.get(key);
            if(val > 0){
                answer = key;
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
