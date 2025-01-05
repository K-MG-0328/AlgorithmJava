package 프로그래머스;

import java.util.Arrays;

public class 공원산책 {
    public static int[] solution(String[] park, String[] routes) {

        //row : park[], col : park[].charAt()
        int rowSize = park.length;
        int colSize = park[0].length();
        int curRow=0, curCol=0;
        int nextRow=0, nextCol=0;

        //시작 지점 찾기
        for(int i = 0; i < rowSize; i++){
            if(park[i].indexOf("S") != -1){
                curRow = i;
                curCol = park[i].indexOf("S") ;
                break;
            }
        }

        //방향 찾기
        String direction;
        int distance;
        for(String route : routes){
            String[] routeArr = route.split(" ");
            direction = routeArr[0];
            distance = Integer.parseInt(routeArr[1]);
            boolean bol = true;

            //방해물, 맵 밖인지 확인 후 해당사항 없으면 현재위치로 옮기기
            switch(direction){
                case "E"://동
                    nextCol = curCol + distance;

                    for (int i = curCol + 1; i <= nextCol; i++) {
                        if (nextCol >= colSize || park[curRow].charAt(i) == 'X') {
                            bol = false;
                            break;
                        }
                    }

                    if(bol) curCol = nextCol;
                    break;
                case "W"://서
                    nextCol = curCol - distance;

                    for (int i = curCol - 1; i >= nextCol; i--) {
                        if (nextCol < 0 || park[curRow].charAt(i) == 'X') {
                            bol = false;
                            break;
                        }
                    }

                    if(bol) curCol = nextCol;
                    break;
                case "S"://남
                    nextRow = curRow + distance;

                    for(int i = curRow+1; i <= nextRow; i++){
                        if(nextRow >= rowSize || park[i].charAt(curCol) == 'X' ) {
                            bol=false;
                            break;
                        }
                    }
                    if(bol) curRow = nextRow;
                    break;
                case "N"://북
                    nextRow = curRow - distance;

                    for(int i = curRow-1; i >= nextRow; i--){
                        if(nextRow < 0 ||park[i].charAt(curCol) == 'X' ){
                            bol=false;
                            break;
                        }
                    }
                    if(bol) curRow = nextRow;
                    break;
            }
        }
        int[] answer = {curRow, curCol};
        return answer;
    }

    public static void main(String[] args) {
        String[] park = {"SOO", "OOO", "OOO"};
        String[] routes= {"E 2","S 2","W 1"};
        //예상 답 2, 1
        //	["SOO", "OXX", "OOO"], ["E 2", "S 2", "W 1"]
        System.out.println(Arrays.toString(solution(park, routes)));
    }
}
