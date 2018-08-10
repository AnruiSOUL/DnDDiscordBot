package bot.discord.commands;

import bot.discord.DnDDice;
import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;

public class DiceCommand extends Command {

    public DiceCommand() {
        this.name = "roll";
        this.help = "Rolls dice for: XdX format and provide total";
        this.guildOnly = false;
    }


    @Override
    protected void execute(CommandEvent commandEvent) {
        if (commandEvent.getArgs().isEmpty()) {
            commandEvent.replyWarning("Droop need dice");
        } else {
            String[] numbers = commandEvent.getArgs().split("d", 2);
            int numDice = Integer.parseInt(numbers[0]);
            int sizeDice = Integer.parseInt(numbers[1]);
            commandEvent.replySuccess("Droop rolls " + numDice + " d" + sizeDice + " dice totaling: "
                                        + DnDDice.diceRoll(numDice,sizeDice));
        }

    }


}

