class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        int n = words.length;
        List<String> answer = new ArrayList<>();

        int i = 0;

        while(i < n){
            int j = i;

            int wordsLen = 0;

            while(j < n && 
                wordsLen + words[j].length() + (j - i) <= maxWidth){
                wordsLen += words[j].length();
                j++;
            }

            int gaps = j - i - 1;
            StringBuilder sb = new StringBuilder();

            if(j == n || gaps == 0){
                for(int k = i ; k < j ; k++){
                    sb.append(words[k]);
                    
                    if(k < j-1)
                        sb.append(" ");
                }

                while(sb.length() < maxWidth){
                    sb.append(" ");
                }
            }

            else{
                int totalSpace = maxWidth - wordsLen;

                int spacePerGap = totalSpace / gaps;
                int extraSpaces = totalSpace % gaps;

                for(int k = i ; k < j ; k++){
                    sb.append(words[k]);

                    if(k < j-1){
                        for (int s = 0; s < spacePerGap; s++) {
                            sb.append(" ");
                        }

                        if (extraSpaces > 0) {
                            sb.append(" ");
                            extraSpaces--;
                        }
                    }
                }
            }

            answer.add(sb.toString());
            i = j;
        }

        return answer;
    }
}