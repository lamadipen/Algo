package kata.moderate.TicTacWin;

public class Solution3By3Board {


    public Piece isWinner(Piece[][] pieces) {

        for (int i = 0; i < pieces.length; i++) {
            if (hasWinner(pieces[i][0], pieces[i][1], pieces[i][2])) {
                return pieces[i][0];
            }

            if (hasWinner(pieces[0][i], pieces[1][i], pieces[2][i])) {
                return pieces[0][i];
            }
        }

        if (hasWinner(pieces[0][0], pieces[1][1], pieces[2][2])) {
            return pieces[0][0];
        }

        if (hasWinner(pieces[0][2], pieces[1][1], pieces[2][0])) {
            return pieces[1][1];
        }
        return Piece.EMPTY;
    }

    private boolean hasWinner(Piece p1, Piece p2, Piece p3) {
        if (p1 == Piece.EMPTY || p2 == Piece.EMPTY || p3 == Piece.EMPTY) {
            return false;
        }
        if (p1 == p2 && p2 == p3) {
            return true;
        }
        return false;
    }

}


