package 난이도높았던문제.다른사람의풀이;

public class 시저암호 {
    public static String solution(String s, int n) {
        char[] chars = s.toCharArray();
        String result = "";
        n=n%26;
        for(char c : chars){
            if(Character.isLowerCase(c)){
                c = (char)((c -'a' + n)%26 + 'a');
            }else if(Character.isUpperCase(c)){
                c = (char)((c - 'A' + n)%26 + 'A');
            }
            result += c;
        }
        return result;
    }

    public static void main(String[] args) {

        String s = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        int n = 25;
        System.out.println(solution(s, n));
    }
}
