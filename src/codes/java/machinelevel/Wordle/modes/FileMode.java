package codes.java.machinelevel.Wordle.modes;

import codes.java.machinelevel.Wordle.models.Command;
import codes.java.machinelevel.Wordle.services.WordleService;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class FileMode extends Mode{
    private final String fileName;

    public FileMode(WordleService wordleService, String fileName) {
        super(wordleService);
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
