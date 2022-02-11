package codes.java.machinelevel.FlipFit.model;

import java.util.List;
import java.util.Objects;

public class DaySlot {
    String date;
    List<Slot> slotList;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<Slot> getSlotList() {
        return slotList;
    }

    public void setSlotList(List<Slot> slotList) {
        this.slotList = slotList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DaySlot daySlot = (DaySlot) o;
        return Objects.equals(date, daySlot.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(date);
    }
}
