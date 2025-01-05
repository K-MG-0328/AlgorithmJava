package 기업코테문제;

public class 카카오2020코딩테스트2 {
    public static boolean correct(String u){
        int left = 0;
        int right = 0;
        for (int i = 0; i < u.length(); i++) {
            if (u.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }
            // 닫는 괄호가 더 많아지면 올바른 괄호 문자열이 아님
            if (right > left) {
                return false;
            }
        }
        return true;
    }

    private static String reverse(String u) {
        StringBuilder sb = new StringBuilder();
        // 첫 번째와 마지막 문자 제거
        for (int i = 1; i < u.length() - 1; i++) {
            // 나머지 문자열의 괄호 방향 뒤집기
            if (u.charAt(i) == '(') {
                sb.append(')');
            } else {
                sb.append('(');
            }
        }
        return sb.toString();
    }

    public static String solution(String p) {

        // 1. 입력이 빈 문자열인 경우, 빈 문자열을 반환합니다.
        if(p.equals("")) return "";

        //2. 문자열 p를 두 "균형잡힌 괄호 문자열" u, v로 분리합니다.
        //단, u는 "균형잡힌 괄호 문자열"로 더 이상 분리할 수 없어야 하며, v는 빈 문자열이 될 수 있습니다.
        String u = "", v = "";

        //균형잡힌 괄호 문자열이란 '(' , ')'가 동일한 쌍을 이루는 것을 말함.
        int openCnt = 0, closeCnt = 0, index = 0; //cnt를 셀 변수를 선언

        for(char c : p.toCharArray()){
            //c를 받았을 때 '(' 인지 ')'인지 비교하는 문이 필요함
            if(c == '(') openCnt++;
            if(c == ')') closeCnt++;
            if(openCnt == closeCnt){
                index = openCnt + closeCnt;
                break;
            }
        }
        u = p.substring(0, index);
        v = p.substring(index, p.length());

//        3. 문자열 u가 "올바른 괄호 문자열" 이라면 문자열 v에 대해 1단계부터 다시 수행합니다.
//        3-1. 수행한 결과 문자열을 u에 이어 붙인 후 반환합니다.
        if(correct(u)){
            return u + solution(v);
        }else{

//        4. 문자열 u가 "올바른 괄호 문자열"이 아니라면 아래 과정을 수행합니다.
//        4-1. 빈 문자열에 첫 번째 문자로 '('를 붙입니다.
//        4-2. 문자열 v에 대해 1단계부터 재귀적으로 수행한 결과 문자열을 이어 붙입니다.
//        4-3. ')'를 다시 붙입니다.
//        4-4. u의 첫 번째와 마지막 문자를 제거하고, 나머지 문자열의 괄호 방향을 뒤집어서 뒤에 붙입니다.
//        4-5. 생성된 문자열을 반환합니다.


            String s = "(" + solution(v) + ")" + reverse(u);
            return s;
        }
    }

    public static void main(String[] args) {
        String s = ")(()";
        System.out.println(solution(s));
    }
}
