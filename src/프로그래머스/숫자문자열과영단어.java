package 프로그래머스;

import java.util.HashMap;
import java.util.Map;

public class 숫자문자열과영단어 {
    public static int solution(String s) {
        Map<String, Integer> map = new HashMap<>();
        map.put("zero", 0);
        map.put("one", 1);
        map.put("two", 2);
        map.put("three", 3);
        map.put("four", 4);
        map.put("five", 5);
        map.put("six", 6);
        map.put("seven", 7);
        map.put("eight", 8);
        map.put("nine", 9);

        char[] chars = s.toCharArray();
        String temp = "";
        String result = "";
        for (char c : chars) {
            temp += c;
            if(Character.isDigit(c) == true){
                result+=temp;
                temp = "";
            }else if (map.containsKey(temp)) {
                result += map.get(temp);
                temp = "";
            }
        }
        return Integer.parseInt(result);

        /*다른사람의 풀이*/
        /*배열에 집어넣어 replaceAll을 사용하면 훨씬 더 간결하게 코드를 짤 수 있었구나,,*/
//        String[] strArr = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
//        for(int i = 0; i < strArr.length; i++) {
//            s = s.replaceAll(strArr[i], Integer.toString(i));
//        }
//        return Integer.parseInt(s);
    }

    public static void main(String[] args) {

        String s = "123";
        //1478
        System.out.println(solution(s));
    }
}
