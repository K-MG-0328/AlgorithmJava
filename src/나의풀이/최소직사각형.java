package 나의풀이;

public class 최소직사각형 {
    public static int solution(int[][] sizes) {
        int maxWidth=0;
        int maxHeight=0;
        for(int[] size : sizes) {
            int width = Math.max(size[0], size[1]);
            int height = Math.min(size[0], size[1]);

            maxWidth = Math.max(maxWidth, width);
            maxHeight = Math.max(maxHeight, height);
        }
        return maxWidth * maxHeight;
    }

    public static void main(String[] args) {
        //가로길이, 세로길이
        int[][] sizes = {{60, 50}, {30, 70}, {60, 30}, {80, 40}};
        //4000
        System.out.println(solution(sizes));
    }
}
