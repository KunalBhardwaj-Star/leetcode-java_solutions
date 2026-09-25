class Solution {

    private int idx = 0;

    public List<String> braceExpansionII(String expression) {
        Set<String> ans = parse(expression);
        return new ArrayList<>(ans);
    }

    private Set<String> parse(String s) {

        Set<String> res = new TreeSet<>();
        Set<String> cur = new TreeSet<>();

        cur.add("");

        while (idx < s.length() && s.charAt(idx) != '}') {

            char ch = s.charAt(idx);

            if (ch == ',') {

                res.addAll(cur);

                cur = new TreeSet<>();
                cur.add("");

                idx++;
            }
            else {

                Set<String> next;

                if (ch == '{') {

                    idx++;                 // skip '{'
                    next = parse(s);
                    idx++;                 // skip '}'
                }
                else {

                    next = new TreeSet<>();
                    next.add(String.valueOf(ch));
                    idx++;
                }

                cur = product(cur, next);
            }
        }

        res.addAll(cur);

        return res;
    }

    private Set<String> product(Set<String> a, Set<String> b) {

        Set<String> res = new TreeSet<>();

        for (String s1 : a) {
            for (String s2 : b) {
                res.add(s1 + s2);
            }
        }

        return res;
    }
}