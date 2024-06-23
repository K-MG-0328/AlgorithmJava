package 나의풀이;

public class 하샤드의수 {
    static boolean solution(int x) {
        return x%String.valueOf(x).chars().map(Character::getNumericValue).sum() == 0;
        //return x%String.valueOf(x).chars().map(c -> Character.getNumericValue(c)).sum() == 0;
    }

    public static void main(String[] args) {
        int n = 12;
        System.out.println(solution(n));
    }
}
