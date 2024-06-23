package 나의풀이;

import java.util.Arrays;

/*
   searchBinary는 이진검색을 하기 위한 메소드 Arrays.sort와 함꼐 사용하면 좋다.
* */
public class 서울에서김서방찾기 {
    static String solution(String[] seoul) {
        return "김서방은 " + Arrays.asList(seoul).indexOf("Kim") + "에 있다";
    }

    public static void main(String[] args) {
        String[] arr = {"jane", "Kim"};
        System.out.println(solution(arr));
    }
}

