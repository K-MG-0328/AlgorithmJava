package 백준;

import java.io.*;
import java.util.StringTokenizer;

public class 바닥장식1388 {
    static final int MAX = 50 + 10;
    static int N,M;
    static char[][] map;
    static int answer = 0;

    private static void dfs(int y, int x) {
        char cur = map[y][x];
        map[y][x] = 0;
        if(cur == '-' && map[y][x+1] == '-'){
            dfs(y, x+1);
        }else if(cur == '|' && map[y+1][x] == '|'){
            dfs(y+1, x);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        //맵 생성
        map = new char[MAX][MAX];
        for(int i = 0; i < N; i++) {
            String line = br.readLine();
            for(int j = 0; j < M; j++) {
                map[i][j] = line.charAt(j);
            }
        }
        //dfs
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(map[i][j] != 0){
                    dfs(i,j);
                    answer++;
                }
            }
        }

        bw.write(answer + "\n");
        bw.close();
        br.close();
    }
}
