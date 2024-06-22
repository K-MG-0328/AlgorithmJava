package 나의풀이;

/* 아쉬웠던 점
     count 변수를 하나만 사용해서 구현할 수 있었는데 생각하지 못한 점
     toUpperCase를 사용해서 소문자 대문자 case를 일일이 쓰지않아도 되었던 점
     람다식을 사용했으면 훨씬 간단했던 점
* */


public class 문자열p와y의개수 {
    static boolean solution(String s) {
        boolean answer;
        int pCnt = 0, yCnt = 0;

        for(char c : s.toCharArray()){
            switch (c){
                case 'p':
                case 'P':
                    pCnt++;
                    break;
                case 'y':
                case 'Y':
                    yCnt++;
                    break;
            }
        }
        if(pCnt == yCnt){
            answer = true;
        }else{
            answer = false;
        }
        return answer;
    }

    public static void main(String[] args) {
        String s = "Pyy";
        System.out.println(solution(s));
    }
}
