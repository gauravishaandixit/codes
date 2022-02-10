package codes.java.machinelevel.PropertyHunt.modes;

import codes.java.machinelevel.PropertyHunt.commands.CommandExecutorFactory;
import codes.java.machinelevel.PropertyHunt.model.Command;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class FileMode extends Mode{
    private final String fileName;

    public FileMode(CommandExecutorFactory commandExecutorFactory, String fileName) {
        super(commandExecutorFactory);
        this.fileName = fileName;
    }

    @Override
    public void process() {
        final File file = new File(fileName);
        final BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(file));
        } catch (FileNotFoundException e) {
            System.out.println(e);
            return;
        }

        try {
            String input = reader.readLine();
            while (input != null) {
                final Command command = new Command(input);
                processCommand(command);
                input = reader.readLine();
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
