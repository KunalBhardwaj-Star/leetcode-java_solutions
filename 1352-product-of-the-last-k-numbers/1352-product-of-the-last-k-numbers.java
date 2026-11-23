class ProductOfNumbers {
    ArrayList<Integer> prefixProduct;
    public ProductOfNumbers() {
        prefixProduct = new ArrayList<>();
    }
    
    public void add(int num) {
        if(num == 0){
            prefixProduct.clear();
            return;
        }

        if(prefixProduct.size() == 0) prefixProduct.add(num);
        else {
            int pro = prefixProduct.get(prefixProduct.size() - 1) * num;
            prefixProduct.add(pro);
        }
    }
    
    public int getProduct(int k) {
        int n = prefixProduct.size();

        if(k > n)
            return 0;

        if(k == n) return prefixProduct.get(n-1);

        else{
            int product = prefixProduct.get(n - 1) / prefixProduct.get(n - k - 1);
            return product;
        }
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */