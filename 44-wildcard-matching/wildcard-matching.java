class Solution {
    public boolean isMatch(String s, String p) {
        int n = s.length();
        int m = p.length();

        int dp[][] = new int[n+1][m+1];

        for(int i = 0; i <= n; i++){
            Arrays.fill(dp[i], -1);
        }

        return help(s, p, 0, 0, dp) == 1;
    }

    public int help(String s, String p, int i, int j, int dp[][]){

        // both finished
        if(i == s.length() && j == p.length()) return 1;

        // pattern finished but string not
        if(j == p.length()) return 0;

        // string finished
        if(i == s.length()){
            for(int k = j; k < p.length(); k++){
                if(p.charAt(k) != '*') return 0;
            }
            return 1;
        }

        if(dp[i][j] != -1) return dp[i][j];

        int ans = 0;

        // match or '?'
        if(s.charAt(i) == p.charAt(j) || p.charAt(j) == '?'){
            if(help(s, p, i+1, j+1, dp) == 1){
                ans = 1;
            }
        }

        // '*' case
        else if(p.charAt(j) == '*'){
            // ignore '*'
            if(help(s, p, i, j+1, dp) == 1){
                ans = 1;
            }
            // take one char
            else if(help(s, p, i+1, j, dp) == 1){
                ans = 1;
            }
        }

        return dp[i][j] = ans;
    }
}