package codes.java.arrays;

import java.util.ArrayList;

public class AddNewInterval {

    static class Interval
    {
        int start, end;
        Interval(int start, int end)
        {
            this.start = start;
            this.end = end;
        }
    }

    ArrayList<Interval> addNewInterval(ArrayList<Interval> intervals, Interval newInterval)
    {
        int i = 0;

        while (i < intervals.size())
        {
            Interval curr = intervals.get(i);
            if(curr.end < newInterval.start)
                i++;
            else
            {
                if(curr.start > newInterval.end)
                {
                    intervals.add(i, newInterval);
                    break;
                }
                else
                {
                    newInterval.start = Math.min(newInterval.start, curr.start);
                    newInterval.end = Math.max(newInterval.end, curr.end);
                    intervals.remove(i);
                }
            }
        }
        return intervals;
    }
}
