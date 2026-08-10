class FreqStack {
    HashMap<Integer , Integer> freq;
    HashMap<Integer , Stack<Integer>> grp;
    int maxFreq;

    public FreqStack() {
        freq = new HashMap<>();
        grp = new HashMap<>();
        maxFreq = 0;
    }
    
    public void push(int val) {
        int f = freq.getOrDefault(val , 0) + 1;
        freq.put(val , f);

        maxFreq = Math.max(maxFreq , f);

        grp.putIfAbsent(f , new Stack<>());
        grp.get(f).push(val);
    }
    
    public int pop() {
        Stack<Integer> curr = grp.get(maxFreq);
        int val = curr.pop();

        freq.put(val, freq.get(val) - 1);

        if(curr.isEmpty())
            maxFreq--;

        return val;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */