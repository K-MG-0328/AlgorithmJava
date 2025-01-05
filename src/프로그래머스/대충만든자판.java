package 프로그래머스;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class 대충만든자판 {
    public static int[] solution(String[] keymap, String[] targets) {

        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < keymap.length; i++) {
            for(int j = 0; j < keymap[i].length(); j++) {
                char c = keymap[i].charAt(j);
                if(map.containsKey(c)){
                    map.replace(c, Math.min(map.get(c), j));
                }else{
                    map.put(c, j);
                }
            }
        }
        System.out.println(map.toString());

        int[] answer = new int[targets.length];
        for (int i = 0; i < targets.length; i++) {
            for(char c : targets[i].toCharArray()) {
                if(map.containsKey(c)){
                    answer[i] += map.get(c) + 1;
                }else{
                    answer[i] = -1;
                    break;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        String[] keymap = {"ABC"};
        String[] targets ={"DA"};
        System.out.println(Arrays.toString(solution(keymap, targets)));
    }
}
