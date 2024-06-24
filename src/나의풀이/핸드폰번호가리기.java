package 나의풀이;

public class 핸드폰번호가리기 {
    static String solution(String phone_number) {
        String num = phone_number.substring(phone_number.length()-4, phone_number.length());
        String star = phone_number.substring(0, phone_number.length()-4);
        phone_number = star.replaceAll("[0-9]", "*") + num;

        return phone_number;
    }

    public static void main(String[] args) {
        String phone_number = "01033334444";
        System.out.println(solution(phone_number));
    }
}
