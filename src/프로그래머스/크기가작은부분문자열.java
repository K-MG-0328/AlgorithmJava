package 프로그래머스;

public class 크기가작은부분문자열 {
    // 문제의 제한사항에  1 ≤ p의 길이 ≤ 18 인데 Integer.parseInt를 사용해서 하다보니 몇가지 테스트케이스에서 런타임오류나는 건들이 발생
    // long형으로 바꾸니깐 해결이 되었음 제한사항도 잘 읽어보는게 도움이 될 것 같다.
    // int형은 범위: -2,147,483,648부터 2,147,483,647까지 자리수: 최대 10자리 숫자 (음수일 경우 부호를 포함하면 11자리)
    // long (64비트 정수형):범위: -9,223,372,036,854,775,808부터 9,223,372,036,854,775,807까지 자리수: 최대 19자리 숫자 (음수일 경우 부호를 포함하면 20자리)
    public static int solution(String t, String p) {
        int pLen = p.length();
        int tLen = t.length() - pLen;
        int cnt=0;
        if(tLen < 0) return 0;
        for(int i = 0; i <= tLen; i++){
            if(Long.parseLong(p) >= Long.parseLong(t.substring(i, i+pLen))){
                cnt++;
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        String t = "10302";
        String p = "15";
        System.out.println(solution(t, p));
    }
}
