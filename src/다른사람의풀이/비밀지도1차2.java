package 다른사람의풀이;

public class 비밀지도1차2 {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] result = new String[n];

        //String.format과 비트연산을 놓치고 있었구나
        //%5s 왼쪽정렬후 5칸까지 부족하면 빈공간으로 채움
        //%-5s 오른쪽정렬후 5칸까지 부족하면 빈공간으로 채움
        //특정문자로 바꾸고싶으면 replaceAll을 사용해야함.
        for (int i = 0; i < n; i++) {
            result[i] = String.format("%" + n + "s", result[i] = Integer.toBinaryString(arr1[i] | arr2[i]));
            result[i] = result[i].replaceAll("1", "#");
            result[i] = result[i].replaceAll("0", " ");
        }
        return result;
    }
}

