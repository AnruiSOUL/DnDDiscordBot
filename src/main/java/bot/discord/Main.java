package bot.discord;

import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.OnlineStatus;
import net.dv8tion.jda.core.exceptions.RateLimitedException;

import javax.security.auth.login.LoginException;
import java.io.File;

public class Main {
    public static JDA jda;
    public static void main(String[] args) {
        ClassLoader classLoader = Main.class.getClassLoader();
        File token = new File(classLoader.getResource("token.txt").getFile());
        JDABuilder builder = new JDABuilder(AccountType.BOT);
        builder.setToken(token.toString());
        builder.setAutoReconnect(true);
        builder.setStatus(OnlineStatus.DO_NOT_DISTURB);

        try {
            jda = builder.buildBlocking();
        } catch (LoginException e) {
            e.printStackTrace();
        } catch (InterruptedException e){
            e.printStackTrace();
        }catch (RateLimitedException e){
            e.printStackTrace();

        }
    }
}
