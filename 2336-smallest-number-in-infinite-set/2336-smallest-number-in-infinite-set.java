class SmallestInfiniteSet {
    private int curr ;
    private HashSet<Integer> set;
    private PriorityQueue<Integer>pq;
    public SmallestInfiniteSet() {
        curr = 1;
        set = new HashSet<>();
        pq = new PriorityQueue<>();
    }
    
    public int popSmallest() {
        if(!pq.isEmpty()){
            int x = pq.poll();
            set.remove(x);
            return x;
        }

        return curr++;
    }
    
    public void addBack(int num) {
        if(num < curr && !set.contains(num)){
            set.add(num);
            pq.offer(num);
        }
    }
}

/**
 * Your SmallestInfiniteSet object will be instantiated and called as such:
 * SmallestInfiniteSet obj = new SmallestInfiniteSet();
 * int param_1 = obj.popSmallest();
 * obj.addBack(num);
 */