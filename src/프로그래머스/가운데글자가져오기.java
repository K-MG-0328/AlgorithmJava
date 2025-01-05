package 프로그래머스;

public class 가운데글자가져오기 {
    static String solution(String s) {
        /*다른 사람의 풀이  ** 분기가 필요없었다니,, 이걸 생각한게 대박이네*/
        return s.substring((s.length()-1)/2, s.length()/2 + 1);

        /*내가 푼 풀이
        if(s.length()%2 == 0){
            return s.substring(s.length()/2-1, s.length()/2+1);
        }else{
            return s.substring(s.length()/2 , s.length()/2+1);
        }*/
    }

    public static void main(String[] args) {
        String s = "abccde";
        System.out.println(solution(s));
    }
}
