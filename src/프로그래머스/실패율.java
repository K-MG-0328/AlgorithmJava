package 프로그래머스;

import java.util.Arrays;
import java.util.Comparator;

public class 실패율 {
    public static int[] solution(int N, int[] stages) {

        int[] stageCnt = new int[N+1];
        for(int i : stages){
            stageCnt[i-1]++;
        }

        int arriveCnt = 0;
        double[][] failPerArr = new double[N][2];
        for(int i = stageCnt.length - 1; i >= 0; i--){
            if(i == N){
                arriveCnt += stageCnt[i];
                continue;
            }
            arriveCnt += stageCnt[i];
            double failPer =  (double)stageCnt[i]/arriveCnt;
            if(Double.isNaN(failPer)){
                failPer = 0;
            }
            //System.out.println(stageCnt[i] + " " + arriveCnt + " " + failPer);
            failPerArr[i][0] = i;
            failPerArr[i][1] = failPer;
        }

        Arrays.sort(failPerArr, new Comparator<double[]>() {
            @Override
            public int compare(double[] o1, double[] o2) {
                if (o1[1] != o2[1]) {
                    return Double.compare(o2[1], o1[1]); // 내림차순
                } else {
                    return Double.compare(o1[0], o2[0]); // 오름차순
                }
//                boolean o1IsNaN = Double.isNaN(o1[1]);
//                boolean o2IsNaN = Double.isNaN(o2[1]);
//
//                if (o1IsNaN && !o2IsNaN) {
//                    return 1; // o1이 NaN이고 o2가 NaN이 아닐 경우 o1을 뒤로 보냄
//                } else if (!o1IsNaN && o2IsNaN) {
//                    return -1; // o1이 NaN이 아니고 o2가 NaN일 경우 o2를 뒤로 보냄
//                } else if (o1IsNaN && o2IsNaN) {
//                    return 0; // 둘 다 NaN인 경우 순서 유지
//                } else {
//                    // NaN이 아닐 경우 기존 정렬 로직 사용
//                    if (o1[1] != o2[1]) {
//                        return Double.compare(o2[1], o1[1]); // 내림차순
//                    } else {
//                        return Double.compare(o1[0], o2[0]); // 오름차순
//                    }
//                }
            }
        });

        int[] answer = new int[N];
        for(int i = 0; i < N; i++){
            answer[i] = (int)failPerArr[i][0] + 1;
        }

        return answer;
    }

    public static void main(String[] args) {
        int N = 5;
        int[] stages = {1, 1, 1, 2, 3, 4};
        System.out.println(Arrays.toString(solution(N, stages)));
    }
}


/*
      //순서를 보장해야할 때는 왠만하면 map을 사용하지말자,, 삽질의 흔적
    public static int[] solution(int N, int[] stages) {
        Map<Integer, Integer> arriveMap = new HashMap<>();
        Map<Integer, Integer> notClearMap = new HashMap<>();
        Arrays.sort(stages);
        for (int i = stages.length -1; i >=0; i--){
            if (stages[i] == N+1) {
                arriveMap.put(stages[i], arriveMap.getOrDefault(stages[i], 0) + 1);
                continue;
            }
            arriveMap.put(stages[i], arriveMap.getOrDefault(stages[i], arriveMap.getOrDefault(stages[i]+1, 0)) + 1);
            notClearMap.put(stages[i], notClearMap.getOrDefault(stages[i], 0) + 1);
        }
        Map<Integer, Double> failPercent = new HashMap<>();
        for(int i = 1; i<=N; i++){
            double failPer = (double)notClearMap.getOrDefault(i, 0) / (double)arriveMap.getOrDefault(i, 1);
            failPercent.put(i, failPer);
        }

        List<Integer> list = new ArrayList<>(failPercent.keySet());
        list.sort((o1, o2) -> Double.compare(failPercent.get(o2), failPercent.get(o1)));
        return list.stream().mapToInt(i -> i).toArray();
* */
