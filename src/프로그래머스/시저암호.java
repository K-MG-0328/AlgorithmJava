package 프로그래머스;

public class 시저암호 {
    public String solution(String s, int n) {
        char[] chars = s.toCharArray();
        String result = "";
        for(char c : chars){
            int asc = (int)c;
            if(97 <= asc && asc <= 122){
                if((c+n)-122 > 0){
                    result += (char)((c+n)-122 + 96);
                    continue;
                }
            }else if(65 <= asc && asc <= 90){
                if((c+n)-90 > 0){
                    result += (char)((c+n)-90 + 64);
                    continue;
                }
            }
            result += c==' '? c : (char)(c+n);
        }
        return result;
    }
}
