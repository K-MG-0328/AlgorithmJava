package 백준리트코드;

import java.io.*;
import java.util.StringTokenizer;

public class 바이러스2606 {
    static boolean[][] graph;
    static boolean[] visited;
    static int N, M;
    static int answer;

    public static void dfs(int node) {
        visited[node] = true;
        answer++;

        for(int i=1; i<=N; i++){
            if(graph[node][i] == true && visited[i] == false){
                dfs(i);
            }
        }
    }

    public static void main(String[] args) throws IOException {

        //입력 및 초기화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine()); //컴퓨터의 수
        M = Integer.parseInt(br.readLine()); //간선의 수

        graph = new boolean[N+1][N+1];
        visited = new boolean[N+1];

        //graph에 연결 정보 채우기
        int x, y;
        for(int i=0; i<M; i++){
            //2개의 숫자가 한 줄에 들어오므로 StringTokenizer를 사용해야한다.
            //readLine은 입력받은 값을 한 줄로 반환하기 때문에 StringTokenizer를 통해 한 줄로 입력받은 값을 띄어쓰기 기준으로 나눠준다.
            StringTokenizer st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());

            graph[x][y] = true;
            graph[y][x] = true;
        }

        //dfs 호출
        dfs(1);

        //출력
        bw.write(String.valueOf(answer-1));

        br.close();
        bw.close();
    }
}
