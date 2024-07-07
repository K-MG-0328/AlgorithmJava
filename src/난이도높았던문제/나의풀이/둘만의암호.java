package 난이도높았던문제.나의풀이;

public class 둘만의암호 {
    public static String solution(String s, String skip, int index) {

        String alpah = "abcdefghijklmnopqrstuvwxyz";

        for(char c : skip.toCharArray()) {
            alpah = alpah.replace(String.valueOf(c), "");
        }

        String answer = "";

        for(int c : s.toCharArray()) {
            int num = (alpah.indexOf(c) + index) % alpah.length();
            answer += alpah.charAt(num);
        }
        return answer;
    }

    public static void main(String[] args) {
        String s = "aukks";
        String skip = "wbqd";
        int index = 5;
        System.out.println(solution(s, skip, index));
    }
}
