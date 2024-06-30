package 다른사람의풀이;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class 문자열내마음대로정렬하기2 {

    /*첫번 째 풀이*/
    //n번째 순서비교 인자를 앞으로 가져와서 정렬을 처리함 StringBuilder를 썻으면 더 빠른 속도가 가능했을 것으로 보임
    //아이디어가 좋았던 풀이
//    public String[] solution(String[] strings, int n) {
//        String[] answer = {};
//        ArrayList<String> arr = new ArrayList<>();
//        for (int i = 0; i < strings.length; i++) {
//            arr.add("" + strings[i].charAt(n) + strings[i]);
//        }
//        Collections.sort(arr);
//        answer = new String[arr.size()];
//        for (int i = 0; i < arr.size(); i++) {
//            answer[i] = arr.get(i).substring(1, arr.get(i).length());
//        }
//        return answer;
//    }
//

    /*두번 째 풀이*/
    //comparater를 사용하는 방법을 알게된 풀이
    /*
    compare(a, b)가 양수를 반환하면, a가 b보다 뒤에 있어야 합니다.
    compare(a, b)가 음수를 반환하면, a가 b보다 앞에 있어야 합니다.
    compare(a, b)가 0을 반환하면, a와 b는 순서상 동일한 위치에 있어야 합니다.
    * */
//    public String[] solution(String[] strings, int n) {
//        Arrays.sort(strings, new Comparator<String>(){
//            @Override
//            public int compare(String s1, String s2){
//                if(s1.charAt(n) > s2.charAt(n)) return 1;
//                else if(s1.charAt(n) == s2.charAt(n)) return s1.compareTo(s2);
//                else if(s1.charAt(n) < s2.charAt(n)) return -1;
//                else return 0;
//            }
//        });
//        return strings;
//    }

}
