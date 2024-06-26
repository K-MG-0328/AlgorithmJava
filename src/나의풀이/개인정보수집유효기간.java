package 나의풀이;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class 개인정보수집유효기간 {
    public static int[] solution(String today, String[] terms, String[] privacies) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd");
        LocalDate curDate = LocalDate.parse(today, formatter);
        Map<String, Integer> termsMap = new HashMap<>();
        String[] temp;
        for (String term : terms) {
            temp = term.split(" ");
            termsMap.put(temp[0] , Integer.parseInt(temp[1]));
        }
        List<Integer> resultList = new ArrayList();
        for(int i=0; i<privacies.length; i++) {
            temp = privacies[i].split(" ");
            LocalDate collectionDate = LocalDate.parse(temp[0], formatter);
            collectionDate = collectionDate.plusMonths(termsMap.get(temp[1]));
            if(!collectionDate.isAfter(curDate)){
                resultList.add(i+1);
            }
        }
        int[] answer = resultList.stream().mapToInt(Integer::intValue).toArray();
        return answer;
    }

    public static void main(String[] args) {
        String today = "2022.05.19";
        String[] terms = {"A 6", "B 12", "C 3"};
        String[] privacies= {"2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C"};

  /*      String today = "2020.01.01";
        String[] terms = {"Z 3", "D 5"};
        String[] privacies= {"2019.01.01 D", "2019.11.15 Z", "2019.08.02 D", "2019.07.01 D", "2018.12.28 Z"};*/

        //예상 답 1, 3
        System.out.println(Arrays.toString(solution(today, terms, privacies)));
    }
}
