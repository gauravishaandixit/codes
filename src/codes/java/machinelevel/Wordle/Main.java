package codes.java.machinelevel.Wordle;

import codes.java.machinelevel.Wordle.commandexecutors.CommandExecutorFactory;
import codes.java.machinelevel.Wordle.modes.FileMode;
import codes.java.machinelevel.Wordle.modes.HardCodedMode;
import codes.java.machinelevel.Wordle.modes.InteractiveMode;
import codes.java.machinelevel.Wordle.services.WordleService;

public class Main {

    public static void main(String[] args) {

        WordleService wordleService = new WordleService();
        CommandExecutorFactory commandExecutorFactory = new CommandExecutorFactory(wordleService);

        if (isInteractiveMode(args)) {
            new InteractiveMode(commandExecutorFactory).process();
        } else {
            if (isHardCodedMode(args)) {
                new HardCodedMode(wordleService, commandExecutorFactory).process();
            } else {
                if (isFileMode(args)) {
                    new FileMode(commandExecutorFactory, args[0]).process();
                } else {
                    System.out.println("Invalid Mode");
                }
            }
        }

    }

    static private boolean isInteractiveMode(String[] args) {
        return args.length == 1 && args[0].equals("0");
    }

    static private boolean isHardCodedMode(String[] args) {
        return args.length == 1 && args[0].equals("1");
    }

    static private boolean isFileMode(String[] args) {
        return args.length == 1;
    }
}
