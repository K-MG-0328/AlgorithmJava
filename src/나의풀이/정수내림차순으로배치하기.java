package 나의풀이;

/*아쉬웠던점
  이중반복문(버블정렬) n^2의 시간복잡도를 가져간게 많이 아쉬웠고,
  Arrays.sort를 사용했다면 nlogn의 시간복잡도를 가져갈 수 있었을텐데 그 부분이 아쉬움.

  그리고 n을 String으로 변환할 때 Long.toString()을 사용하는 것보다 String.valueof()를 사용하는게 유연성이나 일관성에서 더 좋았을 것으로 보인다.
* */

public class 정수내림차순으로배치하기 {
    static long solution(long n) {
        String s = Long.toString(n);
        StringBuilder sb = new StringBuilder(s);
        char[] charArray = sb.toString().toCharArray();
        sb.setLength(0);
        char temp;
        for(int i=0;i<charArray.length;i++){
            temp = charArray[i];
            for(int j=i+1;j<charArray.length;j++) {
                if(temp<charArray[j]){
                    temp = charArray[j];
                    charArray[j] = charArray[i];
                    charArray[i] = temp;
                }
            }
        }
        return Long.parseLong(new String(charArray));
    }

    public static void main(String[] args) {
        long n = 118372;
        System.out.println(solution(n));
    }
}
