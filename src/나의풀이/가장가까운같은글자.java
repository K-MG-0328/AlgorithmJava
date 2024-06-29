package 나의풀이;

import java.util.HashMap;
import java.util.Map;

public class 가장가까운같은글자 {
    public static int[] solution(String s) {

        char[] chars = s.toCharArray();
        int[] result = new int[chars.length];
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < chars.length; i++) {
            if (!map.containsKey(chars[i])) {
                result[i] = -1;
                map.put(chars[i], i);
            }else{
                result[i] = i - map.get(chars[i]);
                map.put(chars[i], i);
            }
        }
        //다른사람의 풀이 더 간단하게 할 수 있었구나,,
//        for(int i=0; i<s.length();i++){
//            char ch = s.charAt(i);
//            answer[i] = i-map.getOrDefault(ch,i+1);
//            map.put(ch,i);
//        }
        return result;
    }

    public static void main(String[] args) {

        String s = "banana";
        System.out.println(solution(s));
    }
}
