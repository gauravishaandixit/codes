package codes.java.machinelevel.PropertyHunt.model;

import java.util.HashSet;
import java.util.Set;

public class Users {
    Set<String> usersSet;

    public Users(){
        usersSet = new HashSet<>();
    }

    public boolean addUser(String userName) {
        return usersSet.add(userName);
    }
}
