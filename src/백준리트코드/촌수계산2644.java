package 백준리트코드;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 촌수계산2644 {

    final static int MAX = 100 + 10;
    static int n, m;
    static int p1, p2;
    static boolean[][] graph;
    static boolean[] visited;
    static int result = -1;

    static void dfs(int node, int depth) {
        visited[node] = true;

        if (node == p2) {
            result = depth;
            return;
        }

        for(int i=1; i<=n; i++) {
            if(!visited[i] && graph[node][i]) {
                dfs(i, depth+1);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        p1 = Integer.parseInt(st.nextToken());
        p2 = Integer.parseInt(st.nextToken());

        m = Integer.parseInt(br.readLine());

        graph = new boolean[MAX][MAX];
        visited = new boolean[MAX];

        //그래프 생성
        int x, y;
        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());

            graph[x][y] = true;
            graph[y][x] = true;
        }

        dfs(p1, 0);
        System.out.println(result);

    }
}
