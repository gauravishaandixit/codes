package codes.java.hashing;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;

public class LRUCache {

    Deque<Integer> dq;
    HashMap<Integer, Integer> map;
    int capacity;
    LRUCache(int capacity)
    {
        dq = new LinkedList<>();
        map = new HashMap<>();
        this.capacity = capacity;
    }

    void put(int key, int value)
    {
        if(dq.size() != capacity)
        {
            dq.addFirst(key);
            map.put(key, value);
        }
        else
        {
            if(map.containsKey(key))
            {
                dq.remove(key);
                dq.addFirst(key);
            }
            else
            {
                int removedKey = dq.removeLast();
                map.remove(removedKey);
                map.put(key, value);
                dq.addFirst(key);
            }
        }
    }

    int get(int key)
    {
        if(map.containsKey(key))
        {
            dq.remove(key);
            dq.addFirst(key);
            return map.get(key);
        }
        else
            return -1;
    }

    void printCache()
    {
        System.out.println(dq);
        System.out.println(map);
        System.out.println();
    }

    public static void main(String[] args)
    {
        LRUCache lru = new LRUCache(5);
        lru.put(11,34);
        lru.put(12,99);
        lru.put(13,76);
        lru.put(14,65);
        lru.put(15,43);

        lru.printCache();

        System.out.println("13:: "+lru.get(13));
        System.out.println("12:: "+lru.get(12));

        lru.printCache();

        lru.put(28, 79);
        lru.printCache();
    }
}
