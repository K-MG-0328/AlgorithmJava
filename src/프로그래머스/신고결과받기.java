package 프로그래머스;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class 신고결과받기 {
    public static int[] solution(String[] id_list, String[] reports, int k) {
        int[] resultArr = new int[id_list.length];
        Map<String, HashMap<String, Void>> reportMap = new LinkedHashMap<>();
        Map<String, Integer> indexMap = new HashMap<>();

        for (int i = 0; i < id_list.length; i++) {
            reportMap.put(id_list[i], new HashMap<>());
            indexMap.put(id_list[i], i);
        }

        for (String report : reports) {
            String[] relation = report.split(" ");
            reportMap.get(relation[1]).put(relation[0], null);
        }

        for(String id : reportMap.keySet()) {
            if(reportMap.get(id).size() >= k) {
                for(String reporter : reportMap.get(id).keySet()){
                    resultArr[indexMap.get(reporter)]++;
                }
            }
        }

        return resultArr;
    }

    public static void main(String[] args) {
        String[] id_list = {"con", "ryan"};
        String[] reports = {"ryan con", "ryan con", "ryan con", "ryan con"};
        int k = 3;
        System.out.println(Arrays.toString(solution(id_list, reports, k)));
    }
}
