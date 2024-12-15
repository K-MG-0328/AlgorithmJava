package 백준;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 트리의부모찾기11725 {

    static final int MAX = 100000 + 10;
    static int N;
    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    static int[] answer;

    public static void dfs(int pNode) {
        visited[pNode] = true;
        for(int i=0; i<graph[pNode].size(); i++) {
            int cNode = graph[pNode].get(i);
            if (!visited[cNode]) {
                answer[cNode] = pNode;
                dfs(cNode);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        //입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++)
            graph[i] = new ArrayList<Integer>();
        visited = new boolean[N + 1];
        answer = new int[N + 1];

        //그래프 값 채우기
        int n1, n2;
        for(int i = 0; i < N-1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n1 = Integer.parseInt(st.nextToken());
            n2 = Integer.parseInt(st.nextToken());

            graph[n1].add(n2);
            graph[n2].add(n1);
        }

        dfs(1);

        for(int i = 2; i <= N; i++) {
            bw.write(String.valueOf(answer[i]));
            bw.newLine();
        }

        bw.close();
        br.close();
    }
}
