package 나의풀이;

import java.util.Arrays;

public class 나누어떨어지는숫자배열 {
    static int[] solution(int[] arr, int divisor) {
        /*
        Stream에서 중간 함수인 map은 스트림 API에서 스트림의 각 요소를 변환하는 데 사용된다.
        IntStream을 사용해도 되지만 IntStream을 사용할 경우 map중간 함수로 한번 더 거쳐야하기 때문에 Arrays.Stream을 사용하는게 더 좋아보인다.
        * */
        //Arrays.sort(arr);
        //      int[] result = IntStream.range(0, arr.length).filter(i -> arr[i]%divisor == 0).map(i->arr[i]).toArray();
        int[] result = Arrays.stream(arr).filter(i->i%divisor == 0).toArray();
        if(result.length == 0) result = new int[]{-1};
        //** 정렬을 앞쪽에다가 하는 것보다 새로운 배열에서는 값을 걸러내고 정렬하기 때문에 정렬을 뒤에다 하는게 더 좋다.
        Arrays.sort(arr);

        return result;
    }

    public static void main(String[] args) {
        int[] arr = {3,2,6};
        int divisor = 10;
        System.out.println(solution(arr, divisor));
    }
}
