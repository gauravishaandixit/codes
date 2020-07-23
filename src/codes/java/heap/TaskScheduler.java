package codes.java.heap;

//https://leetcode.com/problems/task-scheduler/

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class TaskScheduler {
    public int leastInterval(char tasks[], int n)
    {
        if(tasks == null || tasks.length == 0)
            return 0;

        Map<Character, Integer> taskFreq = new HashMap<>();
        for(char task: tasks)
            taskFreq.put(task, taskFreq.getOrDefault(task, 0)+ 1);

        Queue<Map.Entry<Character, Integer>> maxHeap = new PriorityQueue<>((a,b) -> b.getValue() - a.getValue());
        maxHeap.addAll(taskFreq.entrySet());
        int totalInterval = 0;

        while(!maxHeap.isEmpty())
        {
            int slot = n + 1;
            taskFreq.clear();
            while(slot > 0 && !maxHeap.isEmpty())
            {
                Map.Entry<Character, Integer> entry = maxHeap.poll();

                if(entry.getValue() > 1)
                    taskFreq.put(entry.getKey(), entry.getValue() - 1);

                slot--;
                totalInterval++;
            }

            maxHeap.addAll(taskFreq.entrySet());

            if(maxHeap.isEmpty())
                break;

            if(slot > 0)
                totalInterval += slot;
        }
        return totalInterval;
    }

    public static void main(String[] args)
    {
        char tasks[] = new char[]{'A','A','A','B','B','B'};
        int n = 2;
        System.out.println(new TaskScheduler().leastInterval(tasks, n));

        tasks = new char[]{'A','A','A','B','B','B'};
        n = 0;
        System.out.println(new TaskScheduler().leastInterval(tasks, n));

        tasks = new char[]{'A','A','A','A','A','A','B','C','D','E','F','G'};
        n = 2;
        System.out.println(new TaskScheduler().leastInterval(tasks, n));

    }
}
