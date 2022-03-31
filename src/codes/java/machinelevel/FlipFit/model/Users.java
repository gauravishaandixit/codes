package codes.java.machinelevel.FlipFit.model;

import java.util.HashSet;
import java.util.Set;

public class Users {
    Set<User> userSet;

    public Users() {
        userSet = new HashSet<>();
    }

    public boolean addNewUser(String name) {
        return userSet.add(new User(name));
    }

}
