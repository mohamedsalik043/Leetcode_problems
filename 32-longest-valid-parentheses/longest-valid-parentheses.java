class Solution {
    public int longestValidParentheses(String s) {
        int cnt = 0;
        int len = 0;
        int left = -1;

        // Left to Right
        for(int i = 0; i < s.length(); i++) {
            if(cnt < 0) {
                left = i - 1;
                cnt = 0;
            }

            if(s.charAt(i) == ')') cnt--;
            else cnt++;

            if(cnt == 0) {
                len = Math.max(len, i - left);
            }
        }

        int right = s.length();
        cnt = 0;

        // Right to Left
        for(int i = s.length() - 1; i >= 0; i--) {
            if(cnt < 0) {
                right = i + 1;
                cnt = 0;
            }

            if(s.charAt(i) == ')') cnt++;
            else cnt--;

            if(cnt == 0) {
                len = Math.max(len, right - i);
            }
        }

        return len;
    }
}