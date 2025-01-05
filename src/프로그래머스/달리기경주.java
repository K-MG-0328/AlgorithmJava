package 프로그래머스;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class 달리기경주 {
    /*
    Map과 배열을 같이 사용해야함.
    * */
    public static String[] solution(String[] players, String[] callings) {

        Map<String, Integer> playerMap = new HashMap<>();

        for (int i=0; i<players.length; i++) {
            playerMap.put(players[i], i);
        }

        for(String player : callings){
            int playerRank = playerMap.get(player);
            String frontPlayer = players[playerRank-1];
            //추월했을 때
            playerMap.replace(frontPlayer, playerRank);
            players[playerRank] = frontPlayer;

            playerMap.replace(player, playerRank - 1);
            players[playerRank-1] = player;

        }
        return players;
    }

    public static void main(String[] args) {
        String[] players = {"mumu", "soe", "poe", "kai", "mine"};
        String[] callings = {"kai", "kai", "mine", "mine"};
        System.out.println(Arrays.toString(solution(players, callings)));
    }
}
