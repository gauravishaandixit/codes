// https://leetcode.com/problems/minimum-cost-to-hire-k-workers/

class Solution {
    public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        ArrayList<Worker> arr = new ArrayList<>();
        for(int i = 0; i < wage.length; i++) {
            arr.add(new Worker(quality[i], wage[i]));
        }
        
        Collections.sort(arr, (a, b) -> Double.compare(a.ratio, b.ratio));
        
        PriorityQueue<Worker> maxHeap = new PriorityQueue<>((a, b) -> b.quality - a.quality);
        double ans = 1e9;
        int sumOfQuality = 0;
        
        for(Worker worker: arr) {
            maxHeap.add(worker);
            sumOfQuality += worker.quality;
            
            if(maxHeap.size() > k)
                sumOfQuality -= maxHeap.poll().quality;
            
            if(maxHeap.size() == k)
                ans = Math.min(ans, sumOfQuality * worker.ratio);
        }
        return ans;
    }
    
    class Worker {
        int quality;
        int wage;
        double ratio;
        
        Worker(int quality, int wage) {
            this.quality = quality;
            this.wage = wage;
            this.ratio = (double) wage/quality;
        }
    }
}
