package codes.java.machinelevel.Wordle.models;

import java.util.HashMap;
import java.util.Map;

public class Users {

    Map<String, Double> users;

    public Users() {
        users = new HashMap<>();
    }

    public boolean addNewUser(String name) {
        if(!users.containsKey(name)) {
            users.put(name, 0.0);
            return true;
        }

        return false;
    }

    public void updateScoreCard(String username, double score) {
        if(users.containsKey(username)) {
            users.put(username, users.get(username) + score);
        } else {
            System.out.println("User Not Found");
        }
    }

    public Map<String, Double> getScores() {
        return users;
    }

    public boolean validUser(String name) {
        return users.containsKey(name);
    }

}
