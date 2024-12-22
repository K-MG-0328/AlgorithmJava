package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 섬의개수4963 {
    static final int MAX = 50+10;
    static int w, h;
    static int yArr[] = {1,-1,0,0,1,-1,1,-1};
    static int xArr[] = {0,0,1,-1,1,-1,-1,1};
    static boolean[][] map;
    static ArrayList<Integer> answer = new ArrayList<>();

    private static void dfs(int y, int x){
        map[y][x] = false;

        for(int i=0; i<8; i++){
            int nextY = y + yArr[i];
            int nextX = x + xArr[i];
            if(map[nextY][nextX]){
                dfs(nextY, nextX);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true){

            StringTokenizer st = new StringTokenizer(br.readLine());

            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            map = new boolean[MAX][MAX];

            if(w == 0 && h == 0) break;

            for(int i=1; i<=h; i++){
                st = new StringTokenizer(br.readLine());
                for(int j=1; j<=w; j++){
                    map[i][j] = (Integer.parseInt(st.nextToken()) == 1);
                }
            }
            int cnt = 0;
            for(int i=1; i<=h; i++){
                for(int j=1; j<=w; j++){
                    if(map[i][j]){
                        dfs(i,j);
                        cnt++;
                    }
                }
            }
            answer.add(cnt);
        }

        for(int value : answer){
            System.out.println(value);
        }
    }
}
