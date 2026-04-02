class Solution {
    class Robot{
        int pos , heal , idx;
        char dir;
        Robot(int p , int h , int i , char d){
            this.pos = p;
            this.heal = h;
            this.idx = i;
            this.dir = d;
        }
    }
    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        int len = positions.length;
        Robot[] R = new Robot[len];

        for(int i = 0 ; i < len ; i++){
            int p = positions[i] , h = healths[i];
            char d = directions.charAt(i);
            Robot curr = new Robot(p , h , i , d);
            R[i] = curr;
        }

        Arrays.sort(R , (a , b) -> a.pos - b.pos);

        Stack<Robot> st = new Stack<>();

        for(Robot curr : R){
            if(curr.dir == 'R') st.push(curr);
            else {
                while(!st.isEmpty() && st.peek().dir == 'R'){
                    Robot top = st.peek();
                    if(top.heal < curr.heal){
                        st.pop();
                        curr.heal--;
                    }
                    else if(top.heal > curr.heal){
                        top.heal--;
                        curr = null;
                        break;
                    }
                    else{
                        st.pop();
                        curr = null;
                        break;
                    }
                }

                if(curr != null) st.push(curr);
            }
        }

        int[] result = new int[len];

        for(Robot r : st){
            result[r.idx] = r.heal;
        }

        ArrayList<Integer> ans = new ArrayList<>();

        for(int c : result){
            if(c > 0) ans.add(c);
        }

        return ans;
    }
}