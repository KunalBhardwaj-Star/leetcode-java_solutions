class Fancy {
    int [] arr;
    int i ;

    public Fancy() {
        arr = new int[100001];
        Arrays.fill(arr , -1);
        i = 0;
    }
    
    public void append(int val) {
        arr[i++] = val;
    }
    
    public void addAll(int inc) {
        for(int j = 0 ; j < i ; j++){
            arr[j] += inc;
        }
    }
    
    public void multAll(int m) {
        for(int j = 0 ; j < i ; j++){
            arr[j] *= m;
        }
    }
    
    public int getIndex(int idx){ 
        return arr[idx] % (1000000007);
    }
}

/**
 * Your Fancy object will be instantiated and called as such:
 * Fancy obj = new Fancy();
 * obj.append(val);
 * obj.addAll(inc);
 * obj.multAll(m);
 * int param_4 = obj.getIndex(idx);
 */