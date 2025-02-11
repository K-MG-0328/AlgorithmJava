package 백준리트코드;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class DFS와BFS {

    public static int N, M, V;
    public static Map<Integer, ArrayList<Integer>> mInfo;
    public static boolean[] visited;
    public static Queue<Integer> q;

    public static void bfs(int n){
        q.add(n);
        while(!q.isEmpty()){
            int node = q.poll();
            System.out.print(node + " ");
            ArrayList<Integer> info = mInfo.get(node);

            for(int i=0; i<info.size(); i++){
                int qNode = info.get(i);
                if(!visited[qNode]){
                    visited[qNode] = true;
                    q.add(qNode);
                }
            }
        }

    }

    public static void dfs(int n){
        System.out.print(n + " ");
        ArrayList<Integer> info = mInfo.get(n);

        if(!info.isEmpty()){
            for(int i=0; i<info.size(); i++){
                int nextNode = info.get(i);
                if(!visited[nextNode]){
                    visited[nextNode] = true;
                    dfs(nextNode);
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        //초기 세팅
        mInfo = new HashMap<Integer, ArrayList<Integer>>();
        q = new LinkedList<>();

        for(int i =1; i<=N; i++){
            mInfo.put(i, new ArrayList<Integer>());
        }

        for(int i =1; i<=M; i++){
            st = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());
            mInfo.get(node1).add(node2);
            mInfo.get(node2).add(node1);
        }

        /*그래프 정렬*/
        for(int i=1; i<=N; i++){
            Collections.sort(mInfo.get(i));
        }

        //dfs
        visited = new boolean[N+1]; //1-based
        visited[V] = true;
        dfs(V);

        System.out.println(); //줄바꿈

        //bfs
        visited = new boolean[N+1]; //초기화
        visited[V] = true;
        bfs(V);
    }
}
