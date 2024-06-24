package 나의풀이;

import java.util.Arrays;

public class 문자열내림차순으로배치하기 {
    static String solution(String s) {
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        //StringBuilder sb = new StringBuilder();
        //for (int i = 0; i < chars.length; i++) sb.append(chars[i]);
        //s = sb.reverse().toString();

        //new String(chars) 이런식으로 문자배열이  String 생성자에 들어가는구나.

        return new StringBuilder(new String(chars)).reverse().toString();
    }

    public static void main(String[] args) {
        String s = "Zbcdefg";
        System.out.println(solution(s));
    }
}
