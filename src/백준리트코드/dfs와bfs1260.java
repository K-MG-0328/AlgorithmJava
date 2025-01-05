package 백준리트코드;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class dfs와bfs1260 {

    static int MAX = 1000 + 10;
    static int N, M, V;
    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    static int[] answer;
    static int cnt;
    static ArrayList<Integer> queue;

    static void dfs(int node){
        visited[node] = true;
        answer[cnt++] = node;
        System.out.print(node + " ");
        for(int i = 0; i < graph[node].size(); i++) {
            if(!visited[graph[node].get(i)]) {
                dfs(graph[node].get(i));
            }
        }
    }

    static void bfs(int node){
        queue.add(node);
        visited[node] = true;

        while(!queue.isEmpty()) {
            int curNode = queue.remove(0);
            System.out.print(curNode + " ");
            for(int i=0; i<graph[curNode].size(); i++) {
                int nextNode = graph[curNode].get(i);
                if(!visited[nextNode]) {
                    queue.add(nextNode);
                    visited[nextNode] = true;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {

        /* 입출력 */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        graph = new ArrayList[MAX];
        for(int i=1; i<=N; i++) graph[i] = new ArrayList<>();

        visited = new boolean[MAX];
        answer = new int[MAX];

        /* 그래프 생성 */
        int x, y;
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());

            graph[x].add(y);
            graph[y].add(x);
        }

        /*그래프 정렬*/
        for(int i=1; i<=N; i++){
            Collections.sort(graph[i]);
        }


        cnt = 1;
        dfs(V);

        visited = new boolean[MAX];
        answer = new int[MAX];
        queue = new ArrayList<>();

        cnt = 1;
        bfs(V);

    }
}
