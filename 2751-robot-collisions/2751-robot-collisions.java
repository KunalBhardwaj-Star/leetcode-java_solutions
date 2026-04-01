class Solution {
    class Robot {
        int position, health, index;
        char direction;

        Robot(int p, int h, char d, int i) {
            position = p;
            health = h;
            direction = d;
            index = i;
        }
    }

    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        int len = positions.length;

        Robot[] robots = new Robot[len];

        for (int i = 0; i < len; i++) {
            robots[i] = new Robot(positions[i], healths[i], directions.charAt(i), i);
        }

        Arrays.sort(robots, (a, b) -> a.position - b.position);

        Stack<Robot> stack = new Stack<>();

        for (Robot curr : robots) {
            if (curr.direction == 'R') {
                stack.push(curr);
            } else {
                while (!stack.isEmpty() && stack.peek().direction == 'R') {
                    Robot top = stack.peek();

                    if (top.health < curr.health) {
                        stack.pop();
                        curr.health--;
                    } else if (top.health > curr.health) {
                        top.health--;
                        curr = null;
                        break;
                    } else {
                        stack.pop();
                        curr = null;
                        break;
                    }
                }

                if (curr != null) {
                    stack.push(curr);
                }
            }
        }

        int[] result = new int[len];

        for (Robot r : stack) {
            result[r.index] = r.health;
        }

        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i < len; i++) {
            if (result[i] > 0) {
                ans.add(result[i]);
            }
        }

        return ans;
    }
}