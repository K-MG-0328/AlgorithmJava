package 프로그래머스;

public class 부족한금액계산하기 {
    static long solution(int price, int money, int count) {
        /*long sum = 0;
        for (int i = 0; i < count; i++) sum += price * (i+1);
        return sum > money? sum-money:0;*/


        //count * (price + (price * count))/2 - money 등차수열의 합을 이용하면 반복문을 사용안해도됨.
        //Math.max를 사용하면 0보다 큰지 안큰지 비교문을 사용하지않아도됨. 0보다 아래면 돈이 부족하다는 소리이니깐 돈부족하면 0 반환하라했으니까..
        return Math.max((long)count * (price + (price * count))/2 - money, 0);
    }

    public static void main(String[] args) {
        int price = 3;
        int money = 20;
        int count = 4;
        System.out.println(solution(price, money, count));
    }
}
