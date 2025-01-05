package 프로그래머스;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

public class 문자열내마음대로정렬하기 {
    public static String[] solution(String[] strings, int n) {

        Map<Character, ArrayList<String>> map = new TreeMap<>();

        for(String s : strings) {
            map.putIfAbsent(s.charAt(n), new ArrayList<>());
            map.get(s.charAt(n)).add(s);
        }

        ArrayList<String> tempList;
        int count=0;
        //이미 treeMap에서 정렬이 되어있으므로 list만 정렬하고 배열에 담으면 됨.
        for (char c : map.keySet()) {
            tempList = map.get(c);
            tempList.sort(String::compareTo);
            for (String s : tempList) {
                strings[count] = s;
                count++;
            }
        }
        return strings;
    }

    public static void main(String[] args) {
        String[] strings = {"abce", "abcd", "cdx"};
        int n = 2;
        System.out.println(Arrays.toString(solution(strings, n)));
    }
}
