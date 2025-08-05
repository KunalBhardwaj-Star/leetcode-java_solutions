class Solution {
    public String removeKdigits(String num, int k) {
    Stack<Character> s = new Stack<>();

    for (int i = 0; i < num.length(); i++) {
        char currentDigit = num.charAt(i);

        // Remove previous larger digits if currentDigit is smaller and k > 0
        while (!s.isEmpty() && k > 0 && s.peek() > currentDigit) {
            s.pop();
            k--;
        }

        s.push(currentDigit);
    }

    // If k is still > 0, remove from the end
    while (k > 0 && !s.isEmpty()) {
        s.pop();
        k--;
    }

    // Build the resulting string
    StringBuilder sb = new StringBuilder();
   
    while (!s.isEmpty()) {
        sb.insert(0, s.pop());

    }
    if (sb.length() == 0) {
    return "0";
    }
    
    

    // Remove leading zeros
    while (sb.length() > 1 && sb.charAt(0) == '0') {
        sb.deleteCharAt(0);
    }

    return sb.toString(); 
         }
}