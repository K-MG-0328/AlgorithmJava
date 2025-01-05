package 백준리트코드;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class UniquePaths {
    static int m, n;
    static int[][] memo;

    static int topDown(int row, int col){
        if(row == 0 && col == 0){
            memo[row][col] = 1;
            return memo[row][col];
        }

        if(memo[row][col] != 0){
            return memo[row][col];
        }

        int left=0;
        int top=0;
        if(row > 0) left = topDown(row-1, col);
        if(col > 0) top = topDown(row, col-1);

        memo[row][col] = left + top;
        return memo[row][col];
    }

    static void bottomUp(int row, int col){
        for(int i=1; i<=row; i++){
            for(int j=1; j<=col; j++){
                memo[i][j] = memo[i-1][j] + memo[i][j-1];
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        //topDown
        memo = new int[101][101];
        System.out.println(topDown(m-1, n-1));

        //bottomUp
        memo = new int[101][101];
        for(int i = 0; i < m; i++){
            memo[i][0] = 1;
        }
        for(int i = 0; i < n; i++){
            memo[0][i] = 1;
        }
        bottomUp(m-1, n-1);
        System.out.println(memo[m-1][n-1]);

        br.close();
    }
}
