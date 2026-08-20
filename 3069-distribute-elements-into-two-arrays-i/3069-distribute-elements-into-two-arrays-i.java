class Solution {
    public int[] resultArray(int[] nums) {
        int n = nums.length;

        ArrayList<Integer> arr1 = new ArrayList<>();
        ArrayList<Integer> arr2 = new ArrayList<>();

        arr1.add(nums[0]);
        arr2.add(nums[1]);

        for(int i = 2; i < n ; i++){
            if(arr1.get(arr1.size() - 1) > arr2.get(arr2.size() - 1))
                arr1.add(nums[i]);

            else
                arr2.add(nums[i]);
        }

        int p1 = 0 , p2 = 0;

        int[] ans = new int[n];

        int x = 0;

        while(p1 < arr1.size()){
            ans[x++] = arr1.get(p1++);
        }

        while(p2 < arr2.size()){
            ans[x++] = arr2.get(p2++);
        }

        return ans;
    }
}