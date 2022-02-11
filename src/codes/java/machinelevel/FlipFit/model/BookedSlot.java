package codes.java.machinelevel.FlipFit.model;

import java.util.Objects;

public class BookedSlot {
    String location;
    String name;
    String date;
    String time;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookedSlot that = (BookedSlot) o;
        return Objects.equals(location, that.location) && Objects.equals(name, that.name) && Objects.equals(date, that.date) && Objects.equals(time, that.time);
    }

    @Override
    public int hashCode() {
        return Objects.hash(location, name, date, time);
    }
}
