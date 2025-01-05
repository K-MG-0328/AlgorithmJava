package 프로그래머스;

public class 키패드누르기 {
    public static String solution(int[] numbers, String hand) {
        String answer = "";
        int left = 10;
        int right = 12;

        for (int i : numbers) {
            if (i == 1 || i == 4 || i == 7) {
                answer += "L";
                left = i;
            } else if (i == 3 || i == 6 || i == 9) {
                answer += "R";
                right = i;
            }else{
                if(i==0) i=11;
                int leftDistance = Math.abs(left-i)/3 + Math.abs(left-i)%3;
                int rightDistance = Math.abs(right-i)/3 + Math.abs(right-i)%3;

                if(leftDistance == rightDistance){
                    if(hand.equals("right")){
                        answer += "R";
                        right = i;
                    }else if(hand.equals("left")){
                        answer += "L";
                        left = i;
                    }
                }else if(leftDistance < rightDistance){
                    answer += "L";
                    left = i;
                }else if(leftDistance > rightDistance){
                    answer += "R";
                    right = i;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] numbers = {1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5};
        String hand = "right";
        System.out.println(solution(numbers, hand));
    }
}
