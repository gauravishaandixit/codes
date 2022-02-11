package codes.java.machinelevel.FlipFit.model;

import java.util.Objects;

public class User {
    String name;

    public User() {
    }

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        return this.name.equals(((User) o).name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
