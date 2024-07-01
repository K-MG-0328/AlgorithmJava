package 나의풀이;

import java.time.LocalDate;

public class 이공일육년 {
    public static String solution(int a, int b) {
      /*  String date = "2016" + String.format("%02d" , a) +  String.format("%02d" , b);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        LocalDate localDate = LocalDate.parse(date, formatter);*/
        LocalDate localDate = LocalDate.of(2016, a, b);
        String weekDay = localDate.getDayOfWeek().toString();
        return weekDay.substring(0,3);
    }

    public static void main(String[] args) {
        int a = 5 , b = 24;
        System.out.println(solution(a, b));
    }
}
