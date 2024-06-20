import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class 가장많이받은선물 {

    public static int solution(String[] friends, String[] gifts) {
        Map<String, Map<String, Integer>> recodeMap = new HashMap<>();
        Map<String, Integer> giftScore = new HashMap<>();
        Map<String, Integer> nextMonthGifts = new HashMap<>();


        for (String friend : friends) {
            recodeMap.put(friend, new HashMap<>());
            giftScore.put(friend, 0);
            nextMonthGifts.put(friend, 0);
        }

        for (String gift : gifts) {
            String[] parts = gift.split(" ");
            String giver = parts[0];
            String receiver = parts[1];

            recodeMap.get(giver).put(receiver, recodeMap.get(giver).getOrDefault(receiver, 0) + 1);
            giftScore.put(giver, giftScore.get(giver) + 1);
            giftScore.put(receiver, giftScore.get(receiver) - 1);
        }

        for (String giver : friends) {
            for (String receiver : friends) {
                if (!giver.equals(receiver)) {
                    int giftsFromGiver = recodeMap.get(giver).getOrDefault(receiver, 0);
                    int giftsFromReceiver = recodeMap.get(receiver).getOrDefault(giver, 0);

                    if (giftsFromGiver > giftsFromReceiver) {
                        nextMonthGifts.put(giver, nextMonthGifts.get(giver) + 1);
                    } else if (giftsFromGiver == giftsFromReceiver && giftScore.get(giver) > giftScore.get(receiver)) {
                        nextMonthGifts.put(giver, nextMonthGifts.get(giver) + 1);
                    }
                }
            }
        }

        return Collections.max(nextMonthGifts.values());
    }

    public static void main(String[] args) {

        String[] friends = new String[] {"joy", "brad", "alessandro", "conan", "david"};
        String[] gifts = new String[] {"alessandro brad", "alessandro joy", "alessandro conan", "david alessandro", "alessandro david"};
        System.out.println(solution(friends, gifts));
    }
}
