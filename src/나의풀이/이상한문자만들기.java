package 나의풀이;

public class 이상한문자만들기 {
    public static String solution(String s) {

        char[] chars = s.toCharArray();
        /*  String[] arr = s.split("");
          System.out.println(Arrays.toString(chars));
          System.out.println(Arrays.toString(arr));*/
        int cnt=0;
        for(int i=0;i<chars.length;i++) {
            if(chars[i] == ' '){
                cnt=0;
                continue;
            }
            chars[i] = cnt%2==0 ? Character.toUpperCase(chars[i]) : Character.toLowerCase(chars[i]);
            cnt++;
        }
        return String.valueOf(chars);


    }

    public static void main(String[] args) {
        String s = " try  hello world   ";
        System.out.println(solution(s));
    }
}
