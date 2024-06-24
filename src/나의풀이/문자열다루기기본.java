package 나의풀이;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class 문자열다루기기본 {
    static boolean solution(String s) {
        if(!(s.length() == 4 || s.length() == 6)) return false;
        String regex = "[a-zA-Z]";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(s);
        return !matcher.find();
    }

    public static void main(String[] args) {
        String s = "1234";
        System.out.println(solution(s));
    }
}
