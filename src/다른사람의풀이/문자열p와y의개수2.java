package 다른사람의풀이;

public class 문자열p와y의개수2 {
    boolean solution(String s) {
        s = s.toUpperCase();
        return s.chars().filter( e -> 'P'== e).count() == s.chars().filter( e -> 'Y'== e).count();
    }
}
