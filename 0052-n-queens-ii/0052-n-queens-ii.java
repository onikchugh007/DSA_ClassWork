class Solution {

    static int count = 0;

    public int totalNQueens(int n) {

        count = 0;   // IMPORTANT: reset count

        char[][] chessBoard = new char[n][n];

        // Fill board with X
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                chessBoard[i][j] = 'X';
            }
        }

        nQueens(0, chessBoard);

        return count;
    }

    private static void nQueens(int row, char[][] chessBoard) {

        int n = chessBoard.length;

        // Valid solution
        if (row == n) {
            count++;
            return;
        }

        for (int col = 0; col < n; col++) {

            if (canQueenBePlaced(row, col, chessBoard)) {

                chessBoard[row][col] = 'Q';

                nQueens(row + 1, chessBoard);

                chessBoard[row][col] = 'X';
            }
        }
    }

    private static boolean canQueenBePlaced(
            int row, int col, char[][] chessBoard) {

        int n = chessBoard.length;

        // Column
        for (int i = 0; i < row; i++) {
            if (chessBoard[i][col] == 'Q') {
                return false;
            }
        }

        // Upper-left diagonal
        int i = row - 1;
        int j = col - 1;

        while (i >= 0 && j >= 0) {
            if (chessBoard[i][j] == 'Q') {
                return false;
            }
            i--;
            j--;
        }

        // Upper-right diagonal
        i = row - 1;
        j = col + 1;

        while (i >= 0 && j < n) {
            if (chessBoard[i][j] == 'Q') {
                return false;
            }
            i--;
            j++;
        }

        return true;
    }
}