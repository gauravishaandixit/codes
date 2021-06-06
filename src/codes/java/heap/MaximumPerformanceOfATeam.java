// https://leetcode.com/problems/maximum-performance-of-a-team/

class Solution {
    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        ArrayList<Engineer> engineers = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            engineers.add(new Engineer(speed[i], efficiency[i]));
        }
        
        Collections.sort(engineers, (a, b) -> b.efficiency - a.efficiency);
        
        PriorityQueue<Engineer> minHeap = new PriorityQueue<>((a, b) -> a.speed - b.speed);
        long totalSpeed = 0, ans = Long.MIN_VALUE;
        
        for(Engineer engineer: engineers) {
            minHeap.add(engineer);
            totalSpeed += engineer.speed;
            
            if(minHeap.size() > k) {
                Engineer removed = minHeap.poll();
                totalSpeed -= removed.speed;
            }
            
            ans = Math.max(ans, totalSpeed * engineer.efficiency);
        }
        return (int)(ans % ((int) 1e9 + 7));
    }
    
    class Engineer {
        int speed;
        int efficiency;
        
        Engineer(int speed, int efficiency) {
            this.speed = speed;
            this.efficiency = efficiency;
        }
    }
}
