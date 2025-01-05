package 프로그래머스;

import java.util.Arrays;

public class 바탕화면정리 {
    public static int[] solution(String[] wallpaper) {
        /*Integer.MAX_VALUE, Integer.MIN_VALUE 이런게 있는지 몰랐네,, */
        int minX = Integer.MAX_VALUE;
        int minY = Integer.MAX_VALUE;
        int maxX = Integer.MIN_VALUE;
        int maxY = Integer.MIN_VALUE;

        for (int i = 0; i < wallpaper.length; i++) {
            for (int j = 0; j < wallpaper[i].length(); j++) {
                if(wallpaper[i].charAt(j) == '#'){
                    minX = Math.min(minX, i);
                    minY = Math.min(minY, j);
                    maxX = Math.max(maxX, i+1);
                    maxY = Math.max(maxY, j+1);
                }
            }
        }
        int[] answer = {minX, minY, maxX, maxY};
        return answer;
    }

    public static void main(String[] args) {
        String[] wallpaper = {".#...", "..#..", "...#."};
        System.out.println(Arrays.toString(solution(wallpaper)));
    }
}
