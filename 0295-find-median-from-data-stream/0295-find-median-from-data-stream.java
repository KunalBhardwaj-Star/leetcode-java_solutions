class MedianFinder {
    PriorityQueue<Integer> left = new PriorityQueue<>(Collections.reverseOrder());
    PriorityQueue<Integer> right = new PriorityQueue<>();

    public MedianFinder() {
        
    }
    
    public void addNum(int num) {
        left.add(num);

        right.add(left.poll());

        if(left.size() < right.size()) left.add(right.poll());
    }
    
    public double findMedian() {
        if(left.size() > right.size()) return (double) left.peek();
        else return ((double)left.peek() + (double)right.peek()) / 2.0;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */