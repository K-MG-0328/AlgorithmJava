package 기업코테문제;

public class 카카오2020코딩테스트1 {

    static int answer = Integer.MAX_VALUE;

    public static int solution(String s) {
        int len = s.length();
        // 길이 1인 문자열은 압축해도 그대로이므로 바로 처리 가능
        if (len == 1) {
            answer = 1;
            return answer;
        }

        // i는 "압축 단위" (1개 ~ len/2 개)
        for (int i = 1; i <= len / 2; i++) {
            StringBuilder sb = new StringBuilder();
            // 초기 비교 덩어리 설정
            String prevWord = s.substring(0, i);
            int count = 1;

            // i씩 증가하며 덩어리를 하나씩 확인
            int j;
            for (j = i; j + i <= len; j += i) { // 아 애초에 여기다가 넣어버렸구나 대박.. 이러면 넘어가지가 않네
                // 현재 덩어리 추출
                String currWord = s.substring(j, j + i);
                if (prevWord.equals(currWord)) {
                    // 이전 덩어리와 동일하다면 카운트 증가
                    count++;
                } else {
                    // 다르면 이전 덩어리를 압축 결과에 추가
                    if (count > 1) {
                        sb.append(count).append(prevWord);
                    } else {
                        sb.append(prevWord);
                    }
                    // 새 덩어리로 갱신
                    prevWord = currWord;
                    count = 1;
                }
            }

            // 루프가 끝난 뒤, 마지막으로 사용한 prevWord 처리
            if (count > 1) {
                sb.append(count).append(prevWord);
            } else {
                sb.append(prevWord);
            }

            // j가 len보다 작으면, 남은 문자열이 있다는 뜻
            // 예: (전체 길이 15, i=4) → j가 12에서 끝났다면, s.substring(12,15) 남음
            if (j < len) {
                sb.append(s.substring(j, len));
            }

            // 현재 압축된 문자열 길이 확인
            int compressedLen = sb.length();
            answer = Math.min(answer, compressedLen);
        }

        return answer;

        // 만약 압축 단위가 1부터 len/2까지 하나도 없어서 변경이 안 된 경우
        // 이 문제는 i <= len/2 가 기본 범위이므로, 이미 최소값이 정해졌을 것입니다.

        // 길이 전체 그대로 쓰는 경우(압축 효과 없음)도 비교하려면:
        // answer = Math.min(answer, len);
    }

    public static void main(String[] args) {
        String s = "ababcdcdababcdcd";
        solution(s);
        System.out.println(solution(s));
    }
}
