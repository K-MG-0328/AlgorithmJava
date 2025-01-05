package 프로그래머스;

import java.util.HashMap;
import java.util.Map;
/*
* 아쉬웠던점
* map을 사용해서 이중반복문을 사용안하고 시간복잡도를 2n으로 가져가는 방법은 좋았으나
* 0~9까지 더한 45 값을 미리 준비하고 거기서 배열에 값을 한번의 반복으로 차감했으면 n의 시간복잡도로 풀 수 있었던 점이 아쉬웠다.
* */
public class 없는숫자더하기 {
    static int solution(int[] numbers) {
        Map<Integer, Integer> map = new HashMap();

        for(int i : numbers) map.put(i, i);

        int sum = 0;
        for(int i=0;i<10;i++) if(map.getOrDefault(i, -1) == -1) sum+= i;

        return sum;
    }

    public static void main(String[] args) {
        int[] numbers = {1,2,3,4,6,7,8,0};
        System.out.println(solution(numbers));
    }
}
