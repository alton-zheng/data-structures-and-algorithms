class Solution {
    public int maxNumberOfBalloons(String text) {

        int[] count = new int[5];

        for(int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (c == 'b') {
                count[0]++;
            } else if (c == 'a') {
                count[1]++;
            } else if (c == 'l') {
                count[2]++;
            } else if (c == 'o') {
                count[3]++;
            } else if (c == 'n') {
                count[4]++;
            }
        }

        count[2] /= 2;
        count[3] /= 2;

        int result = count[0];
        for (int i = 0; i < 5; i++) {
            result = Math.min(result, count[i]);
        }

        return result;
    }
}