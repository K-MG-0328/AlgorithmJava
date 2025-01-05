package 백준리트코드;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 유기농배추1012 {
    //0부터 시작하지 않고 1부터 시작하는 것과 max에 여유값을 세팅하면서 경계값 테스트에서 자유로울 수 있구나,,

    static final int MAX = 50+10;
    static int testCase;
    static int M, N, K;
    static boolean[][] graph;
    static int answer;
    static int result[];
    static int xArr[] = {-1,1,0,0};
    static int yArr[] = {0,0,-1,1};

    public static void main(String[] args) throws IOException {

        //입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        testCase = Integer.parseInt(br.readLine());
        result = new int[testCase+1];

        for(int i=1; i<=testCase; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken()); //x
            N = Integer.parseInt(st.nextToken()); //y
            K = Integer.parseInt(st.nextToken());

            //그래프 생성
            graph = new boolean[MAX][MAX];
            answer = 0;

            int x, y;
            for (int j = 1; j <= K; j++) {
                st = new StringTokenizer(br.readLine());
                x = Integer.parseInt(st.nextToken());
                y = Integer.parseInt(st.nextToken());
                graph[y+1][x+1] = true;
            }

            for(int j=1; j<=N; j++) {//y
                for(int k=1; k<=M; k++) {//x
                    if(graph[j][k]) {
                        dfs(j,k);
                        answer++;
                    }
                }
            }
            result[i] = answer;
        }

        for(int i=1; i<result.length; i++) {
            System.out.println(result[i]);
        }
    }

    public static void dfs(int y, int x) {
        if(graph[y][x]) { //x <= M && y <= N &&
            graph[y][x] = false;
            for(int j=0; j<4; j++) {
                dfs(y + yArr[j], x + xArr[j]);
            }
        }
    }
}
