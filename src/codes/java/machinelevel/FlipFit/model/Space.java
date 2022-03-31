package codes.java.machinelevel.FlipFit.model;

import java.util.Objects;

public class Space {
    String location;

    public Space(String location) {
        this.location = location;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Space space = (Space) o;
        return Objects.equals(location, space.location);
    }

    @Override
    public int hashCode() {
        return Objects.hash(location);
    }

}
