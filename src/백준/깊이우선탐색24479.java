package 백준;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class 깊이우선탐색24479 {
    static final int MAX = 1000000 + 10;
    static int N, M, R;
    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    static int[] answer;
    static int cnt;

    static void dfs(int node){
        visited[node] = true;
        answer[cnt++] = node;

        for(int i=0; i<graph[node].size(); i++){
            int afterNode = graph[node].get(i);
            if(!visited[afterNode]){
                dfs(afterNode);
            }
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        graph = new ArrayList[MAX];
        for(int i = 1; i <= N; i++){
            graph[i] = new ArrayList<>();
        }
        visited = new boolean[MAX];
        answer = new int[MAX];
        cnt = 1;

        int u, v;
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            u = Integer.parseInt(st.nextToken());
            v = Integer.parseInt(st.nextToken());

            graph[u].add(v);
            graph[v].add(u);
        }

        for(int i=1; i<=N; i++){
            Collections.sort(graph[i]);
        }

        dfs(R);

        for(int i=1; i<=N; i++){
            bw.write(answer[i] + "\n");
        }

        br.close();
        bw.close();
    }
}
