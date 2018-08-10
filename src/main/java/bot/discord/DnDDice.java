package bot.discord;

import java.security.SecureRandom;

public class DnDDice {
    private static final SecureRandom random = new SecureRandom();

    public static Integer diceRoll(Integer n1, Integer n2){
        int total = 0;
        for (int i = 0; i <n1; i++) total += random.nextInt(n2);
        return total;
    }

}
