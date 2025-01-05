package 백준리트코드;

import java.io.*;
import java.util.StringTokenizer;

public class 연결요소의개수11724 {
    static boolean[][] graph;
    static boolean[] visited;
    static int N, M;
    static int answer;

    public static void dfs(int node) {
        visited[node] = true;

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

        //2개의 숫자가 한 줄에 들어오므로 StringTokenizer를 사용해야한다.
        //readLine은 입력받은 값을 한 줄로 반환하기 때문에 StringTokenizer를 통해 한 줄로 입력받은 값을 띄어쓰기 기준으로 나눠준다.
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); //컴퓨터의 수
        M = Integer.parseInt(st.nextToken()); //간선의 수

        graph = new boolean[N+1][N+1];
        visited = new boolean[N+1];

        //graph에 연결 정보 채우기
        int u, v;
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            u = Integer.parseInt(st.nextToken());
            v = Integer.parseInt(st.nextToken());

            graph[u][v] = true;
            graph[v][u] = true;
        }

        //dfs 호출
        for(int i=1; i<=N; i++) {
            if(visited[i] == false) {
                dfs(i);
                answer++;
            }
        }

        //출력
        bw.write(String.valueOf(answer));

        br.close();
        bw.close();
    }
}
