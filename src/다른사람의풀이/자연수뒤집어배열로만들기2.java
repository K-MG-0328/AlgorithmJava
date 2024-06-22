package 다른사람의풀이;

public class 자연수뒤집어배열로만들기2 {
    static int[] solution(long n) {
        return new StringBuilder().append(n).reverse().chars().map(Character::getNumericValue).toArray();
    }

    public static void main(String[] args) {
        long n = 12345;
        System.out.println(solution(n));
    }
}
