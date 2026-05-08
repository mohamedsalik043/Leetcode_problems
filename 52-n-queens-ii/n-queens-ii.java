 class Solution {
    public int totalNQueens(int n) {
        boolean[] col = new boolean[n];
        boolean[] diag = new boolean[2 * n];
        boolean[] antidiag = new boolean[2 * n];
        
        return backtrack(0, n, col, diag, antidiag);
    }
    
    private int backtrack(int row, int n, boolean[] col, boolean[] diag, boolean[] antidiag) {
        if (row == n)
        {
            return 1;
        }
        
        int count = 0;
        
        for (int c = 0; c < n; c++) {
            int d = row - c + n;
            int ad = row + c;
            
            if (col[c] || diag[d] || antidiag[ad])
            {
                continue;
            }
            
            col[c] = true;
            diag[d] = true;
            antidiag[ad] = true;
            
            count += backtrack(row + 1, n, col, diag, antidiag);
            
            col[c] = false;
            diag[d] = false;
            antidiag[ad] = false;
        }
        
        return count;
    }
}