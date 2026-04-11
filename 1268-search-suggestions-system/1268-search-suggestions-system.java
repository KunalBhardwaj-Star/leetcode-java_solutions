import java.util.*;

class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Arrays.sort(products); 
        
        List<List<String>> result = new ArrayList<>();
        String prefix = "";

        for(char c : searchWord.toCharArray()){
            prefix += c;

            int start = lowerBound(products, prefix); 

            List<String> suggestions = new ArrayList<>();

            for(int i = start; i < Math.min(start + 3, products.length); i++){
                if(products[i].startsWith(prefix)){
                    suggestions.add(products[i]);
                } else break;
            }

            result.add(suggestions);
        }

        return result;
    }

    private int lowerBound(String[] arr, String target){
        int left = 0, right = arr.length;

        while(left < right){
            int mid = (left + right) / 2;

            if(arr[mid].compareTo(target) < 0){
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }
}