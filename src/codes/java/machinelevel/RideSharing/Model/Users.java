package codes.java.machinelevel.RideSharing.Model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Users {
    Set<String> users;

    public Users() {
        users = new HashSet<>();
    }

    public void addUser(String name) {
        users.add(name);
    }
}
