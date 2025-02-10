package 조합;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 이항계수2 {

    public static int[][] pascalTriangle;

    public static void combination(int n, int k){
        for(int i = 0; i <= n; i++){
            //초기 세팅 (파스칼 삼각형 좌측, 우측 1로 세팅)
            pascalTriangle[i][0] = 1;
            pascalTriangle[i][i] = 1;
        }

        //점화식
        for(int i = 1; i <= n; i++){
            for(int j = 1; j < i; j++){
                pascalTriangle[i][j] = (pascalTriangle[i-1][j-1] + pascalTriangle[i-1][j]) % 10007; //모듈러 연산의 특징을 이용(1000! 일 경우 큰 숫자를 담을 수가 없으므로 모듈러 처리)
            }
        }
    }

    public static void main(String[] args) throws Exception {
        //파스칼 삼각형을 이용한 조합수 구하기.
        //1. 초기값을 세팅 가장왼쪽 가장오른쪽 1로 세팅
        //2. 점화식 중간에 값을 구하기 값을 구한 후 10007로 모듈러 연산한 값을 넣기
        //3. n번 줄에 k번째 값을 가져오기

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        pascalTriangle = new int[n+1][n+1];
        combination(n,k);
        System.out.println(Arrays.deepToString(pascalTriangle));
        System.out.println(pascalTriangle[n][k]);
    }
}
