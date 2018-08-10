package bot.discord;

import java.security.SecureRandom;

public class DnDCharacterRandomizer {
    private static final SecureRandom random = new SecureRandom();

    private static <T extends Enum<?>> T randomize(Class<T> description){
        int randomClazz = random.nextInt(description.getEnumConstants().length);
        return description.getEnumConstants()[randomClazz];
    }
    public static String characterRandomized(){

        return  "play a " + randomize(Std5eRaces.class) + " " + randomize(Std5eClasses.class) + " who is a "
                + randomize(Std5eBackgrounds.class);
    }

}
