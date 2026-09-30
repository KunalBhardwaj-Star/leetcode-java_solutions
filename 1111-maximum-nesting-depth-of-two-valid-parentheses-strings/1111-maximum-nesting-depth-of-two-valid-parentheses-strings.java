class Solution {
    public int[] maxDepthAfterSplit(String seq) {
        int len = seq.length();

        Stack<Integer> stack = new Stack<>();

        stack.push(0);

        int[] depth = new int[len];

        depth[0] = 0;

        for(int i = 1 ; i < len ; i++){
            if(seq.charAt(i) == '('){
                depth[i] = stack.isEmpty() ? 0 : depth[stack.peek()] + 1;
                stack.push(i);
            }

            else{
                int idx = stack.pop();
                depth[i] = depth[idx];
            }
        }

        for(int i = 0 ; i < len ; i++){
            depth[i] = depth[i] % 2;
        }

        return depth;
    }
}