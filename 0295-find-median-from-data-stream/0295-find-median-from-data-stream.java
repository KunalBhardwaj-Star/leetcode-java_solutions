class MedianFinder {
    PriorityQueue<Integer> leftMax = new PriorityQueue<>(Collections.reverseOrder());
    PriorityQueue<Integer> rightMin = new PriorityQueue<>();

    public MedianFinder() {
        
    }
    
    public void addNum(int num) {
        leftMax.add(num);
        rightMin.add(leftMax.poll());

        if(leftMax.size() < rightMin.size()){
            leftMax.add(rightMin.poll());
        }
    }
    
    public double findMedian() {
        if(leftMax.size() > rightMin.size()) return leftMax.peek();
        return (leftMax.peek() + rightMin.peek()) / 2.0;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */