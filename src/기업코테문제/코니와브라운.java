//코니와 브라운
//게임 조건 -
//브라운이 코니를 잡거나 코니가 멀리 달아나거나 게임이 끝나는데 걸리는 '최소시간'을 구하시오

//코니 - 처음위치에서 1초 마다 1만큼 움직이고 매 초마다 이전이동거리 + 1만큼 움직인다.
// c, c+1, c+3, c+6 <  c라는 위치에서 1초에는 1만큼 2초에는 3만큼 1+2니까 3초에는 6만큼 3+3 이니까 라는 의미구나

//브라운 - b-1, b+1, 2*b 중 하나로 움직일 수 있다.
//큐가 나온거보니까 이거 bfs로 푸는 문제인거같다

//  c=11
//  b=2

// 0초 일 때  c=11 b=2
// 1초 일 때  c=12 b= 1,3,4
// 2초 일 때  c=14 b = [0,2,2] [2,4,6] [3,5,8]
// 3초 일 때  c=17 b = ...

package 기업코테문제;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class 코니와브라운 {

    public static int catchMe(int cony, int brown) {
        int time = 0;

        //브라운의 next 위치를 저장할 queue 사용
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{brown, time});

        while(cony <= 200_000){
            cony = cony + time;

            //bfs
            //q.size가 반복문내에서 동적으로 변경이 되므로 고정값을 구해놔야함.
            for(int i = 0, size = q.size() ; i < size; i++){
                //q에 넣은 값을 poll
                int[] posTime = q.poll();
                int currPos = posTime[0];
                int currTime = posTime[1];

                if(cony == currPos){
                    return time;
                }

                //다음 초에 브라운의 위치
                int nextPos[] = {currPos - 1, currPos + 1, currPos * 2};
                for(int pos : nextPos){
                    q.offer(new int[]{pos, currTime + 1});
                }
            }
            time++;
        }

        return -1;
    }


//    public static int catchMe(int cony_loc, int brown_loc){
//        int time = 0;
//        Queue<int[]> q = new LinkedList<>();  //map<위치, 시간>
//        q.add(new int[]{brown_loc,0});
//
//
//        //방문한 위치에 도달할 가능성이 있는 시간대를 map 객체 안에 모두 집어넣는다.
//        //배열의 인덱스는 위치, 맵의 키 값은 해당 위치에 도달 가능한 시간
//        Map<Integer, Boolean>[] visitied = new HashMap[200010];
//        for (int i = 0; i < visitied.length; i++) {
//            visitied[i] = new HashMap<>();
//        }
//
//        while(cony_loc <= 200000){
//            cony_loc += time;
//
//            if(visitied[cony_loc].containsKey(time)){
//                return time;
//            }
//
//            //for문안에서 초기 q사이즈를 저장한 다음에 반복문 조건문으로 넣게되면 중간에 q.offer하여서 q.size가 변경이 되더라도
//            //초기의 q.size로만 반복문을 할 수 있게된다.
//            for(int i=0, initialSize = q.size(); i< initialSize; i++){
//                int[] info = q.poll();
//                int currentPosition = info[0];
//                int currentTime = info[1];
//
//                int newTime = currentTime + 1;
//                int newPosition ;
//
//                newPosition = currentPosition - 1;
//                if(0<= newPosition && newPosition <= 200000) {
//                    visitied[newPosition].put(newTime, true);
//                    q.offer(new int[]{newPosition, newTime});
//                }
//                newPosition = currentPosition + 1;
//                if(0<= newPosition && newPosition <= 200000) {
//                    visitied[newPosition].put(newTime, true);
//                    q.offer(new int[]{newPosition, newTime});
//                }
//                newPosition = currentPosition * 2;
//                if(0<= newPosition && newPosition <= 200000) {
//                    visitied[newPosition].put(newTime, true);
//                    q.offer(new int[]{newPosition, newTime});
//                }
//            }
//            time++;
//        }
//        return -1;
//    }

    public static void main(String[] args) {
        int c=3;
        int b=2;

        // 0
        // c 3
        // b 2
        // 1
        // c 4
        // b 1 3 4
        System.out.println(catchMe(c, b));
    }
}
