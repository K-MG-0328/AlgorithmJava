package 프로그래머스;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class 데이터분석 {
    public static ArrayList<int[]> solution(int[][] data, String ext, int val_ext, String sort_by) {

        Map<String, Integer> dataTyep = new HashMap<>(){{
            put("code", 0);
            put("date", 1);
            put("maximum", 2);
            put("remain", 3);
        }};

        ArrayList<int[]> list = new ArrayList<>();

        for (int i = 0; i < data.length; i++) {
            if(val_ext > data[i][dataTyep.get(ext)]){
                list.add(data[i]);
            }
        }

        list.sort(Comparator.comparingInt(a -> a[dataTyep.get(sort_by)]));
        return list;
    }

    public static void main(String[] args) {
        int[][] data = {{1, 20300104, 100, 80}, {2, 20300804, 847, 37}, {3, 20300401, 10, 8}};
        String ext = "date";
        int val_ext = 20300501;
        String sort_by = "remain";
        System.out.println(solution(data, ext, val_ext, sort_by));
    }
}
