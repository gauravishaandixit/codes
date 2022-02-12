package codes.java.machinelevel.Wordle.modes;

import codes.java.machinelevel.Wordle.commandexecutors.CommandExecutorFactory;
import codes.java.machinelevel.Wordle.models.Command;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class InteractiveMode extends Mode{

    public InteractiveMode(CommandExecutorFactory commandExecutorFactory) {
        super(commandExecutorFactory);
    }

    @Override
    public void process() {
        try{
            System.out.println("\n\n===================== Welcome To PropertyHunter =====================");
            System.out.println("\n\nEnter Commands\n");
            final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            while (true) {
                final String input = reader.readLine();
                final Command command = new Command(input);
                processCommand(command);
                if (command.getCommandName().equalsIgnoreCase("exit")) {
                    System.exit(0);
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
